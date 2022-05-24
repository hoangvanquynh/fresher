package fa.training.main;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        int choose;
        do {
            System.out.println("------Choice function------");
            System.out.println("1. Add a new Customers");
            System.out.println("2. Show all Customers");
            System.out.println("3. Search Customer by phone number");
            System.out.println("4. Remove Customer by phone number");
            System.out.println("5. Save customer to file");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choose = Integer.parseInt(scanner.nextLine());
            String phone;
            switch (choose) {
                case 1:
                    customerService.createCustomer();
                    System.out.println("Successful");
                    break;
                case 2:
                    customerService.findAll();
                    break;
                case 3:
                    System.out.print("Enter phone number: ");
                    phone = scanner.nextLine();
                    customerService.findByPhoneNumber(phone);
                    break;
                case 4:
                    System.out.print("Enter phone number: ");
                    phone = scanner.nextLine();
                    customerService.remove(phone);
                    break;
                case 5:
                    customerService.save();
                    System.out.println("Successful");
                    break;
                default:
                    System.out.println("choose 1 - 6");
                    break;
            }
        } while (choose != 6);
    }
}
