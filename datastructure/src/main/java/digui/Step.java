package digui;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼
 * 一次只能走一步或者两步
 * <p>
 * 给定楼层高度  有多少种爬楼方式
 */
public class Step {

    public static void main(String[] args) {
        int step = 50;
        Step ste = new Step();
        System.out.println("开始===");
        long one = System.currentTimeMillis();
        System.out.println(ste.stepStyles(step));;
        long two = System.currentTimeMillis();
        System.out.println(two-one);
        System.out.println(ste.stepStylesCache(step));;
        long three = System.currentTimeMillis();
        System.out.println(three-two);
    }

    public int stepStyles(int step) {
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        return stepStyles(step - 1) + stepStyles(step - 2);
    }

    private Map<Integer, Long> stepStyle = new HashMap<Integer, Long>();

    /**
     * 缓存一些数据
     *
     * @param step
     * @return
     */
    public long stepStylesCache(int step) {
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        Long integer = stepStyle.get(step);
        if (integer == null) {
            integer = stepStylesCache(step - 2) + stepStylesCache(step - 1);
            stepStyle.put(step, integer);
        }
        return integer;
    }


}
