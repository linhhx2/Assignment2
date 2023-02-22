package model;

public class Customer {
    private String id;
    private String name;
    private String location;
    private String phone;


    public Customer(String id, String name, String location, String phone) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s", id, name, location, phone);
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
