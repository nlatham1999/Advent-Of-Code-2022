package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day2 {

    static ArrayList<String> arr0 = new ArrayList<>();

    public static void Day2(){

        fileIO();


        partOne();

        partTwo();
    }

    private static void partTwo(){
        int score = 0;
        for(int i = 0 ; i < arr0.size(); i++){
            char enemy = arr0.get(i).charAt(0);
            char player = arr0.get(i).charAt(2);

            if(player == 'X'){
                if(enemy == 'A'){
                    score += 3;
                }
                else if(enemy == 'B'){
                    score += 1;
                }
                else if(enemy == 'C'){
                    score += 2;
                }
            }
            if(player == 'Y'){
                if(enemy == 'A'){
                    score += 4;
                }
                else if(enemy == 'B'){
                    score += 5;
                }
                else if(enemy == 'C'){
                    score += 6;
                }
            }
            if(player == 'Z'){
                if(enemy == 'A'){
                    score += 8;
                }
                else if(enemy == 'B'){
                    score += 9;
                }
                else if(enemy == 'C'){
                    score += 7;
                }
            }

        }

        System.out.println(score);
    }

    private static void partOne(){
        int score = 0;
        for(int i = 0 ; i < arr0.size(); i++){
            char enemy = arr0.get(i).charAt(0);
            char player = arr0.get(i).charAt(2);

            if(player == 'X'){
                score += 1;
                if(enemy == 'A'){
                    score += 3;
                }
                else if(enemy == 'B'){
                    score += 0;
                }
                else if(enemy == 'C'){
                    score += 6;
                }
            }
            if(player == 'Y'){
                score += 2;
                if(enemy == 'A'){
                    score += 6;
                }
                else if(enemy == 'B'){
                    score += 3;
                }
                else if(enemy == 'C'){
                    score += 0;
                }
            }
            if(player == 'Z'){
                score += 3;
                if(enemy == 'A'){
                    score += 0;
                }
                else if(enemy == 'B'){
                    score += 6;
                }
                else if(enemy == 'C'){
                    score += 3;
                }
            }

        }

        System.out.println(score);
    }


    private static void fileIO(){
        File inputFile = new File("src/com/company/Day2Input");
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
