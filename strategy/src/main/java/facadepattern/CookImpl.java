package facadepattern;

public class CookImpl implements Cook{
    @Override
    public void first() {
        System.out.println(1);
    }

    @Override
    public void second() {
        System.out.println(2);
    }

    @Override
    public void third() {
        System.out.println(3);
    }

    @Override
    public void four() {
        System.out.println(4);
    }
}
