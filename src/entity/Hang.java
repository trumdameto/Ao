package entity;

public class Hang {
    private String id,name;

    public Hang(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hang(String name) {
        this.name = name;
    }
    
    public Hang() {
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
