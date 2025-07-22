package Git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindMedianArray {
    public static void main(String[] args){
        ArrayList<Integer> integersList = new ArrayList<Integer>();
        System.out.println("Enter number of integers you want to enter: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Now enter " + num + " integers: ");
        for (int i = 0; i < num ; i++){
            int integers = scanner.nextInt();
            integersList.add(integers);
        }
        //Sort in ascending
        Collections.sort(integersList);

        // time to find median
        if (num%2 != 0){
            int med = (num+1)/2;
            System.out.println("Median is: " + integersList.get(med-1));
        }else{
            int med1 = ((num+1)/2);
            int med2 = ((num+3)/2);
            double med = (double)(integersList.get(med1-1) + integersList.get(med2-1)) / 2;
            System.out.println("Median is: " + med );
        }

    }


}
