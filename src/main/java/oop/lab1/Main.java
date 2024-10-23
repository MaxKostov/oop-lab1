package oop.lab1;

import oop.lab1.task1.Display;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(12, 21, "SQ1", 112.0f);
        Display d2 = new Display(10, 18, "SQ2", 90.0f);
        Display d3 = new Display(14, 26, "SQ3", 120.0f);

        d1.compareSize(d2);
        d2.compareSharpness(d2);
        d3.compareWithMonitor(d1);
    }
}
