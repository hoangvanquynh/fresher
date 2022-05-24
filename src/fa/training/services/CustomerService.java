package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    Scanner scanner = new Scanner(System.in);
    public List<Customer> createCustomer() {
        boolean status;
        String flag;
        List<Customer> customerList = new ArrayList<>();
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
        customer.setName(scanner.nextLine());

        // create orders
        List<Order> orderList = new ArrayList<>();
        int i = 1;
        do {
            System.out.println("Enter order infor " + i +": ");
            Order order = new Order();
            do {
                System.out.print("  + number: ");
                order.setNumber(scanner.nextLine());
                if (order.getNumber().length() <= 10) {
                    status = false;
                }else {
                    status = true;
                }
            } while (status);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            do {
                System.out.print("  + date: ");
                try {
                    order.setDate(simpleDateFormat.parse(scanner.next()));
                    status = false;
                } catch (Exception e) {
                    status = true;
                }
            } while (status);
            scanner.nextLine();
            System.out.print("Do you want add order? stop(enter 'n' or 'N'): ");
            flag = scanner.nextLine();
            orderList.add(order);
            i++;
        } while (!flag.equals("N") && !flag.equals("n"));
        customer.setOrders(orderList);
        customerList.add(customer);
        return customerList;
    }

    public void findAll(List<Customer> customerList) {
        if (customerList.size() > 0) {
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        } else {
            System.out.println("Customer empty");
        }
    }

    public void findByPhoneNumber(List<Customer> customerList) {
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        for (Customer customer : customerList) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(customer);
            }else{
                System.out.println("Customer not found");
            }
        }
    }
}
