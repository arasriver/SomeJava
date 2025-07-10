package Git;

import java.util.Scanner;

public class Symmetrical {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number  = scanner.nextInt();
        int n = number;


        int reverse = 0;
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        System.out.println("The reverse of the given number is: " + reverse);

        if(reverse == n){
            System.out.println("Then this number is Symmetrical. ");
        }else
            System.out.println("Then this number is not Symmetrical. ");

    }
}
