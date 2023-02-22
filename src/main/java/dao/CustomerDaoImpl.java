package dao;

import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> customers;
    private static final String CUSTOMERS_FILE="customers.txt";
    public CustomerDaoImpl() throws IOException {
        this.customers = load();
    }

    @Override
    public void updateById(Customer c) {
        Customer target = null;
        // find
        for (Customer customer: customers) {
            if (c.getId().equals(customer.getId())) {
                target = customer;
                break;
            }
        }

        // update
        if (target != null) {
            String tmp = target.getName();
            if (!c.getName().isEmpty()) {
                target.setName(c.getName());
            }
            try {
                flush();
            } catch (IOException e) {
                target.setName(tmp);
                e.printStackTrace();
                System.out.println("update customer error!");
            }
            System.out.println("update customer done!");
        } else {
            System.out.println("customer not found!");
        }
    }

    @Override
    public String getNameById(String id) {
        for (Customer c: customers) {
            if (c.getId().equals(id)) return c.getName();
        }
        return "";
    }

    @Override
    public void printCustomers() {
        for (Customer c: customers) {
            System.out.println(c.toString());
        }
    }

    private void flush() throws IOException {
        List<String> lines = new ArrayList<>();
        for (Customer p: this.customers) {
            lines.add(String.format("%s\n", p.toString()));
        }
        boolean first = true;
        for (String line: lines) {
            if (first) {
                Files.write(Paths.get(CUSTOMERS_FILE), line.getBytes(), StandardOpenOption.CREATE);
            } else {
                Files.write(Paths.get(CUSTOMERS_FILE), line.getBytes(), StandardOpenOption.APPEND);
            }
        }
    }

    private List<Customer> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(CUSTOMERS_FILE));
        List<Customer> customers = new ArrayList<>();
        for (String line: lines) {
            if (line.trim().isEmpty()) continue;
            String[] cs = line.split("\\,");
            customers.add(new Customer(cs[0].trim(), cs[1].trim(), cs[2].trim(), cs[3].trim()));
        }
        return customers;
    }
}
