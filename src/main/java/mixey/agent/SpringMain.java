package mixey.agent;

import mixey.agent.model.Product;
import mixey.agent.web.ProductRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by s_adm on 08.02.2017.
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        ProductRestController controller = appCtx.getBean(ProductRestController.class);
        List<Product> list = controller.getAll();
        list.forEach(System.out::println);
        appCtx.close();
    }
}
