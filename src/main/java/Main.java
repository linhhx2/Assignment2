import dao.*;
import global.Global;
import menu.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // init global objects
        CustomerDao customerDao = null;
        ProductDao productDao = null;
        OrderDao orderDao = null;
        try {
            customerDao = new CustomerDaoImpl();
            productDao = new ProductDaoImpl();
            orderDao = new OrderDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Global.customerDao = customerDao;
        Global.productDao = productDao;
        Global.orderDao = orderDao;

        // menus
        MainMenu mainMenu = new MainMenu();
        CustomerMenu customerMenu = new CustomerMenu();
        ProductMenu productMenu = new ProductMenu();
        OrderMenu orderMenu = new OrderMenu();
        mainMenu.setCustomerMenu(customerMenu);
        mainMenu.setProductMenu(productMenu);
        mainMenu.setOrderMenu(orderMenu);
        customerMenu.setParent(mainMenu);
        productMenu.setParent(mainMenu);
        orderMenu.setParent(mainMenu);

        Menu menu = mainMenu;
        while (menu != null) {
            menu = menu.run();
        }
    }
}
