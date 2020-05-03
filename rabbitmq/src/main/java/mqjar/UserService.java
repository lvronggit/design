package mqjar;
// 用户路由处理类
public class UserService implements ReceiveContent{
    @Override
    public void receive(byte[] body) {
        System.out.println(new String(body));
    }
}
