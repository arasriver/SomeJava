package Git;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number except 0: ");
        int number = scanner.nextInt();
        int sum = 0;
        while(number != 0){
            for(int i = 1; i <= number/2; i++){
                float mod = number%i;
                if(mod == 0){
                    sum = i + sum;
                }
            }

            if(sum == number){
                System.out.println(number + " is a complete number.");
            } else{
                System.out.println(number + " is NOT a complete number.");
            }
            System.out.println("If you don't want to continue press 0 ");
            number = scanner.nextInt();
            sum = 0;

        }



    }
}
