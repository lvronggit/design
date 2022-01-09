package com.example.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class GPrequest {
    private String method;
    private String url;


    public GPrequest(InputStream inputStream) {
        try {

            String content = "";
        byte[] bytes = new byte[1024];
        int len = 0;
            if((len = inputStream.read(bytes) ) >0){
                content = new String(bytes);
            }
            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");
            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
