package Thuawei;

import javax.lang.model.element.VariableElement;
import java.util.*;
import java.util.stream.Stream;

public class Test2 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String allperson  = scanner.nextLine();

        String penson = scanner.nextLine();

        String spower  = scanner.nextLine();

        int power = Integer.valueOf(spower);

        int ou = power%2;

        int mpower = power / 2;

        String[] all = penson.split(" ");

       int count = 0;
        List<Integer> tlow = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            Integer po = Integer.valueOf(all[i]);
            if (po >= power) {
                count++;
            } else if (ou ==0 && po >= mpower ) {
                middle.add(po);
            } else if (ou !=0 && po > mpower) {
                middle.add(po);
            } else {
                tlow.add(po);
            }

        }

        if(middle.size()<=0){
            System.out.println(count);
            return ;
        }

        if(tlow.size() <= 0){
            count = count+middle.size()/2;
            System.out.println(count);
            return ;

        }

        tlow.sort(Integer::compareTo);
        middle.sort(Integer::compareTo);

        Set<Integer> tlowi = new HashSet<Integer>();

        int begin = middle.size()-1;
        for (int i = 0; i < tlow.size(); i++) {
            int l = tlow.get(i);
            if(begin < 0){
                break;
            }
            for ( int j = begin; j >= 0;j--) {
                int m = middle.get(j);
                if (!tlowi.contains(j) && (l + m) >= power ) {
                    count++;
                    begin = j-1;
                    tlowi.add(j);
                    break;
                }

            }
        }
        int isize = middle.size()- tlowi.size();
        count  =  count + isize/2;
        System.out.println(count);
    }


}
