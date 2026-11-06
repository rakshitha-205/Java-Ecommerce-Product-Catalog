package ecommerce;

/**
 * Academic Activity: Tutorial 5 — E-Commerce Product Catalog
 * Student Name: Rakshitha R
 * USN / Roll No: 26UG1BYAI414-T
 * GitHub: @rakshitha-205
 */

/**
 * Electronics represents specialized electronic products in the catalog.
 * 
 * Core concepts demonstrated:
 * - Inheritance: Extends the base Product class.
 * - Constructor Chaining: Uses super(...) to invoke the parent constructor.
 * - Parent Method Invocation: Calls super.printBaseInfo() inside printElectronicsDetails().
 */
public class Electronics extends Product {

    // Subclass-specific fields
    private double warrantyCost;
    private int voltage; // in Volts (e.g., 110V, 220V)

    /**
     * Parameterized Constructor demonstrating Constructor Chaining.
     * Uses super(...) to pass core fields to the Product superclass constructor.
     */
    public Electronics(String productID, String name, double basePrice, int stockQuantity,
                       double warrantyCost, int voltage) {
        // Constructor Chaining using super()
        super(productID, name, basePrice, stockQuantity);
        this.warrantyCost = warrantyCost;
        this.voltage = voltage;
    }

    // ==========================================
    // GETTERS AND SETTERS
    // ==========================================

    public double getWarrantyCost() {
        return warrantyCost;
    }

    public void setWarrantyCost(double warrantyCost) {
        if (warrantyCost < 0) {
            this.warrantyCost = 0.0;
        } else {
            this.warrantyCost = warrantyCost;
        }
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    // ==========================================
    // METHOD INVOCATION WITH super
    // ==========================================

    /**
     * Displays complete electronics details.
     * Reuses parent method via super.printBaseInfo() before printing specific fields.
     */
    public void printElectronicsDetails() {
        // Parent method invocation
        super.printBaseInfo();
        System.out.println("Category:        Electronics & Hardware");
        System.out.printf("Warranty Cost:   $%.2f (Optional extended coverage)%n", warrantyCost);
        System.out.println("Operating Volt:  " + voltage + "V");
        System.out.printf("Total w/Warranty: $%.2f%n", (getBasePrice() + warrantyCost));
        System.out.println("----------------------------------------");
    }
}

