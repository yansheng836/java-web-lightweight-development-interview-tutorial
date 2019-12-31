package action;
  
import com.opensymphony.xwork2.ActionSupport;
  
public class myAction extends ActionSupport
{
    private int num1;
    private int num2;
    
    public String execute() throws Exception
    {
    	// 如果和是大于等于0，跳到positive.jsp页面
    	if (getSum() >= 0)  
        {
            return "Positive";
        }
    	// 如果否则跳到negative.jsp页面
        else  
        {
            return "Negative";
        }
    }
   
    public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}


	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getSum()
    {
        return num1 + num2;  // 计算两个整数的代码数和
    }
}