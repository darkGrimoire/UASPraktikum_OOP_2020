public abstract class Account implements HasPosition{
    protected String nama;
    protected Position alamat;

    public Account(String nama, Position alamat){
        this.nama = nama;
        this.alamat = alamat;
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