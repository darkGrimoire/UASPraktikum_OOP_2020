public class Buyer extends Account{
    private int saldo;

    public Buyer(String nama, Position alamat, int saldo) {
        super(nama, alamat);
        this.saldo = saldo;
    }

    public void substractSaldo(int x) throws NotEnoughMoneyException {
        if (saldo < x){
            throw new NotEnoughMoneyException("Membutuhkan uang "+x+" sedangkan saldo hanya "+saldo);
        }else{
            this.saldo -= x;
        }
    }
}