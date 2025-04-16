// Sealed sınıf tanımı
sealed class Shape permits Circle, Rectangle, Triangle {
    public abstract double calculateArea();
}

// İzin verilen alt sınıflar
final class Circle extends Shape {
    private final double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle extends Shape {
    private final double width;
    private final double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

final class Triangle extends Shape {
    private final double base;
    private final double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

public class SealedExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0);
        
        System.out.println("Daire Alanı: " + circle.calculateArea());
        System.out.println("Dikdörtgen Alanı: " + rectangle.calculateArea());
        System.out.println("Üçgen Alanı: " + triangle.calculateArea());
    }
} 