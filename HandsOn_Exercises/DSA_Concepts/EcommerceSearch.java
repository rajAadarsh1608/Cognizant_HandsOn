class EcommerceProduct {
    int productId;
    String productName;
    String category;

    public EcommerceProduct(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println(productId + " " + productName + " " + category);
    }
}

public class EcommerceSearch {

    public static EcommerceProduct linearSearch(EcommerceProduct[] products, int key) {
        for (EcommerceProduct product : products) {
            if (product.productId == key) {
                return product;
            }
        }
        return null;
    }

    public static EcommerceProduct binarySearch(EcommerceProduct[] products, int key) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == key) {
                return products[mid];
            }

            if (products[mid].productId < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        EcommerceProduct[] products = {
            new EcommerceProduct(104, "Shoes", "Fashion"),
            new EcommerceProduct(101, "Laptop", "Electronics"),
            new EcommerceProduct(103, "Watch", "Accessories"),
            new EcommerceProduct(102, "Phone", "Electronics")
        };

        EcommerceProduct[] sortedProducts = {
            new EcommerceProduct(101, "Laptop", "Electronics"),
            new EcommerceProduct(102, "Phone", "Electronics"),
            new EcommerceProduct(103, "Watch", "Accessories"),
            new EcommerceProduct(104, "Shoes", "Fashion")
        };

        System.out.println("Linear Search:");

        EcommerceProduct result1 = linearSearch(products, 103);

        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product not found");
        }

        System.out.println("\nBinary Search:");

        EcommerceProduct result2 = binarySearch(sortedProducts, 103);

        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product not found");
        }
    }
}
