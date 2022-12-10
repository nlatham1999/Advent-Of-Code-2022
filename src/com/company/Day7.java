package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7 {

    static ArrayList<String> arr0 = new ArrayList<>();
    static Hashtable<String, ArrayList<String>> folderStructure = new Hashtable<>();
    static ArrayList<Integer> sizes = new ArrayList<>();
    static int totalSum = 0;

    public static void Day7(){

        fileIO();

//        partOne();

        partTwo();
    }

    private static void buildFolderStructure(){

        ArrayList<String> directory = new ArrayList<>();

        ArrayList<String> contents = new ArrayList<>();

        String indent = "";
        for(int i = 0; i < arr0.size(); i++){
            String line = arr0.get(i);
            if(line.charAt(0) == '$'){
                String[] inputs = line.split(" ");
                if(inputs[1].equals("cd")){
                    if(inputs[2].equals("..")){
                        directory.remove(directory.size()-1);
                        indent = indent.substring(0,indent.length()-1);
                    }else{
                        directory.add(inputs[2]);
                        indent += " ";
                    }
                }else{
                    contents = new ArrayList<>();
                }
            }else{
                contents.add(line);
                if(i+1 == arr0.size() || arr0.get(i+1).charAt(0) == '$'){
                    String key = "";
                    for(int j = 0; j < directory.size(); j++){
                        key += directory.get(j);
                        if(j + 1 < directory.size()){
                            key += "-";
                        }
                    }
                    folderStructure.put(key, (ArrayList<String>) contents.clone());
                }
            }
        }
        System.out.println(folderStructure);
    }

    private static int traverseFolders(String key, String indent){

        ArrayList<String> lines = folderStructure.get(key);

        int totalSize = 0;
        for(int i = 0; i < lines.size(); i++){
            String[] parts = lines.get(i).split(" ");
            if(parts[0].equals("dir")){
//                System.out.println(indent + lines.get(i));
                int size = traverseFolders(key + "-" + parts[1], indent + " ");
                totalSize += size;
                System.out.println(key + "-" + parts[1] + " " + size);
            }else{
                int size = Integer.parseInt(parts[0]);
                totalSize += size;
//                System.out.println(indent + size);
            }
        }
        if(totalSize <= 100000)
           totalSum += totalSize;
        sizes.add(totalSize);
        return totalSize;
    }

    private static void partOne(){
        buildFolderStructure();

        int size = traverseFolders("/", "");
        if(size <= 100000)
            totalSum += size;

        System.out.println(totalSum);
    }

    private static void partTwo(){
        buildFolderStructure();

        int size = traverseFolders("/", "");
        int sizeNeeded = 30000000 - (70000000 - size);
        System.out.println(size);
        System.out.println(sizeNeeded);


        Collections.sort(sizes);
        for(int i = 1; i < sizes.size(); i++){
            if(sizes.get(i) > sizeNeeded && sizes.get(i-1) < sizeNeeded){
                System.out.println(sizes.get(i));
                return;
            }
        }
    }



    private static void fileIO(){
        File inputFile = new File("src/com/company/Day7Input");
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
