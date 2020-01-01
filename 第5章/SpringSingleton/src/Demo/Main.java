package Demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        Resource res = new ClassPathResource("Demo/bean.xml");
        BeanFactory ft = new XmlBeanFactory(res);

        Random r1 = (Random)ft.getBean("ran");
        Random r2 = (Random)ft.getBean("ran");
        System.out.println("Random的两个实例是否指向同一个引用：" + (r1 == r2));
        r1.printRandom();
        r2.printRandom();        
    }

}  
