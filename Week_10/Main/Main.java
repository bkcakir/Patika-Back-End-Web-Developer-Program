/*
 * Main.java
 *
 * Bu sınıf, Rent A Car uygulamasının başlangıç noktasıdır. Uygulamanın
 * ana menüsünü başlatır ve kullanıcı etkileşimini yönetir.
 *
 * Özellikler:
 * - Uygulama başlatma
 * - Ana menü yönetimi
 * - Kullanıcı oturumu kontrolü
 *
 */

package Main;

import Main.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.start();
    }
} 