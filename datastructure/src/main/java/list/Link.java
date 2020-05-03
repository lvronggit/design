package list;

public class Link {
    public double aDouble;
    public Link next;

    public Link(double aDouble, Link next) {
        this.aDouble = aDouble;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Link{" +
                "aDouble=" + aDouble +
                ", next=" + next +
                '}';
    }
}
