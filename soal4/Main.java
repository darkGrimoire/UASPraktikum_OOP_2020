public class Main {
    public static void main(String[] args) {
        TransactionHandler transaksi1 = new TransactionHandler(new Buyer("pembeli", new Position(3, 0), 10000),
                new Product(2000, 3, new Position(5, 0)), new Courier(1000, new Position(0, 0)));
        TransactionHandler transaksi2 = new TransactionHandler(new Buyer("pembeli", new Position(3, 0), 24000),
                new Product(2000, 1, new Position(5, 0)), new Courier(1000, new Position(0, 0)));
        try {
            transaksi1.execute();
            transaksi2.execute();
            transaksi2.execute();
        } catch (TransactionFailedException e) {
            e.printStackTrace();
        }
    }
}