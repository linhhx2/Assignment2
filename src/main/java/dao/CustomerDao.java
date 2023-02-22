package dao;

import model.Customer;

public interface CustomerDao {
    void updateById(Customer c);
    String getNameById(String id);
    void printCustomers();
}
