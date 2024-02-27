package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;;

public class Wordcount {
    public static void main(String[] args) {

        HashMap<String,Integer> map= new HashMap<>();
        String filename = "C:\\Users\\pavan\\Desktop\\programming\\wordtext.txt"; 
        try (BufferedReader read = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = read.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] lineWords = line.split("\\s+");
                    for (String word : lineWords) {
                        // System.out.println(word);
                        mapper(word,map);
                    }
                }
            }
        } 
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        printWordCounts(map);


    }
    public static int totalcount=0;

    public static void mapper(String word,HashMap<String,Integer> map){
        totalcount++;
        if(map.containsKey(word)){
            map.put(word,map.get(word)+1);
        }
        else{
            map.put(word,1);
        }
    }

    public static void printWordCounts(HashMap<String,Integer> wordMap) {
        ArrayList<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());

        System.out.println("Total words count in the file: " + totalcount);
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


}
