import java.io.*;
import java.util.*;

public class LongestCommonSubString {
	public static void main(String[] args) {
		String str1 = "substring";
		String str2 = "string";
		int[][] LCS = new int[str1.length()+1][str2.length()+1];
		for(int i =0;i<str1.length();i++) {
			LCS[i][0]=0;
		}
		for(int i=0;i<str2.length();i++) {
			LCS[0][i]=0;
		}
		for(int i=1;i<LCS.length;i++){
			for(int j=1;j<LCS[0].length;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					LCS[i][j]=1+LCS[i-1][j-1];
				}else{
					LCS[i][j]=0;
				}
			}
		}

		System.out.println(LCS[str1.length()][str2.length()]);
	}
}
