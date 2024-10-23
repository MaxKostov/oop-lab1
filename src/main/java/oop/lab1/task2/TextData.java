package oop.lab1.task2;

import java.io.FileNotFoundException;
import java.util.*;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String path) {
        try {
            this.text = FileReader.readFileIntoString(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.fileName = getFileName(path);
        this.numberOfVowels = vowelNum(text);
        this.numberOfConsonants = consonantNum(text);
        this.numberOfLetters = numberOfConsonants + numberOfVowels;
        this.numberOfSentences = sentenceNum(text);
        this.longestWord = longestWord(text);
    }


    private String getFileName(String text) {
        List<String> words = Arrays.asList(text.split("/"));
        return words.getLast();
    }

    private int vowelNum(String text) {
        int vowels = 0;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < text.length(); i++) {
            if (vowelSet.contains(text.toLowerCase().charAt(i))) {
                vowels += 1;
            }
        }
        return vowels;
    }

    private int consonantNum(String text) {
        int consonants = 0;
        Set<Character> consonantSet = new HashSet<>(Arrays.asList(
                'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
        ));
        for (int i = 0; i < text.length(); i++) {
            if (consonantSet.contains(text.toLowerCase().charAt(i))) {
                consonants += 1;
            }
        }
        return consonants;
    }

    private String longestWord(String text) {
        List<String> rawWords = Arrays.asList(text.split(" "));
        List<String> words = rawWords.stream().map(s -> {return s.replaceAll("[^a-zA-Z ]", "");
        }).toList();

        return longestWord = words.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    private int sentenceNum(String text) {
        int sentences = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                sentences += 1;
            }
        }
        return sentences;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public String getText() {
        return text;
    }
}
