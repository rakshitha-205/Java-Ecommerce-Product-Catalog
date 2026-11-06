package ecommerce;

/**
 * Academic Activity: Tutorial 5 — E-Commerce Product Catalog
 * Student Name: Rakshitha R
 * USN / Roll No: 26UG1BYAI414-T
 * GitHub: @rakshitha-205
 */

/**
 * Product serves as the base class in the E-Commerce Product Catalog.
 * 
 * Core concepts demonstrated:
 * - Encapsulation: Private data fields with public getters and setters.
 * - Constructor: Parameterized initialization of base product attributes.
 * - Base Method: printBaseInfo() displaying general product data.
 * - Method Overloading: applyDiscount() overloaded with percentage and flat/seasonal versions.
 */
public class Product {

    // Encapsulation: private fields
    private String productID;
    private String name;
    private double basePrice;
    private int stockQuantity;

    /**
     * Parameterized Constructor initializing core product properties.
     */
    public Product(String productID, String name, double basePrice, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        setBasePrice(basePrice);
        setStockQuantity(stockQuantity);
    }

    // ==========================================
    // GETTERS AND SETTERS (Encapsulation)
    // ==========================================

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            System.out.println("Warning: Price cannot be negative. Setting to $0.00.");
            this.basePrice = 0.0;
        } else {
            this.basePrice = basePrice;
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            System.out.println("Warning: Stock quantity cannot be negative. Setting to 0.");
            this.stockQuantity = 0;
        } else {
            this.stockQuantity = stockQuantity;
        }
    }

    // ==========================================
    // BASE DISPLAY METHOD
    // ==========================================

    /**
     * Prints the core product details.
     * Can be invoked by subclasses using super.printBaseInfo().
     */
    public void printBaseInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Product ID:      " + productID);
        System.out.println("Product Name:    " + name);
        System.out.printf("Base Price:      $%.2f%n", basePrice);
        System.out.println("Stock Quantity:  " + stockQuantity + " units");
    }

    // ==========================================
    // METHOD OVERLOADING (Discounts)
    // ==========================================

    /**
     * Overloaded Version 1:
     * Reduces the base price by a specified percentage.
     * 
     * @param percentage Discount percentage between 0 and 100
     */
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage: " + percentage + "%. Must be between 0 and 100.");
            return;
        }
        double discountAmount = (percentage / 100.0) * this.basePrice;
        this.basePrice -= discountAmount;
        System.out.printf("[DISCOUNT] Applied %.1f%% off ($%.2f discount). New Price: $%.2f%n",
                percentage, discountAmount, this.basePrice);
    }

    /**
     * Overloaded Version 2:
     * Reduces the base price by a flat dollar amount with additional seasonal sale bonus.
     * 
     * @param flatAmount  Flat dollar discount to subtract
     * @param isSeasonal If true, applies an extra 10% seasonal holiday discount
     */
    public void applyDiscount(double flatAmount, boolean isSeasonal) {
        if (flatAmount < 0) {
            System.out.println("Invalid flat discount amount: $" + flatAmount);
            return;
        }

        double totalDiscount = flatAmount;
        if (isSeasonal) {
            // Seasonal sale gives an extra 10% promotional reduction on top of the flat discount
            double seasonalBonus = this.basePrice * 0.10;
            totalDiscount += seasonalBonus;
            System.out.printf("[SEASONAL SALE] Applied flat discount of $%.2f + seasonal bonus of $%.2f!%n",
                    flatAmount, seasonalBonus);
        } else {
            System.out.printf("[STANDARD DISCOUNT] Applied flat discount of $%.2f.%n", flatAmount);
        }

        if (totalDiscount > this.basePrice) {
            this.basePrice = 0.0;
            System.out.println("Price reduced to promotional minimum: $0.00 (Free item!)");
        } else {
            this.basePrice -= totalDiscount;
            System.out.printf("New Price after discount: $%.2f%n", this.basePrice);
        }
    }
}

