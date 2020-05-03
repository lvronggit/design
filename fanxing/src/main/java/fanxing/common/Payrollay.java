package fanxing.common;

public enum Payrollay {
    MONDAY(PayType.WORKER),
    THURDAY(PayType.WORKER),
    WENDARY(PayType.WORKER),
    THUDAY(PayType.WEEKEND);

    private final PayType payType;

    Payrollay(PayType payType) {
        this.payType = payType;
    }

    public double pay(double time){
        return payType.overtimepay( time);
    }

    enum PayType {

        WEEKEND{
            double overtimepay ( double time){
                return 2 * time;
            }

        },
        WORKER{
            double overtimepay ( double time){
                return 1.5 * time;
            }

        };

        private static final int HOUSE_PER_SHIFT = 8;

        abstract double overtimepay(double time);



    }


}
