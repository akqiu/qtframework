package qt.mvc.common;

//import com.demo.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiutian on 16-9-22.
 */
public  class  BeanFactory{
    public static ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    public static Object Create(String name){
        return context.getBean(name);
    }
}
