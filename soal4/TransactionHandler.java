import java.lang.reflect.Field;

public class TransactionHandler {
    private Buyer pembeli;
    private Product produk;
    private Courier kurir;

    public TransactionHandler(Buyer pembeli, Product produk, Courier kurir) {
        this.pembeli = pembeli;
        this.produk = produk;
        this.kurir = kurir;
    }

    public void execute() throws TransactionFailedException {
        try {
            pembeli.substractSaldo(produk.getPrice() + kurir.checkPrice(produk.getPosition(), pembeli.getPosition()));
            produk.decrementStock();
            kurir.addToQueue(produk, pembeli, produk);
        } catch (ProductOutOfStockException e) {
            // return the original saldo
            try {
                Field saldo = pembeli.getClass().getDeclaredField("saldo");
                saldo.setAccessible(true);
                saldo.set(pembeli, (int)saldo.get(pembeli) + produk.getPrice() + kurir.checkPrice(produk.getPosition(), pembeli.getPosition()));
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
                // DO NOTHING
            }
            throw new TransactionFailedException("Transaksi gagal");
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}