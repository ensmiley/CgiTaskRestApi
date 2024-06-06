package com.example.cgitask.api.model;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyUtils {


    //This function takes in a raw string. It removes any numbers or signs to make it to pure text form.
    //it then creates a hashmap to add the occurence of the word to the word map. The hash maps are then
    //converted to a list which is returned
    public static List<Map.Entry<String, Integer>> calculateFrequencies(String input) {


        //encode the input in UTF-8 instead to include swedish characters
        try {
            // Decode the URL-encoded input string
            input = URLDecoder.decode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // Handle encoding exception
            System.err.println("Unsupported encoding: " + e.getMessage());
            //return Collections.emptyList();
        }

        // Split the input string into words, allowing for the swedish alphabet
        String cleanedInput = input.replaceAll("[^a-zA-ZåäöÅÄÖ0-9]", " ");
        String[] words = cleanedInput.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            //compare words by making them lowercase
            word = word.toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Convert the map entries to a list
        List<Map.Entry<String, Integer>> wordFrequencyList = new ArrayList<>(wordCountMap.entrySet());

        // Sort the list by frequency, using lambda expression to define the comparator.
        wordFrequencyList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        return wordFrequencyList;
    }


    //this method checks the returned list, sorts it and picks out the ten most frequent occurences.
    // It returns a "synthetic" JSON string.
    public static String returnList(List<Map.Entry<String, Integer>> wordFrequencyList) {

        // Create a String builder to construct a JSON compatible string that will be returned
        StringBuilder jsonBuilder = new StringBuilder("{");

        // Iterate over the top ten entries
        int limit = Math.min(10, wordFrequencyList.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = wordFrequencyList.get(i);
            String word = entry.getKey();

            //get the frequency
            int frequency = entry.getValue();
            // Append the frequent word and its frequency to the StringBuilder object.
            jsonBuilder.append("\"").append(word).append("\":").append(frequency);
            // Add comma if it's not the last entry
            if (i < limit - 1) {
                jsonBuilder.append(",");
            }
        }
        // Close the JSON object
        jsonBuilder.append("}");

        // Return the JSON string
        return jsonBuilder.toString();
    }


}
