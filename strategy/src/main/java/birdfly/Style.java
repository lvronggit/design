package birdfly;

public enum Style {
    RED("red"),
    BLUE("blue")
    ;

    Style(String color) {
        this.color = color;
    }

    private String color;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
