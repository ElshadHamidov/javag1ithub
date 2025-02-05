package lesson11;

public class MainPage {
    public static void main(String[] args) {
        int eded = 1202;
        int tersEded = 0;

        while(eded != 0) {
            int qaliq = eded % 10;
            tersEded = tersEded * 10 + qaliq;
            eded /= 10;
        }

        System.out.println("Tərsi: " + tersEded);
    }
}
