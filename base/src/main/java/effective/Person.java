package effective;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 对象尽量复用,这个类起始创建日期对象,并每次复用,不创建新的日期检测对象
 */
public class Person {

    private final Date birthDay = new Date();
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);

        BOOM_START = gmtCal.getTime();

        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);

        BOOM_END = gmtCal.getTime();
    }


    public boolean idBabyBoomer(){
        return birthDay.compareTo(BOOM_START)>=0 && birthDay.compareTo(BOOM_END)<0;
    }



}
