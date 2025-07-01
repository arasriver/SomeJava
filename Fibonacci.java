package Git;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Fibonacci Sequence you want to see, Zero is not acceptable: ");
        int number = scanner.nextInt();
        int[] fibonacci = new int[number];

        if(number == 1){
            fibonacci[0] = 0 ;
            System.out.println(fibonacci[0]);
        }else if (number == 2) {
            fibonacci[0] = 0 ;
            fibonacci[1] = 1;
            System.out.println(fibonacci[0] +" " + fibonacci[1]);
        }else{
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            System.out.print(fibonacci[0] +" " + fibonacci[1] + " ");
            for (int i = 2; i < number; i++) {
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
                System.out.print(  fibonacci[i] + " ");
            }
        }


    }
}
