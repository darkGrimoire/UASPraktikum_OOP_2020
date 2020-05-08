import java.util.LinkedList;
import java.util.Queue;

public class Courier implements HasPosition {
    private int multiplier;
    private Position alamat;
    private Queue<Product> queue;

    public Courier(int multiplier, Position alamat){
        this.multiplier = multiplier;
        this.alamat = alamat;
        this.queue = new LinkedList<>();
    }

    public void addToQueue(HasPosition asal, HasPosition tujuan, Product produk){
        queue.add(produk);
    }

    public void send(){
        if (!queue.isEmpty()){
            System.out.println("AvatarDuel "+queue.peek().getPrice()+" berhasil dikirim");
            queue.remove();
        }
    }

    public int checkPrice(Position asal, Position tujuan){
        return multiplier * (alamat.distanceTo(asal) + asal.distanceTo(tujuan) + tujuan.distanceTo(alamat));
    }

    @Override
    public Position getPosition() {
        return alamat;
    }

    @Override
    public void setPosition(Position p) {
        this.alamat = p;
    }

}