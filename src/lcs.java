import java.io.PrintWriter;


public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1, str2;
		str2 = new String("bdcaba");
		str1 = new String("abcbdab");
		int len1, len2;
		len1 = str1.length();
		len2 = str2.length();
		int size = (len1 > len2? len1:len2);
		int[][] map = new int[len1 + 1][len2 + 1];
		for(int i = 0; i <= len2; i ++){
			map[0][i] = 0;
		}
		for(int i = 0; i <= len1; i ++){
			map[i][0] = 0;
		}
		for(int i = 1; i <= len1; i ++){
			for(int j = 1; j <= len2; j ++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					map[i][j] = map[i - 1][j - 1] + 1; 
				}
				else{
					map[i][j] = (map[i - 1][j] > map[i][j - 1] ? map[i - 1][j] :  map[i][j - 1]);
				}
			}
		}
		for(int i = 0; i <= len1; i ++){
			for(int j = 0; j <= len2; j ++){
				System.out.print(map[i][j]+ " " );
			}
			System.out.println();
		}
//		String ans = new String("              ");
		char[] ans = new char[100];
		int k = 0;
		int i = len1;
		int j = len2;
		while(i > 0 && j > 0){
			if(str1.charAt(i - 1) == str2.charAt(j - 1)){
				ans[k ++] = str1.charAt(i - 1);
				i --;
				j --;
				continue;
			}
			else if(map[i - 1][j] >= map[i][j -1]){
				i --;
			}
			else if(map[i - 1][j] < map[i][j -1]){
				j --;
			}
		}
		for(int m = k - 1; m >= 0; m --){
			System.out.print(ans[m]);
		}
		
		
		
	}

}
