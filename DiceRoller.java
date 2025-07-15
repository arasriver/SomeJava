package Git;

import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many times do you want to roll the die? ");
        int rolls = scanner.nextInt();

        System.out.println("Rolling the die " + rolls + " time(s)...");

        for (int i = 1; i <= rolls; i++) {
            int result = random.nextInt(6) + 1; // random number from 1 to 6
            System.out.println("Roll " + i + ": 🎲 " + result);
        }
    }
}

