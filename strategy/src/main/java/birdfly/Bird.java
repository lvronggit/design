package birdfly;

/**
 *鸟的飞行类
 */
public abstract class Bird {
    private String name;

    private String color;

    private Fly fly;

    public  void fly(){
        System.out.print(name);
        fly.Fly();
    }

    public Bird(Fly fly) {
       this(fly, StyleName.REDBIRD.getName(), Style.RED.getColor());
    }

    public Bird(Fly fly, String name, String color) {
        this.fly = fly;
        this.name = name;
        this.color = color;
    }

    public Bird() {
    }

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
