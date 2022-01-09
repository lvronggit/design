package com.example.tomcat;

import java.io.IOException;

public abstract class GPservlet {

    public void service(GPrequest request,GPresponse response) throws IOException {

        if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    protected abstract void doPost(GPrequest request, GPresponse response) throws IOException;

    protected abstract void doGet(GPrequest request, GPresponse response) throws IOException;

}
