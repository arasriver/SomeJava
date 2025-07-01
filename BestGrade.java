package Git;

import java.util.Scanner;

public class BestGrade {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Students: ");
        int number = scanner.nextInt();
        System.out.println("Now enter Student id and grade of these students: ");
        float[][] student = new float[number][2];
        for(int i = 0; i < number; i++){
            System.out.println("Enter id Student number " + (i+1) );
            float input = scanner.nextFloat();
            student[i][0] = input;
            System.out.println("Enter grade of Student with id " + (int)student[i][0] );
            input = scanner.nextFloat();
            student[i][1] = input;
        }

//        for(int i = 0; i < number; i++)
//            for(int j = 0; j < 2; j++){
//            System.out.println(student[i][j]);
//        }

        float maxGrade = student[0][1];
        float secondGrade = student[0][1];
        float maxID = student[0][0];
        float secondID = student[0][0];
        for(int i = 0; i < number; i++){
            if (student[i][1] > maxGrade){
                secondGrade = maxGrade;
                maxGrade = student[i][1];
                maxID = student[i][0];
            } else if (student[i][1] > secondGrade && student[i][1] < maxGrade){
                secondGrade = student[i][1];
                secondID = student[i][0];
            }
        }

        for(int i = 0; i < number; i++){
            if (student[i][1] == maxGrade){
                System.out.println("max grades is for Student id : " + (int)student[i][0] + " with grade " + student[i][1]);
            }
        }

        for(int i = 0; i < number; i++){
            if (student[i][1] == secondGrade){
                System.out.println("second max grades is for Student id : " + (int)student[i][0] + " with grade " + student[i][1]);
            }
        }

       // System.out.println("Student with this is id: "+ (int)maxID +" has the best result: " + maxGrade);

      //  System.out.println("Second grade is: " + secondGrade + " for Student id: " + (int) secondID);


    }
}
