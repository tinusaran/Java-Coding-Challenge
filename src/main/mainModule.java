package main;
import java.util.Scanner;
import java.util.List;
import dao.OrderProcessor;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import entity.Product;
import entity.User;
import entity.Clothing;
import entity.Electronics;



public class mainModule {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        OrderProcessor orderProcessor = new OrderProcessor();  // Instance of the class implementing the interface
        int choice = -1;

        while (choice != 6) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Cancel Order");
            System.out.println("4. Get All Products");
            System.out.println("5. Get Order by User");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (choice) {
                    case 1:
                        createUser(scanner, orderProcessor);
                        break;
                    case 2:
                        createProduct(scanner, orderProcessor);
                        break;
                    case 3:
                        cancelOrder(scanner, orderProcessor);
                        break;
                    case 4:
                        getAllProducts(orderProcessor);
                        break;
                    case 5:
                        getOrderByUser(scanner, orderProcessor);
                        break;
                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Consume invalid input
            }
        }
        scanner.close();
    }

    private static void createUser(Scanner scanner, OrderProcessor orderProcessor) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Role (Admin/User): ");
        String role = scanner.nextLine();

        User user = new User(userId, username, password, role);
        orderProcessor.createUser(user);

        System.out.println("User created successfully.");
    }

    private static void createProduct(Scanner scanner, OrderProcessor orderProcessor) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Product Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity in Stock: ");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter Product Type (Electronics/Clothing): ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("Electronics")) {
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();

            System.out.print("Enter Warranty Period (in months): ");
            int warrantyPeriod = scanner.nextInt();

            Electronics electronics = new Electronics(productId, productName, description, price, quantityInStock, type, brand, warrantyPeriod);
            try {
				orderProcessor.createProduct(null, electronics);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Assuming null user for this example
        } else if (type.equalsIgnoreCase("Clothing")) {
            System.out.print("Enter Size: ");
            String size = scanner.nextLine();

            System.out.print("Enter Color: ");
            String color = scanner.nextLine();

            Clothing clothing = new Clothing(productId, productName, description, price, quantityInStock, type, size, color);
            try {
				orderProcessor.createProduct(null, clothing);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Assuming null user for this example
        } else {
            System.out.println("Invalid product type.");
        }
    }

    private static void cancelOrder(Scanner scanner, OrderProcessor orderProcessor) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();

        try {
            orderProcessor.cancelOrder(userId, orderId);
            System.out.println("Order canceled successfully.");
        } catch (UserNotFoundException | OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAllProducts(OrderProcessor orderProcessor) {
        List<Product> products = orderProcessor.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void getOrderByUser(Scanner scanner, OrderProcessor orderProcessor) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        User user = new User(userId, null, null, null);  // Assuming only userId for this example
        List<Product> orderedProducts = orderProcessor.getOrderByUser(user);

        System.out.println("Products ordered by User " + userId + ":");
        for (Product product : orderedProducts) {
            System.out.println(product);
        }
    }
}
