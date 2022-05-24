package fa.training.main;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        List<Customer> customerList = new ArrayList<>();

        int choose;
        do {
            System.out.println("------Choice function------");
            System.out.println("1. Add a new Customers");
            System.out.println("2. Show all Customers");
            System.out.println("3. Search Customer by phone number");
            System.out.println("4. Remove Customer by phone number");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customerList = customerService.createCustomer();
                    System.out.println("Successful");
                    break;
                case 2:
                    customerService.findAll(customerList);
                    break;
                case 3:
                    customerService.findByPhoneNumber(customerList);
                    break;
                default:
                    System.out.println("choose 1 - 5");
                    break;
            }
        } while (choose != 5);
    }
}
