import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice
{
     public void before(Method m, Object[] args, Object target) throws Throwable
 {
  System.out.println("在方法调用之前");
  System.out.println("执行的方法是:" + m);
  System.out.println("方法的参数是：" + args[0]);
  System.out.println("目标对象是：" + target);
     }
}
