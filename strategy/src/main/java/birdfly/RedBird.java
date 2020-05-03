package birdfly;

public class RedBird extends Bird{


    public RedBird(Fly fly){
        this(fly, StyleName.REDBIRD.getName(), Style.RED.getColor());
    }

    public RedBird(Fly fly, String name, String color) {
        super(fly, name, color);
    }


}
