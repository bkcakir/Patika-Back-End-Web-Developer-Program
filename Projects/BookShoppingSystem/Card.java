package Projects.BookShoppingSystem;

import java.util.Scanner;

public class Card {

    // Static dizi: Ortak veri
    public static Card[] cards = new Card[5];

    private String cardName;
    private String userName;
    private String cardNumber;
    private String cardMonth;
    private String cardYear;
    private Double balance;

    // Getter ve Setter'lar
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public void setCardMonth(String cardMonth) {
        this.cardMonth = cardMonth;
    }

    public String getCardYear() {
        return cardYear;
    }

    public void setCardYear(String cardYear) {
        this.cardYear = cardYear;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // toString metodu
    @Override
    public String toString() {
        return "╔══════════════════════════════╗\n" +
                "║ Kart Sahibi   : " + userName + "\n" +
                "║ Kart Adı      : " + cardName + "\n" +
                "║ Kart No       : " + cardNumber + "\n" +
                "║ Son Kullanım  : " + cardMonth + "/" + cardYear + "\n" +
                "║ Bakiye        : " + String.format("%.2f TL", balance) + "\n" +
                "╚══════════════════════════════╝";
    }

    // Static veri oluşturucu
    public static void DefaultData() {
        Card card1 = new Card();
        card1.setCardName("Visa Gold");
        card1.setUserName("Ahmet Yılmaz");
        card1.setCardNumber("4539 1234 5678 9012");
        card1.setCardMonth("08");
        card1.setCardYear("2027");
        card1.setBalance(4500.75);
        cards[0] = card1;

        Card card2 = new Card();
        card2.setCardName("Mastercard Premium");
        card2.setUserName("Zeynep Kaya");
        card2.setCardNumber("5241 9876 5432 1001");
        card2.setCardMonth("12");
        card2.setCardYear("2025");
        card2.setBalance(2300.00);
        cards[1] = card2;

        Card card3 = new Card();
        card3.setCardName("Axess Classic");
        card3.setUserName("Mehmet Demir");
        card3.setCardNumber("4023 4567 8901 2345");
        card3.setCardMonth("03");
        card3.setCardYear("2026");
        card3.setBalance(780.50);
        cards[2] = card3;

        Card card4 = new Card();
        card4.setCardName("WorldCard");
        card4.setUserName("Elif Arslan");
        card4.setCardNumber("5169 1122 3344 5566");
        card4.setCardMonth("09");
        card4.setCardYear("2028");
        card4.setBalance(12000.00);
        cards[3] = card4;

        Card card5 = new Card();
        card5.setCardName("Bonus Platinum");
        card5.setUserName("Caner Öz");
        card5.setCardNumber("4716 9988 7766 5544");
        card5.setCardMonth("06");
        card5.setCardYear("2029");
        card5.setBalance(3560.20);
        cards[4] = card5;
    }

    // Kartları yazdıran static metot
    public static void printCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // Kart doğrulama metodu
    public static Card validateCard(String cardNumber, String cardMonth, String cardYear) {
        for (Card card : cards) {
            if (card != null && 
                card.getCardNumber().replace(" ", "").equals(cardNumber.replace(" ", "")) &&
                card.getCardMonth().equals(cardMonth) &&
                card.getCardYear().equals(cardYear)) {
                return card;
            }
        }
        return null;
    }

    // Bakiye kontrolü
    public boolean checkBalance(double amount) {
        return this.balance >= amount;
    }

    // Ödeme işlemi
    public static void processPayment() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ödeme İşlemi");
        System.out.println("-------------------");
        
        // Sepet toplamını al
        double totalAmount = Basket.calculateTotal();
        if (totalAmount == 0) {
            System.out.println("Sepetiniz boş!");
            return;
        }
        
        System.out.println("Toplam Tutar: " + String.format("%.2f TL", totalAmount));
        
        // Kart bilgilerini al
        System.out.print("Kart Numarası: ");
        String cardNumber = scanner.nextLine();
        
        System.out.print("Son Kullanma Ayı (MM): ");
        String cardMonth = scanner.nextLine();
        
        System.out.print("Son Kullanma Yılı (YY): ");
        String cardYear = scanner.nextLine();
        
        // Kartı doğrula
        Card selectedCard = validateCard(cardNumber, cardMonth, cardYear);
        
        if (selectedCard != null) {
            // Bakiye kontrolü
            if (selectedCard.checkBalance(totalAmount)) {
                // Ödemeyi gerçekleştir
                selectedCard.setBalance(selectedCard.getBalance() - totalAmount);
                System.out.println("Ödeme başarıyla tamamlandı!");
                System.out.println("Kalan Bakiye: " + String.format("%.2f TL", selectedCard.getBalance()));
                Basket.clearBasket(); // Sepeti temizle
            } else {
                System.out.println("Yetersiz bakiye!");
            }
        } else {
            System.out.println("Geçersiz kart bilgileri!");
        }
    }
}
