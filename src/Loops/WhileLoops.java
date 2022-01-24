package Loops;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class WhileLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // count from 1 to 10
        int count = 1;
        int sum = 0;
        while(count <= 10){
            // print out the count
            System.out.println(count);
            // add the number to the sum
            sum = sum + count;
            
            // add one to count
            count = count + 1;
            
        }
        
        System.out.println("The total from 1 to 10 is " + sum);
        
        
        // make sure the number input is between 1 and 10
        int number;
        do{
            System.out.println("Please enter a number between 1 and 10");
            number = input.nextInt();                    
        }while(number < 1 || number > 10);
        
        
        
        
    }
    
}
