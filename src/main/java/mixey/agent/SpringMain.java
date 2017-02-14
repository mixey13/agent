package mixey.agent;

import mixey.agent.model.Product;
import mixey.agent.web.ProductAjaxController;
import mixey.agent.web.ProductRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml", "spring/spring-mvc.xml");
        ProductRestController controller = appCtx.getBean(ProductRestController.class);
        System.out.println();
//        controller.save(new Product("Ветчина", "bbbbbbbbbbbbbbb"));
//        controller.delete(100001);
        List<Product> list = controller.getAll();
        list.forEach(System.out::println);
        System.out.println();
        appCtx.close();
    }
}
