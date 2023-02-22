package menu;

import global.Global;
import model.Customer;

import java.util.Scanner;

public class OrderMenu implements Menu {
    private Menu parent;
    @Override
    public Menu run() {
        System.out.println("--- Order Menu ---");
        System.out.println("1: ...");
        System.out.println("...");
        System.out.println("3: Print orders");
        System.out.println("4. Back");
        System.out.println("-----------------");
        System.out.print("Select: ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                // TODO
                return this;
            case "2":
                // TODO
                return this;
            case "3":
                Global.orderDao.printOrders();
                return this;
            case "4":
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
