package Git;

import java.util.Scanner;

public class Division {
    public static void main(String[] args){
        Scanner scanne = new Scanner(System.in);
        int first = scanne.nextInt();
        int second = scanne.nextInt();
        int i = 0;
        while(first >= second) {
            first = first - second;
            i++;
        }
        System.out.println(first + " " + i);
    }
}
