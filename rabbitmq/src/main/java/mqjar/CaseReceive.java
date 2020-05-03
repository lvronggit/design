package mqjar;
// case 路由处理类
public class CaseReceive implements ReceiveContent{
    @Override
    public void receive(byte[] body) {
        System.out.println(new String(body));
    }
}
