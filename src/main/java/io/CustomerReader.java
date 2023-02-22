package io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerReader {
    Scanner sc = new Scanner(System.in);
    Pattern customerIdPattern = Pattern.compile("C\\d{3}");
    public String readCustomerId(){
        System.out.print("Customer id: ");
        while (true) {
            String customerId = sc.nextLine();
            if (customerIdPattern.matcher(customerId).matches()) {
                return customerId;
            } else {
                System.out.println("invalid customer id, format should be Cxxx where x is a digit");
                System.out.print("type again: ");
            }
        }
    }
    public String readCustomerName(){
        System.out.print("Customer name: ");
        while (true) {
            String customerName = sc.nextLine();
            if (customerName.length() < 5 || customerName.length() > 30) {
                System.out.println("invalid customer name, length should be range [5, 30]");
                System.out.print("type again: ");
            } else {
                return customerName;
            }
        }
    }
}
