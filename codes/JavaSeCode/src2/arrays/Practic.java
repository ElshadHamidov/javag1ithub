package arrays;

import java.util.Arrays;

public class Practic {
    public static void main(String[] args) {
//        int[] num = {2, -7, -1, 9, 4, 2, 2, 5};
//        Arrays.sort(num); 
//        System.out.println("Maximum value: " + max(num));  
//        
//        int[] positivenum = positive(num);
//        System.out.println("Positive values: " + Arrays.toString(positivenum));
//        
//        System.out.println("Two counts: " + twocounter(num));
//    } 
//
//    static int max(int[] num) {
//        int maxnum = num[0];
//        for (int i = 1; i < num.length; i++) {
//            if (num[i] > maxnum) {  
//                maxnum = num[i];
//            }
//        }
//        return maxnum;
//    }
//    
//    static int[] positive(int[] num) {
//        int[] positivenum = new int[num.length];
//        for (int i = 0; i < num.length; i++) {
//            if (num[i] < 0) {  
//                positivenum[i] = -num[i];
//            } else {
//                positivenum[i] = num[i];
//            }
//        }
//        Arrays.sort(positivenum); 
//        return positivenum;
//    }
//    static int twocounter(int[] num) {
//        int twocount = 0;
//        for (int i = 1; i < num.length; i++) {
//            if (num[i] == 2) {  
//                twocount++;
//            }
//        }
//        return twocount;
//    }
    	int[][] doublearr = {{1, 2, 3}, {4, 5, 6}};
    	int sum = 0;
    	for (int i = 0; i < doublearr.length; i++) {
    	    for (int j = 0; j < doublearr[i].length; j++) {
    	        sum += doublearr[i][j];
    	    }
    	}

    	System.out.println("Summary:  " + sum);

    }
}    	

