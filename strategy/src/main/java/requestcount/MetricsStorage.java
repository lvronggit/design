package requestcount;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);
    List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);
    Map getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}