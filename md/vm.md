-verbose:gc 
-Xms20M 
-Xmx20M 
-Xmn10M 
-XX:+PrintGCDetails #打印gc
-XX:SurvivorRatio=8
-XX:+HeapDumpOnOutOfMemoryError  
-Xss128k # 栈大小设置

-XX:+PrintAssembly
