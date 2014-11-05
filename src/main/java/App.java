import com.thoughtworks.iamcoach.pos.*;
import com.thoughtworks.iamcoach.pos.service.ProductService;
import com.thoughtworks.iamcoach.pos.service.ProductServiceImpl;
import com.thoughtworks.iamcoach.pos.service.PromotionService;
import com.thoughtworks.iamcoach.pos.service.PromotionServiceImpl;
import com.thoughtworks.iamcoach.pos.utils.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List list = FileUtils.get("cart.txt");
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
            ProductService productService = (ProductService) context.getBean("productService");
            Scanner scanner = new BarcodeScanner(productService);
            PromotionService promotionService = new PromotionServiceImpl();
            Pos pos = new Pos(scanner, promotionService);
            pos.printInventory(list);

        } catch (Exception e) {
            System.out.println("对不起本机暂停服务。。。。。。。。。。");
        }
    }
}
