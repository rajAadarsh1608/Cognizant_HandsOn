import java.util.HashMap;
import java.util.Map;


class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

  
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

  
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(
            "Product ID: " + productId +
            ", Name: " + productName +
            ", Quantity: " + quantity +
            ", Price: ₹" + price
        );
    }
}


public class InventoryManagementSystem {

  
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {

        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists!");
            return;
        }

        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(
            int productId,
            String productName,
            int quantity,
            double price) {

        if (inventory.containsKey(productId)) {

            Product product = inventory.get(productId);

            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product updated successfully.");

        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {

        if (inventory.containsKey(productId)) {

            inventory.remove(productId);
            System.out.println("Product deleted successfully.");

        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAllProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : inventory.values()) {
            product.displayProduct();
        }
    }

    
    public static void main(String[] args) {

        InventoryManagementSystem system =
                new InventoryManagementSystem();

       
        system.addProduct(
                new Product(101, "Laptop", 10, 55000)
        );

        system.addProduct(
                new Product(102, "Keyboard", 25, 1500)
        );

        system.addProduct(
                new Product(103, "Mouse", 50, 800)
        );

        System.out.println("\n--- Inventory ---");
        system.displayAllProducts();

       
        System.out.println("\n--- Updating Product ---");

        system.updateProduct(
                101,
                "Dell Laptop",
                15,
                60000
        );

        system.displayAllProducts();

        // Deleting product
        System.out.println("\n--- Deleting Product ---");

        system.deleteProduct(102);

        // Display final inventory
        System.out.println("\n--- Final Inventory ---");
        system.displayAllProducts();
    }
}