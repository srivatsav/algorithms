package algorithms;

import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.err.println("NO of operations required are :: " + getNumberOfOperationsForConversion(str1, str2));
        sc.close();
    }

    private static int getNumberOfOperationsForConversion(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        } else {
            int[] a1 = new int[256];
            int[] a2 = new int[256];
            for (int i = 0; i < str1.length(); i++) {
                a1[str1.charAt(i)]++;
            }
            for (int i = 0; i < str2.length(); i++) {
                if (a1[str2.charAt(i)] > 0) {
                    a2[str2.charAt(i)] = --a1[str2.charAt(i)];
                } else {
                    a2[str2.charAt(i)]++;
                }
            }
            return getNumberOfOperations(str1, str2, a1, a2);
        }
    }

    private static int getNumberOfOperations(String str1, String str2,int[] a1, int[] a2) {
        int result = 0;
        if (str1.length() >= str2.length()) {
            for (int i = 0; i < a1.length; i++) {
                if( a1[i] > 0) result+=a1[i];
            }
        } else {
            for (int i = 0; i < a2.length; i++) {
                if( a2[i] > 0) result+=a2[i];
            }
        }
        return result;
    }
}
