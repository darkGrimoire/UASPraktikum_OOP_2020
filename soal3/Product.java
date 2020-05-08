public class Product implements HasPosition {
    private int harga_produk;
    private int stok_tersedia;
    private Position pos_gudang;

    public Product(int harga, int stok, Position gudang){
        this.harga_produk = harga;
        this.stok_tersedia = stok;
        this.pos_gudang = gudang;
    }

    public void decrementStock() throws ProductOutOfStockException {
        if (stok_tersedia==0){
            throw new ProductOutOfStockException("Produk ini kosong");
        }
        else{
            this.stok_tersedia--;
        }
    }

    public int getPrice(){
        return harga_produk;
    }

    @Override
    public Position getPosition() {
        return pos_gudang;
    }

    @Override
    public void setPosition(Position p) {
        this.pos_gudang = p;
    }
}