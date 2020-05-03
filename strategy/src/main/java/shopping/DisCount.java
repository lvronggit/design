package shopping;

public class DisCount implements Activity{
    private double disCount;


    public DisCount(double disCount) {
        this.disCount = disCount;
    }

    @Override
    public double getFinalprice(double previousPrice) {

        return previousPrice*disCount;
    }
}
