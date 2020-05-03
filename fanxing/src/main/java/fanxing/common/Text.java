package fanxing.common;

import java.util.Set;

public class Text {
    enum Style{OK,LI,JK,HK}
    public void apply(Set<Style> styles){
        System.out.println(styles.toString());
    }
}
