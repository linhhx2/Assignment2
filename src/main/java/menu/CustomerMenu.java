package menu;

import global.Global;
import io.CustomerReader;
import model.Customer;

import java.util.Scanner;

public class CustomerMenu implements Menu {
    private Menu parent;
    private CustomerReader cr = new CustomerReader();
    @Override
    public Menu run() {

        System.out.println("--- Customer Menu ---");
        System.out.println("1: Print all");
        System.out.println("...");
        System.out.println("5: Update customer");
        System.out.println("6. Back");
        System.out.println("-----------------");
        System.out.print("Select: ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                Global.customerDao.printCustomers();
                return this;
            case "2":
                // TODO
                return this;
            case "5":
                String customerId = cr.readCustomerId();
                String newName = cr.readCustomerName();
                // TODO: read other info
                Customer tmp = new Customer(customerId, newName, "", "");
                Global.customerDao.updateById(tmp);
                return this;
            case "6":
                // TODO
                return parent;
            default:
                return this;
        }
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
