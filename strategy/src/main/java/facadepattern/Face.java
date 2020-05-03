package facadepattern;

public class Face {

    private Cook cook;

    public Face(Cook cook) {
        this.cook = cook;
    }

    public void cook(){
        cook.first();
        cook.second();
        cook.third();
        cook.four();
    }

    public static void main(String[] args) {
        Face face  = new Face(new CookImpl());
        face.cook();
    }
}
