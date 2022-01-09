package com.example.tomcat;

import java.io.IOException;
import java.io.OutputStream;

public class GPresponse {


    private OutputStream out;

    public GPresponse(OutputStream out) {
        this.out = out;
    }



    public void write(String s) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        out.write(sb.toString().getBytes());

    }
}
