package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Validator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    Scanner scanner = new Scanner(System.in);
    List<Customer> customerList = new ArrayList<>();

    public List<Customer> createCustomer() {
        boolean status;
        String flag;
        Customer customer = new Customer();
        System.out.print("Enter name: ");
        customer.setName(scanner.nextLine());
        do {
            System.out.print("Enter phone number: ");
            customer.setPhoneNumber(scanner.nextLine());
            if (Validator.isPhone(customer.getPhoneNumber())) {
                status = false;
            } else {
                status = true;
            }
        } while (status);
        System.out.print("Enter address: ");
        customer.setAddress(scanner.nextLine());

        // create orders
        List<Order> orderList = new ArrayList<>();
        int i = 1;
        do {
            System.out.println("Enter order infor " + i + ": ");
            Order order = new Order();
            do {
                System.out.print("  + number: ");
                order.setNumber(scanner.nextLine());
                if (order.getNumber().length() <= 10) {
                    status = false;
                } else {
                    status = true;
                }
            } while (status);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            do {
                System.out.print("  + date: ");
                try {
                    order.setDate(simpleDateFormat.parse(scanner.nextLine()));
                    status = false;
                } catch (Exception e) {
                    status = true;
                }
            } while (status);
            System.out.print("Do you want add order? stop(enter 'n' or 'N'): ");
            flag = scanner.nextLine();
            orderList.add(order);
            i++;
        } while (!flag.equals("N") && !flag.equals("n"));
        customer.setOrders(orderList);
        customerList.add(customer);
        return customerList;
    }

    public void findAll() {
        if (customerList.size() > 0) {
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        } else {
            System.out.println("Customer empty");
        }
    }

    public void findByPhoneNumber(String phone) {
        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(phone)) {
                System.out.println(customer);
            } else {
                System.out.println("Customer not found");
            }
        }
    }

    public void remove(String phone) {
        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(phone)) {
                customerList.remove(customer);
                System.out.println("Delete successful");
            } else {
                System.out.println("Customer not found");
            }
        }
    }
    public void save() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("customer.dat"));
        bufferedWriter.append(customerList.toString());
        bufferedWriter.close();
    }
}
