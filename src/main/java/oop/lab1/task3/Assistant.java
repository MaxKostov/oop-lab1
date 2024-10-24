package oop.lab1.task3;

import oop.lab1.task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays = new ArrayList<>();

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void assighDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
        for (int i = 0; i < assignedDisplays.size()-1; i++) {
            for (int j = i+1; j < assignedDisplays.size(); j++) {
                assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(j));
            }
            System.out.println(" ");
        }
    }

    public Display buyDisplay(Display display) {
        if (!assignedDisplays.contains(display)) {
            throw new IllegalArgumentException("There is no such display");
        }

        return assignedDisplays.remove(assignedDisplays.indexOf(display));
    }
}
