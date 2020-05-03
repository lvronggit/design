package fanxing.common;

public enum  Operation {

    PLUD,

    MINUS,

    TIMES,

    DIVIDE;

     Operation() {

    }


    public double apply(double x,double y){
        switch (this){
            case PLUD:
                return x+y;
            case MINUS:
                return x-y;
            case TIMES:
                return x*y;
            case DIVIDE:
                return x%y;
        }
        throw new NullPointerException();
    }
}
