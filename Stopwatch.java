package Git;

import java.util.Scanner;

public class Stopwatch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER to start the stopwatch...");
        scanner.nextLine();

        long startTime = System.nanoTime();

        System.out.println("Stopwatch started. Press ENTER again to stop.");
        scanner.nextLine();

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        double seconds = elapsedTime / 1_000_000_000.0;

        System.out.printf("Elapsed time: %.3f seconds%n", seconds);
    }
}

