import java.util.Random;
import java.util.Scanner;

import static java.lang.Character.compare;

public class Hangman {
    public static void main(String[] args){
        Random rdm = new Random();                          // random number to select word from list
        boolean keepgoing = true;                           //variable to end outer loop
        Scanner scan = new Scanner(System.in);              //create scanner
        String [] arr = {"tree", "rain", "bear", "encourage", "promise",
                "soup", "chess", "insurance", "pancakes", "stream"};
        int i = 0;
        while(keepgoing){
            int index = rdm.nextInt(arr.length);            //pick a random number
            String word = arr[index];                       //select a word from the array
            char[] chars = new char[word.length()];
            for(i=0; i < word.length();i++){                //make a blank array the length of word.
                chars[i] = '_';}                            //initialize array with underscores
            i=0;
            while(i < 5){                                   // give the user 5 tries
                System.out.print("Guess a letter: ");
                char guess = scan.next().toLowerCase().charAt(0); // input a letter
                if (compare(guess,'\r') == 0) {
                    System.out.println("Please enter a letter.");
                    continue;
                }
                //System.out.println(word);
                for (int j = 0; j < word.length(); j++) {
                    if (compare(word.charAt(j),guess)== 0) {
                        chars[j] = guess;                       // load matching chars
                        i--;                                    //decrement i for each correct guess
                    }
                    System.out.print(chars[j]+" ");            //print out matching guesses
                }
                System.out.println();
                String s = new String(chars);                   //cast string array into string
                if (!s.contains("_")){                          // if string ! contains '_' you won
                    System.out.println("YOU WON!");
                    break;
                }
                i++;                                            // increment i
            }
            System.out.println("Enter 'more' to go again: ");
            String response = scan.next();
            if (response.equalsIgnoreCase("more")){         // if 'more' continue
                System.out.println("You have selected to play another game.");
            }
            else{                                                       //if !'more' end game
                System.out.println("The game has ended.");
                keepgoing = false;
            }
        }
    }
}
