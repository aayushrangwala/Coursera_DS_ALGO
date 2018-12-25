import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int[] coins = {10,5,1};
        
        int minCoins = 0;

        /*for (int i = 0; i < 3 && m > 0; i++) {
        	if (coins[i] > m) {
        		continue;
        	}
        	while (m > 0 && coins[i] <= m) {
        		m -= coins[i];
        		minCoins++;
        	}
        }*/
        int c = 0;
        while (m > 0 && c < 3) {
        	if (coins[c] > m) {
        		c++;
        		continue;
        	}
        	m -= coins[c];
        	minCoins++;
        }
        return minCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

