package model;

public class Order {
    private String id;
    // TODO: add more fields
    private String customerId;
    private String customerName;
    private String productId;
    private String date;
    private Boolean completed;

    public Order(String id, String customerId, String customerName) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s", id, customerId, productId, date, completed);
    }
    public String toStringWithCustomerName() {
        return String.format("%s,%s,%s,%s,%s,%s", id, customerId, customerName, productId, date, completed);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
