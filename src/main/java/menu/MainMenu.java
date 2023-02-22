package menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    private Menu customerMenu;
    private Menu productMenu;
    private Menu orderMenu;
    @Override
    public Menu run() {
        System.out.println("--- Main Menu ---");
        System.out.println("1: Customer menu");
        System.out.println("2: Product menu");
        System.out.println("3: Order menu");
        System.out.println("Other. Exit");
        System.out.println("-----------------");
        System.out.print("Select: ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            return this.customerMenu;
        } else if (choice.equals("2")){
            return this.productMenu;
        } else if (choice.equals("3")){
            return this.orderMenu;
        } else {
            return null;
        }
    }

    public Menu getCustomerMenu() {
        return customerMenu;
    }

    public void setCustomerMenu(Menu customerMenu) {
        this.customerMenu = customerMenu;
    }

    public Menu getProductMenu() {
        return productMenu;
    }

    public void setProductMenu(Menu productMenu) {
        this.productMenu = productMenu;
    }

    public Menu getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(Menu orderMenu) {
        this.orderMenu = orderMenu;
    }
}
