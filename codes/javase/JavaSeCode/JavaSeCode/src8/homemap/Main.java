package homemap;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Ad", "Aysel");
        map.put("Şəhər", "Bakı");
        map.put("Dövlət", "Azərbaycan");

        String uzunAçar = "";
        for (String açar : map.keySet()) {
            if (açar.length() > uzunAçar.length()) {
                uzunAçar = açar;
            }
        }

        System.out.println("Ən uzun açar: " + uzunAçar);
        
        //________________________________________________________________________________
        
        Map<String, Integer> avarageMap = new HashMap<>();
        avarageMap.put("A", 85);
        avarageMap.put("B", 90);
        avarageMap.put("C", 78);
        avarageMap.put("D", 92);

        int toplam = 0;
        for (int dəyər : avarageMap.values()) {
            toplam += dəyər;
        }

        double ortalama = toplam / (double) map.size();
        System.out.println("Dəyərlərin ortalaması: " + ortalama);

    }
}
