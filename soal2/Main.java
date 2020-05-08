class Main {
    public static void main(String args[]) {
        Buyer akun_buyer = new Buyer("nama", new Position(0, 0), 15);
        try {
            akun_buyer.substractSaldo(12);
            akun_buyer.substractSaldo(3);
            akun_buyer.substractSaldo(0);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}