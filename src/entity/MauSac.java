package entity;

public class MauSac {

    private String id, name;

    public MauSac() {
    }

    public MauSac(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public MauSac(String name) {
        this.name = name;
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
