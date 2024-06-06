package com.example.cgitask.api.model;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    private String input;

    public WordFrequency(String input) {

        this.input = input;
    }

    public String getInput(){
        return input;

    }


    // Call this method to get the json string with all counts for the 10 most common words.
    public String count() {
        List<Map.Entry<String, Integer>> wordFrequencies = WordFrequencyUtils.calculateFrequencies(this.getInput());
       return WordFrequencyUtils.returnList(wordFrequencies);
    }

}