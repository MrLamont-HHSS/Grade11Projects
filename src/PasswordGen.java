
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
public class PasswordGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many characters should it be?");
        int numCharacters = input.nextInt();
        
        int count = 1;
        while(count <= numCharacters){
            //(int)(Math.random()*(high - low + 1)) + low;
            // generate a random number between 65 and 90
            int num = (int)(Math.random()*(90 - 65 + 1)) + 65;
            System.out.print((char)num);    
            // move to next letter (adds one to count)
            count++;
        }
        System.out.println();
    }
    
}
