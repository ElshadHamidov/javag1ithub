package lesson3;

public class PrimitiveTypeConversionHome {

	public PrimitiveTypeConversionHome() {
		// TODO Auto-generated constructor stub
	}

public static void main(String[] args) {
        
        int intVar1 = 55;
        byte byteVar1 = (byte) intVar1;
        System.out.println("ByteVar1: " + byteVar1);
        
        short shortVar1 = 636;
        byte byteVar2 = (byte) shortVar1;
        System.out.println("ByteVar2: " + byteVar2);
        
        long longVar1 = 458;
        short shortVar2 = (short) longVar1;
        System.out.println("ShortVar2: " + shortVar2);
        
        long longVar2 = 92523635483L;
        int intVar2 = (int) longVar2;
        System.out.println("IntVar2: " + intVar2);
        
        double doubleVar = 65787.3;
        int intVar3 = (int) doubleVar;
        System.out.println("IntVar3: " + intVar3);
        
        char charVar = 'q';
        int intVar4 = (int) charVar;
        System.out.println("IntVar4: " + intVar4);
        
        int intVar5 = 266;
        char charVar2 = (char) intVar5;
        System.out.println("CharVar2: " + charVar2);
    }

}
