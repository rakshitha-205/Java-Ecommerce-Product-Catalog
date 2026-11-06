package ecommerce;

/**
 * Academic Activity: Tutorial 5 — E-Commerce Product Catalog
 * Student Name: Rakshitha R
 * USN / Roll No: 26UG1BYAI414-T
 * GitHub: @rakshitha-205
 */

/**
 * Clothing represents specialized apparel products in the catalog.
 * 
 * Core concepts demonstrated:
 * - Inheritance: Extends the base Product class.
 * - Constructor Chaining: Uses super(...) to invoke the parent constructor.
 * - Parent Method Invocation: Calls super.printBaseInfo() inside printClothingDetails().
 */
public class Clothing extends Product {

    // Subclass-specific fields
    private String size;   // e.g., "S", "M", "L", "XL", "XXL"
    private String fabric; // e.g., "100% Egyptian Cotton", "Denim", "Wool"

    /**
     * Parameterized Constructor demonstrating Constructor Chaining.
     * Uses super(...) to pass core fields to the Product superclass constructor.
     */
    public Clothing(String productID, String name, double basePrice, int stockQuantity,
                    String size, String fabric) {
        // Constructor Chaining using super()
        super(productID, name, basePrice, stockQuantity);
        this.size = size;
        this.fabric = fabric;
    }

    // ==========================================
    // GETTERS AND SETTERS
    // ==========================================

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    // ==========================================
    // METHOD INVOCATION WITH super
    // ==========================================

    /**
     * Displays complete clothing details.
     * Reuses parent method via super.printBaseInfo() before printing specific fields.
     */
    public void printClothingDetails() {
        // Parent method invocation
        super.printBaseInfo();
        System.out.println("Category:        Apparel & Clothing");
        System.out.println("Size:            " + size);
        System.out.println("Fabric Material: " + fabric);
        System.out.println("Care:            Machine Washable");
        System.out.println("----------------------------------------");
    }
}

