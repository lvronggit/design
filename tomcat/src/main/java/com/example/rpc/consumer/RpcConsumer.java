package com.example.rpc.consumer;

import com.example.rpc.api.IRpcHelloService;
import com.example.rpc.api.IRpcService;
import com.example.rpc.proxy.RpcProxy;

public class RpcConsumer {

    public static void main(String[] args) {
        IRpcHelloService iRpcHelloService = RpcProxy.create(IRpcHelloService.class);

        System.out.println(iRpcHelloService.hello("TOM"));

        IRpcService iRpcService = RpcProxy.create(IRpcService.class);

        System.out.println(iRpcService.add(8,2));

    }
}
