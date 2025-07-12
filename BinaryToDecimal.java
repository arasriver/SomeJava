package Git;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number (only 0s and 1s): ");
        String binaryString = scanner.nextLine();

        // Check if the input is a valid binary number
        if (!binaryString.matches("[01]+")) {
            System.out.println("Invalid binary number. Only 0s and 1s are allowed.");
            return;
        }

        int decimalValue = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            int bit = binaryString.charAt(length - 1 - i) - '0';
            decimalValue += bit * Math.pow(2, i);
        }

        System.out.println("Decimal value: " + decimalValue);
    }
}
