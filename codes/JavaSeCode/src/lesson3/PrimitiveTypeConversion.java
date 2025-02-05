/**
 * 
 */
package lesson3;

/**
 * 
 */
public class PrimitiveTypeConversion {

	public static void main(String[] args) {
		short shortVar1 = 69;
		byte byteVar1 = (byte) shortVar1;
		short shortVar2 = 589;
		byte byteVar2 = (byte) shortVar2;  
		long longVar1 = 458;
		int intVar1 = (int) longVar1;
		long longVar2 = 52523635483L;
		int intVar2 = (int) longVar2;
		double doubleVar = 5632.6;
		float floatVar = (float) doubleVar;
		char charVar = 'D';
		int intVar3 = (int) charVar;
		int intVar4 = 123;
		char charVar2 = (char) intVar4;
		System.out.println(byteVar1);
		System.out.println(byteVar2);
		System.out.println(intVar1);
		System.out.println(intVar2);
		System.out.println(floatVar);
		System.out.println(intVar3);
		System.out.println(charVar2);
	}

}
