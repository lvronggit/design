import config.SokConfigration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class springApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SokConfigration.class);

        UserService bean = applicationContext.getBean(UserService.class);
        bean.getUser();
    }
}
