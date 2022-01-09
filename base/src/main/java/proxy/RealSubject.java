package proxy;

import javax.security.auth.Subject;

public class RealSubject implements SubjectService {


  @Override
  public void doSomeThing() {

      System.out.println( "call doSomething()" );
  }
}
