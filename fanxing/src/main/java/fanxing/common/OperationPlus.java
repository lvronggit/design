package fanxing.common;

public enum  OperationPlus {


    PLUD {public double apply(double x,double y){
        return x + y; }

    },

    MINUS{ public double apply(double x,double y){
        return x - y; }

    },

    TIMES{public double apply(double x,double y){
        return x * y; }

    },

    DIVIDE{public double apply(double x,double y){
        return x % y; }

    };

    public abstract double apply(double x,double y);
}
