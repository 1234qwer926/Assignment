import java.util.HashMap;
import java.util.Scanner;


class ProductDetail {
    public int price;
    public int rating;
    public String category;
    public String description;

    public ProductDetail(int price, int rating, String category, String description) {
        this.price = price;
        this.rating = rating;
        this.category = category;
        this.description = description;
    }
}

public class Product_confi {
    private HashMap<String, ProductDetail> products = new HashMap<>();

    public void input(String productName, int price, int rating, String category, String description) {
        ProductDetail productDetail = new ProductDetail(price, rating, category, description);
        products.put(productName, productDetail);
    }

    public static void main(String[] args) {
        Product_confi detail = new Product_confi();
        int key = 1;
        Scanner sc = new Scanner(System.in);

        while (key != 0) {
            System.out.println("Choose an option: ");
            System.out.println("0. Exit\n1. Add Product Details\n2. Access Product Details");
            key = sc.nextInt();
            sc.nextLine();
            System.out.println("------**************************---------------");

            switch (key) {
                case 1:
                    System.out.println("Enter the Product details: ");
                    System.out.print("Product Name: ");
                    String _product_name = sc.nextLine();
                    System.out.print("Price: ");
                    int _price = sc.nextInt();
                    System.out.print("Rating: ");
                    int _rating = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    System.out.print("Category: ");
                    String _category = sc.nextLine();
                    System.out.print("Description: ");
                    String _description = sc.nextLine();
                    detail.input(_product_name, _price, _rating, _category, _description);
                    System.out.println("------**************************---------------");
                    break;
                case 2:
                    System.out.println("Enter the product name to display the details: ");
                    String item = sc.nextLine();
                    ProductDetail productDetails = detail.products.get(item);
                    if (productDetails != null) {
                        System.out.println("Product details:");
                        System.out.println("Price: " + productDetails.price);
                        System.out.println("Rating: " + productDetails.rating);
                        System.out.println("Category: " + productDetails.category);
                        System.out.println("Description: " + productDetails.description);
                        System.out.println("------**************************---------------");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                default:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }
}

