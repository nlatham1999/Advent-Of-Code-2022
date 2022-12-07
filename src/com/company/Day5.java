package com.company;

import javax.print.DocFlavor;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {

    static int STACKS = 9;
    static int HEIGHT = 7;
    static ArrayList<String> arr0 = new ArrayList<>();
    static ArrayList<String> crates = new ArrayList<>();

    public static void Day5(){
        fileIO();

//        partOne();
        partTwo();
    }

    private static void partTwo(){

        buildCrates();

        for(int i = HEIGHT+3; i < arr0.size(); i++){
            System.out.println(arr0.get(i));
            String[] instructions = arr0.get(i).split(" ");
            int amount = Integer.parseInt(instructions[1]);
            int from = Integer.parseInt(instructions[3])-1;
            int to = Integer.parseInt(instructions[5])-1;
            String c1 = crates.get(from);
            String c2 = crates.get(to);
            crates.set(to, c2 + c1.substring(c1.length()-amount));
            crates.set(from, c1.substring(0,c1.length()-amount));
            System.out.println(crates);
        }

        getResults();
    }

    private static void buildCrates(){
        //build out the crates
        for(int i = 0; i < STACKS; i++){
            crates.add("");
        }
        for(int i = HEIGHT; i >= 0; i--){
            System.out.println(arr0.get(i));
            for(int j = 1; j < (STACKS-1)*4+2; j += 4){
                if(arr0.get(i).length() > j && arr0.get(i).charAt(j) != ' '){
                    int index = (j-1)/4;
                    String c = crates.get(index);
                    crates.set(index, c+ arr0.get(i).charAt(j));
                }
            }
        }
        System.out.println(crates);
    }

    private static void getResults(){

        System.out.println(crates);

        String results = "";
        for(String s : crates){
            results += s.charAt(s.length()-1);
        }
        System.out.println(results);
    }

    private static void partOne(){

        buildCrates();

        //follow the instructions
        for(int i = HEIGHT+3; i < arr0.size(); i++){
            System.out.println(arr0.get(i));
            String[] instructions = arr0.get(i).split(" ");
            int amount = Integer.parseInt(instructions[1]);
            int from = Integer.parseInt(instructions[3])-1;
            int to = Integer.parseInt(instructions[5])-1;
            String c1 = crates.get(from);
            String c2 = crates.get(to);
            for(int j = 0; j < amount; j++){
                c2 += c1.charAt(c1.length()-1);
                c1 = c1.substring(0,c1.length()-1);
            }

            crates.set(to, c2);
            crates.set(from, c1);
            System.out.println(crates);
        }

        getResults();

    }

    private static void fileIO(){
        File inputFile = new File("src/com/company/Day5Input");
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
