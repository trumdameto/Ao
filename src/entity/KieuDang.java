package entity;

public class KieuDang {
     private String id,name;

    public KieuDang(String name) {
        this.name = name;
    }

    public KieuDang(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public KieuDang() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
}
