package Git;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args){
        int max = 0;
        int id = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Employees: ");
        int number = scanner.nextInt();
        int[][] employee = new int[number][3];
        for(int i=0; i<number; i++){
            System.out.println("Enter employee id: ");
            employee[i][0] = scanner.nextInt();
            System.out.println("Enter Employee Salary: ");
            employee[i][1] = scanner.nextInt();
            if(employee[i][1] < 40000){
                System.out.println("There is no tax for this salary. ");
                employee[i][2] = employee[i][1];
            }else if(employee[i][1] >= 40000 && employee[i][1] < 50000){
                double n = (0.1 * (employee[i][1] - 40000));
                employee[i][2] = (int) (employee[i][1] -  (int)n );
            }else if(employee[i][1] >= 50000 && employee[i][1] < 70000){
                double n = (0.15 * (employee[i][1] - 50000));
                employee[i][2] = (employee[i][1] - (int)n );
            }else{
                    double n = (0.17 * (employee[i][1] - 70000));
                    employee[i][2] = (int) (employee[i][1] - (int)n );
            }
        }

        System.out.println("Netto salary is: ");
        for(int i = 0; i < employee.length; i++){
            System.out.println("Employee id " + employee[i][0] + " : " + employee[i][2]);
        }

        for(int i = 0; i < employee.length; i++){
            max = employee[0][0];
            id = employee[1][0];
            if(employee[i][2] > max){
                max = employee[i][2];
                id = employee[i][0];
            }
        }
        System.out.println("Highest pure Salary is: " + max + " for employee id " + id );
    }
}
