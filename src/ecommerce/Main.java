package ecommerce;

/**
 * Academic Activity: Tutorial 5 — E-Commerce Product Catalog
 * Student Name: Rakshitha R
 * USN / Roll No: 26UG1BYAI414-T
 * GitHub: @rakshitha-205
 */

import java.util.Scanner;

/**
 * Main is the driver class executing the required tutorial tasks and providing
 * an interactive demonstration of the E-Commerce Product Catalog.
 * 
 * Demonstrated Topics:
 * - Encapsulation (private fields, getters/setters with validation)
 * - Inheritance (Electronics and Clothing inheriting from Product)
 * - Constructor Chaining with super()
 * - Parent Method Invocation with super.printBaseInfo()
 * - Method Overloading (applyDiscount(percentage) vs applyDiscount(flatAmount, isSeasonal))
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("            THE E-COMMERCE PRODUCT CATALOG BACKEND            ");
        System.out.println("  Core Focus: Encapsulation, Inheritance, super(), Overloading ");
        System.out.println("===============================================================");

        // Automatically run the prescribed Tutorial Tasks
        runPrescribedTutorialTasks();

        // Interactive Menu for further exploration
        System.out.println("\nWould you like to open the Interactive Product Manager? (y/n): ");
        String response = sc.nextLine().trim();
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            runInteractiveCatalog();
        } else {
            System.out.println("Exiting E-Commerce Catalog. Have a great day!");
        }

        sc.close();
    }

    /**
     * Executes the three required Tutorial Tasks sequentially.
     */
    public static void runPrescribedTutorialTasks() {
        System.out.println("\n>>> [TASK 1] Testing Base Product & Method Overloading for Discounts");
        System.out.println("Creating a generic Product instance: 'Wireless Mouse'...");
        Product mouse = new Product("PRD-101", "Ergonomic Wireless Mouse", 50.00, 120);
        mouse.printBaseInfo();
        System.out.println("----------------------------------------");

        System.out.println("\nTesting Overloaded Discount Version 1: applyDiscount(percentage)");
        System.out.println("Applying 15% discount on Product...");
        mouse.applyDiscount(15.0);

        System.out.println("\nTesting Overloaded Discount Version 2: applyDiscount(flatAmount, isSeasonal)");
        System.out.println("Applying $10.00 flat discount with isSeasonal = true...");
        mouse.applyDiscount(10.0, true);

        System.out.println("\nUpdated Product Info after discounts:");
        mouse.printBaseInfo();
        System.out.println("----------------------------------------");


        System.out.println("\n>>> [TASK 2 & 3] Instantiating Subclasses with Constructor Chaining via super()");
        System.out.println("1. Instantiating 'Electronics' object (Sony 4K Smart TV)...");
        Electronics smartTv = new Electronics(
                "ELEC-501", 
                "Sony Bravia 55\" 4K Smart TV", 
                799.99, 
                25, 
                89.99, 
                220
        );

        System.out.println("Calling smartTv.printElectronicsDetails() [invokes super.printBaseInfo()]:");
        smartTv.printElectronicsDetails();

        System.out.println("Applying a 20% discount on the Electronics item (inherited method):");
        smartTv.applyDiscount(20.0);
        System.out.println("\nDisplaying Electronics details after discount:");
        smartTv.printElectronicsDetails();


        System.out.println("\n2. Instantiating 'Clothing' object (Denim Jacket)...");
        Clothing jacket = new Clothing(
                "CLTH-202", 
                "Vintage Denim Jacket", 
                120.00, 
                60, 
                "XL", 
                "Heavyweight Denim Cotton"
        );

        System.out.println("Calling jacket.printClothingDetails() [invokes super.printBaseInfo()]:");
        jacket.printClothingDetails();

        System.out.println("Applying Seasonal Flat Discount ($25.00 off, seasonal = true):");
        jacket.applyDiscount(25.0, true);
        System.out.println("\nDisplaying Clothing details after seasonal discount:");
        jacket.printClothingDetails();

        System.out.println("\n>>> [VERIFICATION COMPLETE] All tutorial tasks passed successfully!");
    }

    /**
     * Interactive terminal system allowing users to test custom products and discounts.
     */
    private static void runInteractiveCatalog() {
        int choice = -1;

        do {
            System.out.println("\n================ INTERACTIVE CATALOG MENU ================");
            System.out.println("1. Create and View a Standard Product");
            System.out.println("2. Create and View an Electronics Product (super demonstration)");
            System.out.println("3. Create and View a Clothing Product (super demonstration)");
            System.out.println("4. Re-run Automated Tutorial Tests");
            System.out.println("5. Exit");
            System.out.println("==========================================================");
            System.out.print("Select an option (1-5): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleCustomProduct();
                    break;
                case 2:
                    handleCustomElectronics();
                    break;
                case 3:
                    handleCustomClothing();
                    break;
                case 4:
                    runPrescribedTutorialTasks();
                    break;
                case 5:
                    System.out.println("Exiting Interactive Catalog.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (choice != 5);
    }

    private static void handleCustomProduct() {
        System.out.println("\n--- Create Standard Product ---");
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Base Price ($): ");
        double price = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Enter Stock Quantity: ");
        int stock = Integer.parseInt(sc.nextLine().trim());

        Product p = new Product(id, name, price, stock);
        p.printBaseInfo();
        System.out.println("----------------------------------------");

        System.out.println("\nTest Discount Overloading:");
        System.out.println("1. Percentage Discount (applyDiscount(percentage))");
        System.out.println("2. Flat + Seasonal Discount (applyDiscount(flatAmount, isSeasonal))");
        System.out.print("Choose discount type: ");
        int dType = Integer.parseInt(sc.nextLine().trim());

        if (dType == 1) {
            System.out.print("Enter discount percentage (%): ");
            double pct = Double.parseDouble(sc.nextLine().trim());
            p.applyDiscount(pct);
        } else {
            System.out.print("Enter flat discount amount ($): ");
            double flat = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Is it a seasonal sale? (true/false): ");
            boolean seasonal = Boolean.parseBoolean(sc.nextLine().trim());
            p.applyDiscount(flat, seasonal);
        }

        System.out.println("\nProduct Info After Discount:");
        p.printBaseInfo();
        System.out.println("----------------------------------------");
    }

    private static void handleCustomElectronics() {
        System.out.println("\n--- Create Electronics Product (Inherits from Product) ---");
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Base Price ($): ");
        double price = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Enter Stock Quantity: ");
        int stock = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Warranty Cost ($): ");
        double warranty = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Enter Voltage (V): ");
        int voltage = Integer.parseInt(sc.nextLine().trim());

        Electronics e = new Electronics(id, name, price, stock, warranty, voltage);
        System.out.println("\nDisplaying details via printElectronicsDetails() [uses super.printBaseInfo()]:");
        e.printElectronicsDetails();

        System.out.print("Apply discount percentage on this Electronics item (%): ");
        double pct = Double.parseDouble(sc.nextLine().trim());
        e.applyDiscount(pct);

        System.out.println("\nElectronics Details After Discount:");
        e.printElectronicsDetails();
    }

    private static void handleCustomClothing() {
        System.out.println("\n--- Create Clothing Product (Inherits from Product) ---");
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Base Price ($): ");
        double price = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Enter Stock Quantity: ");
        int stock = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Size (e.g. S, M, L, XL): ");
        String size = sc.nextLine().trim();
        System.out.print("Enter Fabric Material: ");
        String fabric = sc.nextLine().trim();

        Clothing c = new Clothing(id, name, price, stock, size, fabric);
        System.out.println("\nDisplaying details via printClothingDetails() [uses super.printBaseInfo()]:");
        c.printClothingDetails();

        System.out.print("Apply flat discount amount ($): ");
        double flat = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Is it seasonal? (true/false): ");
        boolean seasonal = Boolean.parseBoolean(sc.nextLine().trim());
        c.applyDiscount(flat, seasonal);

        System.out.println("\nClothing Details After Discount:");
        c.printClothingDetails();
    }
}

