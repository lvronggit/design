package com.example.rpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryHandler extends ChannelInboundHandlerAdapter {
    private static String privateDir = "com.example.rpc.provider";
    // 保存可用服务
    public static ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>();
    // 保存服务类
    private List<String> classNames = new ArrayList<>();

    public RegistryHandler() {
        scannerClass(privateDir);
        doRegister();
    }

    // 递归扫描
    void scannerClass(String pakegeName) {

        URL url = this.getClass().getClassLoader().getResource(pakegeName.replaceAll("\\.", "/"));

        File dir = new File(url.getFile());

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {

                scannerClass(pakegeName + "." + file.getName());

            } else {
                classNames.add(pakegeName + "." +
                        file.getName().replaceAll(".class", "").trim());
            }

        }

    }

    // 注册服务
    private void doRegister() {
        if (classNames.size() == 0) {
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> aClass = Class.forName(className);
                Class<?> anInterface = aClass.getInterfaces()[0];
                registryMap.put(anInterface.getName(), aClass.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }


        }

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;
        Object clazz = registryMap.get(request.getClassName());
        Method method = clazz.getClass().getMethod(request.getMethodName(),request.getParames());
        result = method.invoke(clazz, request.getValues());

        ctx.write(result);
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }
}
