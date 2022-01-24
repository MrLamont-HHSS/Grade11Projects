/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class ForLoopPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // while loop example
        int count = 0;
        while (count < 10) 
        {
            System.out.println(count);
            count++;
        }

        // for loop example
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }

        // add the numbers from 1 to 100
        int sum = 0;
        // for loop that goes from 1 to 100
        for (int i = 1; i <= 100; i++) {
            // adding each number to the sum
            sum = sum + i;
        }
        // print the answer
        System.out.println("Sum: " + sum);

        // print out the factors of num
        int num = 10;
        // go from 1 to the num
        for(int i = 1; i <= num; i++){
            // does it divide num?
            if(num % i == 0){
                // print it out
                System.out.println(i);
            }
        }

    }

}
