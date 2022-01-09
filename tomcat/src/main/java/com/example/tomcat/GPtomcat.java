package com.example.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * tomcat服务器
 */
public class GPtomcat {

    private int port = 8080;

    private ServerSocket serverSocke;

    private Map<String, GPservlet> servletMap = new HashMap<>();

    private Properties webxml = new Properties();

    private void init() {

        try {
            String path = this.getClass().getResource("/").getPath();

            FileInputStream fileInputStream = new FileInputStream(path+"web.properties");

            webxml.load(fileInputStream);

            for (Object k : webxml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {
                    String servname = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    String className = webxml.getProperty(servname + ".className");
                    GPservlet obj = (GPservlet) Class.forName(className).newInstance();
                    servletMap.put(url, obj);
                }

            }
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        init();

        try {
            serverSocke = new ServerSocket(port);
            System.out.println("启动tomcat");
            while (true) {
                Socket client = serverSocke.accept();
                process(client);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void process(Socket client) {
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            GPrequest request = new GPrequest(inputStream);
            GPresponse response = new GPresponse(outputStream);
            String url = request.getUrl();

            if(servletMap.containsKey(url)){
               servletMap.get(url).service(request,response);
            }else{
                response.write("404-notfond");
            }


            outputStream.flush();
            outputStream.close();
            inputStream.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new GPtomcat().start();

    }

}
