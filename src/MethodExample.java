/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class MethodExample {

    public static void sayHello(){
        System.out.println("Hello World");
    }
    
    public static void println(String s){
        System.out.println(s);
    }
    
    public static double areaOfRectangle(double length, double width){
        double area = length * width;
        return area;
    }
    
    public static void printFactors(int num){
        println("The factors of " + num + " are:");
        // go from 1 to the number
        for(int i = 1; i <= num; i++){
            // does it divide?
            if(num % i == 0){
                // print it out
                System.out.println(i);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String word = "Hello";
        println(word);
        printFactors(10);
        printFactors(36);
        System.out.println("Area:");
        areaOfRectangle(2.5, 5);
    }
    
}
