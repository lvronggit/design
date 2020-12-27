package requestcount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements MetricsStorage {
    //...省略属性和构造函数等...
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
    }

    @Override
    public List getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
        //...

        return  new ArrayList();
    }

    @Override
    public Map getRequestInfos(long startTimestamp, long endTimestamp) { //...
        return new HashMap();
    }
}