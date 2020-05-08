public class Main {
    public static void main(String[] args) {
        Courier kurir = new Courier(1000, new Position(0, 0));
        kurir.addToQueue(new Buyer("seller", new Position(5, 6), 10000),new Buyer("buyer", new Position(6, 5), 20000), new Product(5000, 3, new Position(5, 5)));
        kurir.addToQueue(new Buyer("seller", new Position(5, 5), 12000),new Buyer("buyer", new Position(6, 6), 25000), new Product(1000, 1, new Position(10, 10)));
        System.out.println(kurir.checkPrice(new Position(1, 0), new Position(3, 0)));
        kurir.send();
        kurir.send();
        kurir.send();
    }
}