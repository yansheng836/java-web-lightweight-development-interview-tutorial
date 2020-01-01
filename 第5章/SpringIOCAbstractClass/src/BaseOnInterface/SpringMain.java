package BaseOnInterface;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringMain {
    public static void main(String[] args) {

        Resource res = new ClassPathResource("BaseOnInterface/bean.xml");
        BeanFactory ft = new XmlBeanFactory(res);

        HelloInterface h = (HelloInterface) ft.getBean("hello");

        Random random = h.createRandom();        
        random.printRandom();

    }

}  
