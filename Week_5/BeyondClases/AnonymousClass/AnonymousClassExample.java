public class AnonymousClassExample {
    public static void main(String[] args) {
        // Anonim sınıf örneği - Runnable interface'i implementasyonu
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonim sınıf içinden çalışan thread!");
            }
        };

        // Anonim sınıf örneği - Comparator interface'i implementasyonu
        java.util.Comparator<String> stringComparator = new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        // Kullanım örnekleri
        Thread thread = new Thread(runnable);
        thread.start();

        String[] words = {"Java", "Python", "C++", "JavaScript"};
        java.util.Arrays.sort(words, stringComparator);
        
        System.out.println("Sıralanmış kelimeler:");
        for (String word : words) {
            System.out.println(word);
        }
    }
} 