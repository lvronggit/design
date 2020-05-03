package array;

import java.util.Arrays;

// 自己写的数组类二分查找
public class SelfArray {
    // 数据存储
    long[] values ;
    // 指标
    int nElemnt;

    public boolean insert(long value){
        if(nElemnt == values.length){
            return false;
        }
      // 插入的位置
        int j = 0;
        for (j = 0;  j<nElemnt ; j++) {
            if(values[j] > value){
                break;
            }
        }
        for (int i = nElemnt; i > j ; i--){
            values[i] = values[i-1];
        }
        values[j] = value;
        nElemnt++;
        return true;
    }

    public boolean delete(long value){
        for (int i = 0; i < nElemnt; i++) {
            if(values[i] == value){
                for (int j = i; j <nElemnt-1 ; j++) {
                    values[j] = values[j+1];
                }
                nElemnt--;
                return true;
            }
        }
        return false;
    }


    public SelfArray(int nElemnt) {
        this.values = new long[nElemnt];
        this.nElemnt = 0;
    }


    public void display(){

        for (int i = 0; i <nElemnt ; i++) {
            System.out.println("values["+i+"]"+values[i]);
        }
    }


    public int find(long searchkey){
        int lowindex  = 0;
        int highindex = nElemnt;

        while(1==1){
            int index = (lowindex+highindex)/2;
            long value = values[index];
            // 找到
            if(value == searchkey){
                return index;
            // 未找到
            }else if(lowindex>highindex){
                return -1;

            }else if(value > searchkey){
                highindex--;
            }else{
                lowindex++;
            }
        }
    }



    public static void main(String[] args) {
        SelfArray selfArray = new SelfArray(10);
        selfArray.insert(2);
        selfArray.insert(3);
        selfArray.insert(1);
        selfArray.insert(0);
        selfArray.insert(100);
        selfArray.insert(-1);
        selfArray.insert(-111);
        selfArray.insert(-12222);
        selfArray.insert(-121);
        selfArray.insert(-122);
        selfArray.display();
        System.out.println("=========================================");
        selfArray.delete(0);
        selfArray.display();
        System.out.println(selfArray.find(0));
    }
}
