package action;
  
import com.opensymphony.xwork2.ActionSupport;
  
public class myAction extends ActionSupport
{
    private String num1;
    private String num2;
    
    private int n1;
    private int n2;
    
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
   
    public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}


	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public int getSum()
    {
        return n1 + n2;  // 计算两个整数的代码数和
    }
	
	
   public void validate()
   {
      try{
    	  n1 = Integer.valueOf(num1);
      } 
	  catch(Exception e)
	  {
		  addFieldError("num1","num1 is not Nunmber.");		  
	  }
		
      try{
    	  n2= Integer.valueOf(num2);
      } 
	  catch(Exception e)
	  {
		  addFieldError("num2","num2 is not Nunmber.");
	  }
   }
}
