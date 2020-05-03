package array;

public class InsertOrder {
    private long[] values = {1, 2, 44, 5, 234, 6567, 23, 5445, 13, 100};

    public void order() {
        // 从第二个元素开始循环
        int i,j;
        for ( i = 1; i <values.length ; i++) {
            long tmp = values[i];
            for ( j = i; j>0 && values[j-1]>tmp ; j--) {
                // 标记的空出来往后移动
                values[j] = values[j-1];
            }
            values[j] = tmp;
        }
    }

    public void display() {
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + ":" + values[i]);
        }
    }

    public static void main(String[] args) {
        InsertOrder insertOrder = new InsertOrder();
        insertOrder.order();
        insertOrder.display();


    }


}
