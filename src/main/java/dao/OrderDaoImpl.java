package dao;

import global.Global;
import model.Customer;
import model.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OrderDaoImpl implements OrderDao {
    private List<Order> orders;
    private static final String ORDERS_FILE="orders.txt";
    public OrderDaoImpl() throws IOException {
        this.orders = load();
    }

    @Override
    public void printOrders() {
        // collect customer ids
        Set<String> customerIds = new HashSet<>();
        for (Order o: orders) {
            if (!o.getCustomerId().isEmpty()) {
                customerIds.add(o.getCustomerId());
            }
        }

        // fetch customer names
        Map<String, String> m = new HashMap<>();
        for (String id: customerIds) {
            String cusName = Global.customerDao.getNameById(id);
            m.put(id, cusName);
        }
        // assign to order
        for (Order o: orders) {
            o.setCustomerName(m.getOrDefault(o.getCustomerId(), ""));
        }

        // sort
        Collections.sort(orders, (o1, o2) -> {
            return o1.getCustomerName().compareToIgnoreCase(o2.getCustomerName());
        });

        // print
        for (Order o: orders) {
            System.out.println(o.toStringWithCustomerName());
        }

    }

    private List<Order> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(ORDERS_FILE));
        List<Order> orders = new ArrayList<>();
        for (String line: lines) {
            if (line.trim().isEmpty()) continue;
            String[] cs = line.split("\\,");
            orders.add(new Order(cs[0], cs[1], ""));
            // TODO: read other info
        }
        return orders;
    }
}
