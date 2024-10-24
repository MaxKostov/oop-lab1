package oop.lab1;

import oop.lab1.task1.Display;
import oop.lab1.task2.TextData;
import oop.lab1.task3.Assistant;


public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(12, 21, "SQ1", 112.0f);
        Display d2 = new Display(10, 18, "SQ2", 90.0f);
        Display d3 = new Display(14, 26, "SQ3", 120.0f);

        d1.compareSize(d2);
        d2.compareSharpness(d2);
        d3.compareWithMonitor(d1);


        TextData td = new TextData(args[0]);
        System.out.println(td.getFileName());
        System.out.println(td.getNumberOfVowels());
        System.out.println(td.getNumberOfConsonants());
        System.out.println(td.getNumberOfLetters());
        System.out.println(td.getNumberOfSentences());
        System.out.println(td.getLongestWord());

        Assistant assistant = new Assistant("Irina");
        assistant.assighDisplay(d1);
        assistant.assighDisplay(d2);
        assistant.assighDisplay(d3);

        assistant.assist();
        System.out.println(assistant.buyDisplay(d2));

    }
}
