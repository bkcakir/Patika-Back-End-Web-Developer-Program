package Projects.BookShoppingSystem;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {

    private static List<Product> products = new ArrayList<>();
    private String productName;
    private String productCode; // Ürün Kodu
    private Double price;
    private int piece;

    // Constructor
    public Product(String productName, Double price, int piece) {
        this.productName = productName;
        this.price = price;
        this.piece = piece;
        this.productCode = generateProductCode();  // Ürün kodunu başlatırken rastgele bir kod üretir
    }

    // Getter & Setter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    // Ürün kodu, 0 ile 100 arasında rastgele bir sayı üretir
    private String generateProductCode() {
        Random random = new Random();
        return "PC" + random.nextInt(101); // "PC" + 0-100 arasında bir sayı
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    // Estetik toString metodu
    @Override
    public String toString() {
        return  "📚 Ürün Bilgisi\n" +
                "-----------------------------\n" +
                " Kitap Adı   : " + productName + "\n" +
                " Fiyat       : " + String.format("%.2f TL", price) + "\n" +
                " Stok Adedi  : " + piece + " adet\n" +
                " Ürün Kodu   : " + productCode + "\n" +
                "-----------------------------";
    }

    // Default Kitaplar
    public static void defaultProductData() {
        products.add(new Product("Suç ve Ceza", 79.90, 10));
        products.add(new Product("1984", 59.50, 15));
        products.add(new Product("Sefiller", 85.00, 8));
        products.add(new Product("Küçük Prens", 29.99, 25));
        products.add(new Product("Bilinmeyen Bir Kadının Mektubu", 42.75, 12));
    }

    // Yazdır
    public static void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Ürün arama metodu
    public static Product findProductByCode(String productCode) {
        for (Product product : products) {
            if (product.getProductCode().equals(productCode)) {
                return product;
            }
        }
        return null;
    }

    // Stok kontrolü
    public boolean checkStock(int requestedAmount) {
        return this.piece >= requestedAmount;
    }

    // Stok güncelleme
    public void updateStock(int amount) {
        if (this.piece >= amount) {
            this.piece -= amount;
        } else {
            throw new IllegalArgumentException("Yetersiz stok!");
        }
    }

    // Ürün satın alma
    public static void buyProduct() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Mevcut Kitaplar:");
        printProducts();
        
        System.out.print("Satın almak istediğiniz kitabın ürün kodunu giriniz: ");
        String productCode = scanner.next();
        
        Product selectedProduct = findProductByCode(productCode);
        
        if (selectedProduct != null) {
            System.out.print("Kaç adet almak istiyorsunuz: ");
            int amount = scanner.nextInt();
            
            if (selectedProduct.checkStock(amount)) {
                selectedProduct.updateStock(amount);
                Basket.addToBasket(selectedProduct, amount);
                System.out.println("Ürün sepete eklendi!");
            } else {
                System.out.println("Yetersiz stok! Mevcut stok: " + selectedProduct.getPiece());
            }
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    public static void main(String[] args) {
        // Default kitap verilerini yükle
        defaultProductData();

        // Ürünleri yazdır
        printProducts();
    }
}
