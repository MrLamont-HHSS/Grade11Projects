
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
public class PigLatin {
    
    public static String toPigLatin(String word){
        String translate = "";
        // does it start with a vowel
        word = word.toUpperCase();
        if(word.startsWith("A") 
                || word.startsWith("E") 
                || word.startsWith("I") 
                || word.startsWith("O") 
                || word.startsWith("U")){
            translate = translate + word + "WAY";
        }else{
            // go through each letter
            // start at 1 because 
            // don't need to look at the first letter
            for(int i = 1; i < word.length(); i++){
                // get the letter at position i
                char letter = word.charAt(i);
                String vowels = "AEIOU";
                // if the letter is in the vowels AEIOU
                // it must be one of those vowels
                if(vowels.contains("" + letter)){
                    // separates the word into 2 chunks
                    String back = word.substring(i);
                    String front = word.substring(0,i);
                    translate = translate + back + front + "AY";
                    break;
                }
            }

        }
        return translate;
    }
    
    public static String joinWords(String word1, String word2){
        String translate = "";
        for(int i = 0; i < word1.length(); i++){
            char letter1 = word1.charAt(i);
            char letter2 = word2.charAt(i);
            
            translate = translate + letter1 + letter2;
        }
        return translate;        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        Scanner input = new Scanner(System.in);
        
        String newWord = joinWords("cat","dog");
        System.out.println(newWord);
        
//        ArrayList<String> dictionary = new ArrayList<>();
//        URLConnection url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt").openConnection();
//        Scanner dictionaryInput = new Scanner(url.getInputStream());
//        while(dictionaryInput.hasNext()){
//            String s = dictionaryInput.nextLine();
//            dictionary.add(s);
//        }
//        dictionaryInput.close();
//        
//        
//        System.out.println("Please enter something to translate");
//        String line = input.nextLine();
//        String[] words = line.split(" ");
//        
//        // go through each word
//        for(int i = 0; i < words.length; i++){
//            // translate a single word
//            String word = words[i];
//            String translation = toPigLatin(word);
//            // print the transation with a space
//            System.out.print(translation + " ");
//        }
//        System.out.println("");
        
    }
    
}
