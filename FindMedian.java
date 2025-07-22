package Git;

import java.util.ArrayList;
import java.util.Collections;

public class FindMedian {
    private ArrayList<Integer> numbers = new ArrayList();


    public ArrayList<Integer> getNumbers(int num) {
        numbers.add(num);
        return numbers;
    }
    

    public void findMed(){
        Collections.sort(numbers);
        if (numbers.size()%2 != 0){
            int med = (numbers.size()+1)/2;
            System.out.println("Median is: " + numbers.get(med-1));
        }else{
            int med1 = ((numbers.size()+1)/2);
            int med2 = ((numbers.size()+3)/2);
            double med = (double)(numbers.get(med1-1) + numbers.get(med2-1)) / 2;
            System.out.println("Median is: " + med );
        }
    }
    public void displayInfo(){
        System.out.println(numbers);
    }



// ****** Code example for writing in Main class *****

//        FindMedian med = new FindMedian();
//        med.getNumbers(6);
//        med.getNumbers(3);
//        med.getNumbers(10);
//        med.getNumbers(2);
//        med.getNumbers(9);
//        med.displayInfo();
//        med.findMed();


}
