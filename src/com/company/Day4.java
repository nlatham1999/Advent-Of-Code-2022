package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    static ArrayList<String> arr0 = new ArrayList<>();

    public static void Day4(){

        fileIO();


//        partOne();
//
        partTwo();
    }

    private static void partOne(){
        int count = 0;
        for(String pair : arr0){
            String[] pairs = pair.split(",");
            String[] first = pairs[0].split("-");
            String[] second = pairs[1].split("-");
            int a1 = Integer.parseInt(first[0]);
            int b1 = Integer.parseInt(first[1]);
            int a2 = Integer.parseInt(second[0]);
            int b2 = Integer.parseInt(second[1]);
            if((a1 <= a2 && b1 >= b2) || (a2 <= a1 && b2 >= b1)){
                count ++;
            }
        }
        System.out.println(count);
    }

    private static void partTwo(){
        int count = 0;
        for(String pair : arr0){
            String[] pairs = pair.split(",");
            String[] first = pairs[0].split("-");
            String[] second = pairs[1].split("-");
            int a1 = Integer.parseInt(first[0]);
            int b1 = Integer.parseInt(first[1]);
            int a2 = Integer.parseInt(second[0]);
            int b2 = Integer.parseInt(second[1]);
            if((a1 >= a2 && a1 <= b2) ||
                    (a2 >= a1 && a2 <= b1) ||
                    (b1 >= a2 && b1 <= b2) ||
                    (b2 >= a1 && b2 <= b1)
            ){
                count ++;
            }
        }
        System.out.println(count);
    }

    private static void fileIO(){
        File inputFile = new File("src/com/company/Day4Input");
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
