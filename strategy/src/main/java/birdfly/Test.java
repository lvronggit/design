package birdfly;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Bird bird = new BlueBird(new RoundFly());
        bird.fly();
        Bird bird1 = new BlueBird();
        List<Fly> flies = new LinkedList<Fly>();
        flies.add(new RoundFly());
        flies.add(new StraightFly());
        flies.add(new RoundFly());
        ((BlueBird) bird1).setFlyList(flies);
        bird1.fly();

    }
}
