package oop.lab1.task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int height, int width, String model, float ppi) {
        this.height = height;
        this.model = model;
        this.ppi = ppi;
        this.width = width;
    }

    public void compareSize(Display m) {
        float currentDiagonal = (float) Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
        float targetDiagonal = (float) Math.sqrt(Math.pow(m.width, 2) + Math.pow(m.height, 2));

        if (currentDiagonal > targetDiagonal) {
            System.out.println(String.format( "The invoking display (S/N: %s, %.2f\") is larger than the target display (S/N: %s, %.2f\").",
                    this.model, currentDiagonal, m.model, targetDiagonal));
        }
        else if (currentDiagonal < targetDiagonal) {
            System.out.println(String.format("The target display (S/N: %s, %.2f\") is larger than the invoking display (S/N: %s, %.2f\").",
                    m.model, targetDiagonal, this.model, currentDiagonal));
        }
        else {
            System.out.println("Both displays are the same size: " + currentDiagonal + " and " + targetDiagonal);
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(String.format("Invoking display(Serial Number: %s) %f ppi > target display(Serial Number: %s) %f ppi", this.model, this.ppi, m.model, m.ppi));
        }
        else if (this.ppi < m.ppi) {
            System.out.println(String.format("Invoking display(Serial Number: %s) %f ppi < target display(Serial Number: %s) %f ppi", this.model, this.ppi, m.model, m.ppi));
        }
        else {
            System.out.println("Both displays have the same ppi: " + this.ppi);
        }
    }

    public void compareWithMonitor(Display m) {
        this.compareSize(m);
        this.compareSharpness(m);
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPpi() {
        return ppi;
    }

    public void setPpi(float ppi) {
        this.ppi = ppi;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
