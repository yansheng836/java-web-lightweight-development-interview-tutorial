import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Main
{
    public static void main(String[] args)throws Exception
{
  ApplicationContext ctx = new FileSystemXmlApplicationContext("src/ApplicationContext.xml");
  Account account = (Account)ctx.getBean("account");

  System.out.println("第一个add方法");
  account.add(100);
  System.out.println("第二个minus方法");  
  account.minus(100);
    }
}
