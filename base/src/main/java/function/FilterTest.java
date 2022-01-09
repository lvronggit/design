package function;

import com.sun.tools.javac.util.Assert;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("12222");
        objects.add("1223");
        Stream<String> stringStream = objects.stream().filter(s -> {
            System.out.println(s);
            return s.contains("12");
        });


        Comparator<String> comparing = Comparator.comparing(String::length);
        String s = stringStream.min(comparing).get();
        System.out.println(s);

    }


}
