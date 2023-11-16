package entity;

public class KichCo {
     private String id;
     private int size;

    public KichCo() {
    }

    public KichCo(String id, int size) {
        this.id = id;
        this.size = size;
    }

    public KichCo(int size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
     
     
}
