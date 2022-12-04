package com.company;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Day3 {
    static ArrayList<String> arr0 = new ArrayList<>();

    public static void Day3(){

        fileIO();


//        partOne();
//
        partTwo();
    }

    private static void partOne(){

        int sum = 0;
        for(int i = 0; i < arr0.size(); i++){
            String knapsack = arr0.get(i);
            String c1 = knapsack.substring(0, knapsack.length()/2);
            String c2 = knapsack.substring(knapsack.length()/2);

            Hashtable<Character, Integer> occurences = new Hashtable<>();

            System.out.println(knapsack + " " + c1 + " " + c2);

            for(int j = 0; j < c1.length(); j++){
                if(occurences.containsKey(c1.charAt(j))){
                    occurences.put(c1.charAt(j), occurences.get(c1.charAt(j)) + 1);
                }else{
                    occurences.put(c1.charAt(j), 1);
                }
            }

            for(int j = 0; j < c2.length(); j++){
                if(occurences.containsKey(c2.charAt(j))){
                    sum += getNumberFromCharacter(c2.charAt(j));
                    System.out.println(c2.charAt(j) + " " + getNumberFromCharacter(c2.charAt(j)));
                    break;
                }
            }


        }
        System.out.println(sum);
    }

    private static void partTwo(){

        int sum = 0;
        for(int i = 0; i < arr0.size(); i += 3){
            String line1 = arr0.get(i);
            String line2 = arr0.get(i+1);
            String line3 = arr0.get(i+2);
            Hashtable<Character, Integer> occurences = new Hashtable<>();
            for(int j = 0; j < line1.length(); j++){
                occurences.put(line1.charAt(j), 1);
            }
            for(int j = 0; j < line2.length(); j++){
                if(occurences.containsKey(line2.charAt(j))){
                    occurences.put(line2.charAt(j), 2);
                }
            }
            for(int j = 0; j < line3.length(); j++){
                if(occurences.containsKey(line3.charAt(j))){
                    if(occurences.get(line3.charAt(j)) == 2){
                        sum += getNumberFromCharacter(line3.charAt(j));
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static int getNumberFromCharacter(char c){
        if(c >= 'a' && c <= 'z'){
            return ((int) c) - 96;
        }else{
            return ((int) c) - 38;
        }
    }

    private static void fileIO(){
        File inputFile = new File("src/com/company/Day3Input");
        try {
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();


                arr0.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
