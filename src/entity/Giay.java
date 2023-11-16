package entity;

public class Giay {
     private String id,ma_giay,name;

    public Giay() {
    }

    public Giay(String id, String ma_giay, String name) {
        this.id = id;
        this.ma_giay = ma_giay;
        this.name = name;
    }

    public Giay(String ma_giay, String name) {
        this.ma_giay = ma_giay;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa_giay() {
        return ma_giay;
    }

    public void setMa_giay(String ma_giay) {
        this.ma_giay = ma_giay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
     
}
