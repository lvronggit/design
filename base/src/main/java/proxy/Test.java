package proxy;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        TrueService trueService = new TrueService(new RealSubject());

        SubjectService subjectService =    (SubjectService)trueService.getSubject();
        subjectService.doSomeThing();
    }
}
