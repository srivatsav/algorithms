import java.util.Scanner;

public class NumberOfPathsToReachDestination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int pathCost = sc.nextInt();
		int[][]arr = new int[m][n];
		for(int i=0;i<m;i++)
		{			
			for(int j=0;j<n;j++)
			{
				arr[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}

		System.out.println(dfs(0,0,arr,arr.length,arr[0].length,pathCost-arr[0][0]));
	}

	private static int dfs(int x,int y,int[][]arr,int rows,int columns,int pathCost) {

		int path=0;

		if(x<rows && y<columns){
			
			System.out.println(x+"~~~"+y+"~~~"+pathCost);

			if(x==rows-1 && y==columns-1 && pathCost==0) {
				path++;
			}else {
				if(y<columns-1 && arr[x][y+1]<=pathCost) {
					path+=dfs(x,y+1,arr,rows,columns,pathCost-arr[x][y+1]);
				}			
				if(x<rows-1 && arr[x+1][y]<=pathCost) {
					path+=dfs(x+1,y,arr,rows,columns,pathCost-arr[x+1][y]);
				}
			}
		}
		
        return path>0 ? path : 0;
	}
}
