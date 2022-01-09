package com.example.tomcat;

import java.io.IOException;

public class Secondservlet extends GPservlet{

    @Override
    protected void doPost(GPrequest request, GPresponse response) throws IOException {
        response.write("This is my second");
    }

    @Override
    protected void doGet(GPrequest request, GPresponse response) throws IOException {
            this.doPost(request,response);
    }
}
