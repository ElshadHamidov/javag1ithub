package methods;

public class CicleModifier {
    public void modifyCircleRadius(Circle circle, double newRadius) {
        circle.radius = newRadius;
        System.out.println("Yeni radius: " + circle.radius);
    }
}

