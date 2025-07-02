package Git;

import java.util.Scanner;

public class Nfactorial {
    public static void main(String[] args) {
        float result = 0;
        float factorial = 1;
        Scanner scanner = new Scanner(System.in);
        float n = scanner.nextInt();
        for (float i = 1; i <= n; i++) {
            factorial = factorial * i ;
            result += 1 / factorial;
            System.out.println(result);
        }
    }
}
