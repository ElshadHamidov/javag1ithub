package homeworkclass;

public class ClassAndObjectAndConstructors {

    public static void main(String[] args) {
        People people1 = new People(1, "Ali", "Məmmədov", 25, "0501234567");
        People people2 = new People(2, "Aysel", "Hüseynova", 30, "0519876543");
        System.out.println("ID: " + people1.id);
        System.out.println("Ad: " + people1.name);
        System.out.println("Soyad: " + people1.surname);
        System.out.println("Yaş: " + people1.age);
        System.out.println("Telefon: " + people1.phone);        
        System.out.println("ID: " + people2.id);
        System.out.println("Ad: " + people2.name);
        System.out.println("Soyad: " + people2.surname);
        System.out.println("Yaş: " + people2.age);
        System.out.println("Telefon: " + people2.phone);
    }

}
