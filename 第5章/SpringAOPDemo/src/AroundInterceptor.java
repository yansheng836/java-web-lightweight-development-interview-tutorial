import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class AroundInterceptor implements MethodInterceptor
{
     public Object invoke(MethodInvocation invocation) throws Throwable
 {
         System.out.println("调用方法之前: invocation对象：[" + invocation + "]");
         Object rval = invocation.proceed();
         System.out.println("调用结束...");
         return rval;
    }
}