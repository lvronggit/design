package com.example.rpc.provider;

import com.example.rpc.api.IRpcHelloService;

public class RpcHelloServiceimpl implements IRpcHelloService {
    @Override
    public String hello(String name) {

        return "hello" + name;
    }
}
