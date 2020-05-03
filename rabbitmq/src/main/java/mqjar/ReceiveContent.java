package mqjar;

public interface ReceiveContent {
    /**
     * 用来接收mq发来的消息
      * @param body
     */
     void receive(byte[] body);

}
