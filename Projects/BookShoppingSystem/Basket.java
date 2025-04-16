package Projects.BookShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    // Sepetteki ürünleri tutan liste
    private static List<Product> basketItems = new ArrayList<>();

    // Sepete ürün ekleme metodu
    public static void addToBasket(Product product, int quantity) {
        // Ürün zaten sepette varsa, miktarı arttır
        for (Product item : basketItems) {
            if (item.getProductCode().equals(product.getProductCode())) {
                int newPiece = item.getPiece() + quantity;
                item.setPiece(newPiece);
                System.out.println(product.getProductName() + " ürününün adedi güncellendi.");
                return;
            }
        }
        // Ürün sepete yeni ekleniyor
        Product newProduct = new Product(product.getProductName(), product.getPrice(), quantity);
        basketItems.add(newProduct);
        System.out.println(product.getProductName() + " sepete eklendi.");
    }

    // Sepetten ürün silme metodu
    public static void removeFromBasket(String productCode) {
        for (Product item : basketItems) {
            if (item.getProductCode().equals(productCode)) {
                basketItems.remove(item);
                System.out.println(item.getProductName() + " sepetten silindi.");
                return;
            }
        }
        System.out.println("Ürün sepette bulunamadı!");
    }

    // Ürün miktarını güncelleme metodu
    public static void updateQuantity(String productCode, int newQuantity) {
        for (Product item : basketItems) {
            if (item.getProductCode().equals(productCode)) {
                if (newQuantity > 0) {
                    item.setPiece(newQuantity);
                    System.out.println(item.getProductName() + " ürününün adedi güncellendi.");
                } else {
                    removeFromBasket(productCode);
                }
                return;
            }
        }
        System.out.println("Ürün sepette bulunamadı!");
    }

    // Sepetteki tüm ürünleri yazdıran metot
    public static void printBasketItems() {
        System.out.println("🛒 Sepetiniz:");
        System.out.println("-----------------------------");
        if (basketItems.isEmpty()) {
            System.out.println("Sepetinizde ürün bulunmamaktadır.");
        } else {
            for (Product product : basketItems) {
                System.out.println(product);
            }
            System.out.println("-----------------------------");
            System.out.println("Toplam Tutar: " + String.format("%.2f TL", calculateTotal()));
        }
        System.out.println("-----------------------------");
    }

    // Sepetin toplam fiyatını hesaplayan metot
    public static double calculateTotal() {
        double total = 0.0;
        for (Product product : basketItems) {
            total += product.getPrice() * product.getPiece();
        }
        return total;
    }

    // Sepet temizleme metodu
    public static void clearBasket() {
        basketItems.clear();
        System.out.println("Sepetiniz temizlendi.");
    }

    // Sepetteki ürün sayısını dönen metot
    public static int getItemCount() {
        return basketItems.size();
    }

    // Sepetteki ürünlerin toplam adedini dönen metot
    public static int getTotalItemsCount() {
        int totalItems = 0;
        for (Product product : basketItems) {
            totalItems += product.getPiece();
        }
        return totalItems;
    }

    // Sepet boşsa kontrol etme metodu
    public static boolean isEmpty() {
        return basketItems.isEmpty();
    }
}