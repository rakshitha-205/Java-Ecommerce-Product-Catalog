# The E-Commerce Product Catalog

[![Student](https://img.shields.io/badge/Student-Rakshitha%20R-purple.svg)](https://github.com/rakshitha-205)
[![USN](https://img.shields.io/badge/USN-26UG1BYAI414--T-green.svg)](#)
[![Java](https://img.shields.io/badge/Java-21%2B%20%2F%2027-orange.svg)](https://www.oracle.com/java/)

**Tutorial 5 — Object-Oriented Programming in Java**  
**Author:** Rakshitha R (26UG1BYAI414-T)  
**GitHub:** [@rakshitha-205](https://github.com/rakshitha-205)

---

A Java backend product management system demonstrating core Object-Oriented Programming (OOP) concepts: **Encapsulation**, **Inheritance**, **Constructor Chaining using `super()`**, **Parent Method Invocation using `super`**, and **Method Overloading**.

---

## 📚 Key Object-Oriented Concepts Demonstrated

### 1. Encapsulation (`Product.java`)
- Core fields (`productID`, `name`, `basePrice`, `stockQuantity`) are kept **`private`**.
- Public getter and setter methods are provided with validation logic (e.g. price and stock cannot be negative).

### 2. Method Overloading (`applyDiscount` in `Product.java`)
- **Version 1**: `applyDiscount(double percentage)` — Reduces price by a specified percentage between 0% and 100%.
- **Version 2**: `applyDiscount(double flatAmount, boolean isSeasonal)` — Reduces price by a flat dollar amount, and applies an additional 10% promotional bonus discount if `isSeasonal` is `true`.

### 3. Inheritance & Constructor Chaining (`Electronics.java` & `Clothing.java`)
- Both `Electronics` and `Clothing` inherit from `Product` using the `extends` keyword.
- Subclasses invoke the parent constructor using `super(productID, name, basePrice, stockQuantity)` to initialize inherited fields without code duplication.

### 4. Parent Method Invocation with `super`
- Subclasses implement specialized print methods:
  - `printElectronicsDetails()` in `Electronics.java`
  - `printClothingDetails()` in `Clothing.java`
- Both methods call `super.printBaseInfo()` to print the core properties before printing subclass-specific attributes (`warrantyCost`, `voltage`, `size`, `fabric`).

---

## 🏗️ Project Structure

```text
EcommerceProductCatalog/
├── src/
│   └── ecommerce/
│       ├── Product.java        # Base class with encapsulation & overloaded discounts
│       ├── Electronics.java    # Subclass with warrantyCost & voltage
│       ├── Clothing.java       # Subclass with size & fabric
│       └── Main.java           # Driver class executing tutorial tasks & interactive mode
├── bin/                        # Compiled .class bytecode
├── run.bat                     # One-click Windows runner script
└── README.md                   # Documentation
```

---

## 🚀 How to Run

### Method 1: Double-Click Runner (Windows)
Double-click `run.bat` or run from terminal:
```powershell
cd EcommerceProductCatalog
.\run.bat
```

### Method 2: Command Line (javac / java)
```powershell
# Compile all source files into bin:
javac -d bin src/ecommerce/*.java

# Run the program:
java -cp bin ecommerce.Main
```

### Method 3: In VS Code
Open [`Main.java`](src/ecommerce/Main.java) and click **Run** (or press `F5`).

---

## 🧪 Tutorial Tasks Output Verification

```text
===============================================================
            THE E-COMMERCE PRODUCT CATALOG BACKEND            
  Core Focus: Encapsulation, Inheritance, super(), Overloading 
===============================================================

>>> [TASK 1] Testing Base Product & Method Overloading for Discounts
Creating a generic Product instance: 'Wireless Mouse'...
----------------------------------------
Product ID:      PRD-101
Product Name:    Ergonomic Wireless Mouse
Base Price:      $50.00
Stock Quantity:  120 units
----------------------------------------

Testing Overloaded Discount Version 1: applyDiscount(percentage)
Applying 15% discount on Product...
[DISCOUNT] Applied 15.0% off ($7.50 discount). New Price: $42.50

Testing Overloaded Discount Version 2: applyDiscount(flatAmount, isSeasonal)
Applying $10.00 flat discount with isSeasonal = true...
[SEASONAL SALE] Applied flat discount of $10.00 + seasonal bonus of $4.25!
New Price after discount: $28.25

Updated Product Info after discounts:
----------------------------------------
Product ID:      PRD-101
Product Name:    Ergonomic Wireless Mouse
Base Price:      $28.25
Stock Quantity:  120 units
----------------------------------------

>>> [TASK 2 & 3] Instantiating Subclasses with Constructor Chaining via super()
1. Instantiating 'Electronics' object (Sony 4K Smart TV)...
Calling smartTv.printElectronicsDetails() [invokes super.printBaseInfo()]:
----------------------------------------
Product ID:      ELEC-501
Product Name:    Sony Bravia 55" 4K Smart TV
Base Price:      $799.99
Stock Quantity:  25 units
Category:        Electronics & Hardware
Warranty Cost:   $89.99 (Optional extended coverage)
Operating Volt:  220V
Total w/Warranty: $889.98
----------------------------------------

2. Instantiating 'Clothing' object (Denim Jacket)...
Calling jacket.printClothingDetails() [invokes super.printBaseInfo()]:
----------------------------------------
Product ID:      CLTH-202
Product Name:    Vintage Denim Jacket
Base Price:      $120.00
Stock Quantity:  60 units
Category:        Apparel & Clothing
Size:            XL
Fabric Material: Heavyweight Denim Cotton
Care:            Machine Washable
----------------------------------------

>>> [VERIFICATION COMPLETE] All tutorial tasks passed successfully!
```

