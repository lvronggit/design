package future.demo;

import com.oracle.tools.packager.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 主线程
 *
 * 创建99 个子线程执行任务
 *
 */
public class FutureMain {


    public static void main(String[] args) {

        List<Requestfuture> requestfutures = new ArrayList<>();

        for (int i = 0;i<100;i++){
            Requestfuture requestfuture = new Requestfuture();
            requestfutures.add(requestfuture);
            SubThread subThread = new SubThread(requestfuture);
            subThread.setName("异步执行"+i);
            subThread.start();
        }

        for(Requestfuture re : requestfutures){
            Response response = re.get();
            System.out.println(response);
        }

    }

}
