package genericsecond;

public class Main {
    public static void main(String[] args) {
        Collection<String> stringCollection = new Collection<>();
        stringCollection.addElement("Hello");
        stringCollection.addElement("World");
        stringCollection.printElements();
        System.out.println("Size of string collection: " + stringCollection.size());

        Collection<Integer> integerCollection = new Collection<>();
        integerCollection.addElement(1);
        integerCollection.addElement(2);
        integerCollection.addElement(3);
        integerCollection.printElements();
        System.out.println("Size of integer collection: " + integerCollection.size());
    }
}

