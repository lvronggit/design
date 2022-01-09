package netwok;

import org.junit.Test;

import java.net.*;
import java.util.Enumeration;

/**
 * 打印网络地址
 */
public class PringNetWork {

    @Test
    public void print() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println(networkInterface + "");
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses.hasMoreElements()) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    System.out.print("\tAddress "
                            + ((address instanceof Inet4Address ? "(v4)"
                            : (address instanceof Inet6Address ? "(v6)" :
                            "(?)"))));
                    System.out.println(": " +
                            address.getHostAddress());
                }
            }
        }
    }
}
