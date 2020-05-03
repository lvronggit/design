package factory;

import java.io.File;
import java.net.URL;

public class GetClasses {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       String packagename =  GetClasses.class.getPackage().getName();
        System.out.println(packagename);

        URL url =  Thread.currentThread().getContextClassLoader().getResource(packagename);
        System.out.println(url);

        File file = new File(url.getFile());

        String[] paths= file.list();

        File file1 = new File(paths[0]);

        String name = file1.getName();
        System.out.println(name);
        Class  cal= Class.forName(packagename + '.' + name.substring(0, name.length() - 6));
        System.out.println(cal);
        cal.isAssignableFrom(cal);
        BlackHuman blackHuman =(BlackHuman)cal.newInstance();
        blackHuman.cry();
        blackHuman.laugh();
        blackHuman.talk();
    }
}
