import java.util.*;
import java.io.*;

public class LCS {
	public static void main(String[] args) {
		char[]c1 = {'A','B','C','B','D','A','B'};
		char[]c2 = {'B','D','C','A','B','A'};

		int [][] LCS = new int[c1.length+1][c2.length+1];
		
		for (int i=0;i<LCS.length;i++) {
			LCS[i][0] = 0;
		}
		for(int i=0;i<LCS[0].length;i++) {
			LCS[0][i] = 0;
		}		
		for (int i=1;i<LCS.length;i++) {
			for(int j=1;j<LCS[0].length;j++){
				if(c1[i-1]==c2[j-1]) 
					LCS[i][j] = 1+LCS[i-1][j-1];
				else
					LCS[i][j] = LCS[i][j-1] > LCS[i-1][j] ? LCS[i][j-1] : LCS[i-1][j];
			}
		}
		System.out.println("LCS length is "+LCS[c1.length][c2.length]);
	}
}
