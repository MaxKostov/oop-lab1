package oop.lab1.task2;

import java.io.FileNotFoundException;
import java.util.*;

public class TextData {
    private String text;
    private HashMap<String, HashMap<String, Object>> textInfo = new HashMap<>();
//    private String fileName;
//    private int numberOfVowels;
//    private int numberOfConsonants;
//    private int numberOfLetters;
//    private int numberOfSentences;
//    private String longestWord;

    public TextData(String[] pathList) {
        for (String path : pathList) {
            try {
                this.text = FileReader.readFileIntoString(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            textInfo.put(getFileName(path), new HashMap<>());
            textInfo.get(getFileName(path)).put("text", text);
            textInfo.get(getFileName(path)).put("vowels", vowelNum(text));
            textInfo.get(getFileName(path)).put("consonants", consonantNum(text));
            textInfo.get(getFileName(path)).put("letters", vowelNum(text) + consonantNum(text));
            textInfo.get(getFileName(path)).put("sentences", sentenceNum(text));
            textInfo.get(getFileName(path)).put("longestWord", longestWord(text));
            }
//          this.fileName = getFileName(path);
//          this.numberOfVowels = vowelNum(text);
//          this.numberOfConsonants = consonantNum(text);
//          this.numberOfLetters = numberOfConsonants + numberOfVowels;
//          this.numberOfSentences = sentenceNum(text);
//          this.longestWord = longestWord(text);
    }

    public void getAllTexts() {
        for (String file : textInfo.keySet()) {
            System.out.println("FileName: " + file);
            System.out.println("Text: " + textInfo.get(file).get("text"));
            System.out.println(" ");
        }
    }

    public void getTextsWithStat() {
        for (String file : textInfo.keySet()) {
            System.out.println("FileName: " + file);
            System.out.println("Text: " + textInfo.get(file).get("text"));
            System.out.println("Vowels: " + textInfo.get(file).get("vowels"));
            System.out.println("Consonants" + textInfo.get(file).get("consonants"));
            System.out.println("Letters: " + textInfo.get(file).get("letters"));
            System.out.println("Sentences: " + textInfo.get(file).get("sentences"));
            System.out.println("Longest word: " + textInfo.get(file).get("longestWord"));
            System.out.println(" ");
        }
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
        String longestWord;

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

    public String getLongestWord(String filename) {
        return (String) textInfo.get(getFileName(filename)).get("longestWord");
    }

    public int getNumberOfConsonants(String filename) {
        return (Integer) textInfo.get(getFileName(filename)).get("consonants");
    }

    public int getNumberOfLetters(String filename) {
        return (Integer) textInfo.get(getFileName(filename)).get("letters");
    }

    public int getNumberOfSentences(String filename) {
        return (Integer) textInfo.get(getFileName(filename)).get("sentences");
    }

    public int getNumberOfVowels(String filename) {
        return (Integer) textInfo.get(getFileName(filename)).get("vowels");
    }

    public String getText(String fileName) {
        return (String) textInfo.get(fileName).get("text");
    }
}
