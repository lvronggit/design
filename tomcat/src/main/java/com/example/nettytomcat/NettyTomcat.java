package com.example.nettytomcat;

import com.example.tomcat.GPservlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class NettyTomcat {
    private int port = 8080;

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
            EventLoopGroup boss = new NioEventLoopGroup();
            EventLoopGroup works = new NioEventLoopGroup();

            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, works).channel(NioServerSocketChannel.class)
                   .childOption(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new HttpRequestEncoder());
                            p.addLast(new HttpResponseDecoder());
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
