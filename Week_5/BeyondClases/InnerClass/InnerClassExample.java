public class InnerClassExample {
    private String outerMessage = "Dış sınıf mesajı";
    
    // İç sınıf tanımı
    class Inner {
        private String innerMessage = "İç sınıf mesajı";
        
        public void display() {
            System.out.println("Dış sınıf mesajı: " + outerMessage);
            System.out.println("İç sınıf mesajı: " + innerMessage);
        }
    }
    
    public static void main(String[] args) {
        // Dış sınıf örneği oluşturma
        InnerClassExample outer = new InnerClassExample();
        
        // İç sınıf örneği oluşturma
        InnerClassExample.Inner inner = outer.new Inner();
        
        // İç sınıf metodunu çağırma
        inner.display();
    }
} 