import fanxing.common.*;

import java.util.EnumSet;

public class test {

    public static void main(String[] args) {

        System.out.println( Operation.PLUD.apply(11,22));

        System.out.println(OperationPlus.MINUS.apply(122,122));

        System.out.println(Payrollay.MONDAY.pay(11));

        System.out.println(Ensemble.DUTE.mumber());

        Text text = new Text();
        text.apply(EnumSet.of(Text.Style.HK, Text.Style.JK));
    }
}
