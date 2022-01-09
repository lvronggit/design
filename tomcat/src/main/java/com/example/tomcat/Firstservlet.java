package com.example.tomcat;

import java.io.IOException;

public class Firstservlet extends GPservlet{

    @Override
    protected void doPost(GPrequest request, GPresponse response) throws IOException {
        response.write("This is my first");
    }

    @Override
    protected void doGet(GPrequest request, GPresponse response) throws IOException {
            this.doPost(request,response);
    }
}
