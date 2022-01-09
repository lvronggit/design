package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TrueService implements InvocationHandler {

    private Object subject;


    public TrueService(Object subject) {
        this.subject = subject;
        Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),this);
    }

    public Object getSubject(){
        return Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),this);
    }
    /**
     * @author haozz
     * @date 2018-05-21 11:09
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果
     * @throws Throwable 异常
     * @description 代理方法逻辑
     **/
    @Override
    public Object invoke(Object proxy, Method method,Object [] args) throws Throwable{
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(subject,args);//相当于调用sayHelloWorld方法
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }



}
