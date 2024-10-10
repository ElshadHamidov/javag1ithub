package methods;

public class MainClass {
    public static void main(String[] args) {
    	Circle circle = new Circle(5.0);
    	System.out.println("Dairənin yeni sahəsi: " + circle.calculateArea());
        System.out.println("Dairənin yeni perimetri: " + circle.calculatePerimeter());
        CicleModifier modifier = new CicleModifier();
        modifier.modifyCircleRadius(circle, 10.0);
        System.out.println("Dairənin yeni sahəsi: " + circle.calculateArea());
        System.out.println("Dairənin yeni perimetri: " + circle.calculatePerimeter());
        Rectangle rectangle = new Rectangle(4.0, 7.0);
        System.out.println("Düzbucaqlının sahəsi: " + rectangle.calculateArea());
        System.out.println("Düzbucaqlının perimetri: " + rectangle.calculatePerimeter());
    }
}