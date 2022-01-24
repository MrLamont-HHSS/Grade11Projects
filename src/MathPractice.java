
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
public class MathPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creating the Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a temperature in degrees Celsius you would like to convert to Fahrenheit.");
        // get the temp
        double tempC = input.nextDouble();
        double tempF = (tempC*9)/5+32;
        System.out.println(tempC + "C is the same as " + tempF + "F");
        
    }
    
}
