package org.example;

import java.util.Scanner;

public class Main {

    public String letterSearch(String userWord, String computerWord) {
        String userInput = userWord.toLowerCase();
        String randomWord = computerWord.toLowerCase();

        int i = 0;
        int j = 0;
        String results = "";
        while (i < userInput.length()) {
            if (userInput.charAt(i) == randomWord.charAt(j) && i == j) {
                results += Util.getFormattedLetter(userInput.charAt(i), Util.Result.HIT);
                i++;
                j = 0;
            } else if (userInput.charAt(i) == randomWord.charAt(j) && i != j) {
                results += Util.getFormattedLetter(userInput.charAt(i), Util.Result.SEMI_HIT);
                i++;
                j = 0;
            } else if (userInput.charAt(i) != randomWord.charAt(j) && j == randomWord.length()-1) {
                results += Util.getFormattedLetter(userInput.charAt(i), Util.Result.MISS);
                i++;
                j = 0;
            } else {
                j++;
            }

        }
        return results;
    }

    public static void main(String[] args) {
//to count user attempts
        int userAttempts = 1;
        // to collect userInput
        Scanner myScanner = new Scanner(System.in);
        String wordIn;
        String word = Util.getRandomWord();
        Main newObj = new Main();


        while (userAttempts <= 6) {
            System.out.println("Enter fiver letter word!");
            wordIn = myScanner.nextLine();
            if (wordIn.length() == 5) {
                System.out.println(newObj.letterSearch(wordIn, word));
                System.out.println(word);
                userAttempts++;
            };
//put in a completion statement
            //fix attempt number
            //change file


        }


        System.out.println(Util.getFormattedLetter('d', Util.Result.MISS));


    }
}