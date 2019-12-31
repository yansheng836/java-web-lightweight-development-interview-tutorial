import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public class Validator extends HttpServlet {
		private static final long serialVersionUID = 1L;       
	    public Validator() {
	        super();       
	    }	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setContentType()方法用与设定字符编码，如果要显示中文，可以将charset设定为
			// GB18030
			response.setContentType("text/html;charset= GB18030");
			PrintWriter out = response.getWriter();
			//使用request. getParameter()方法获取表单中的值
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>验证页面</TITLE></HEAD>");
			out.println("  <BODY>");
			//判断用户是否填写用户名和密码
			if(username.length()<1||password.length()<1)
			{
				out.println("请输入您的用户名和密码，<a href='../login.jsp'>点击此处返回</a>");
			//判断用户明是否是hacker，如果是，则显示禁止访问页面的信息
			}
			else if(username.equalsIgnoreCase("hacker"))
			{
				out.println("很抱歉，您禁止登录此页面<a href='../login.jsp'>点击此处返回</a>");
			//通过验证，则表示正常登录，页面跳转至welcome.jsp页面
			}
			else
			{		
		response.sendRedirect("../welcome.jsp?username="+username);
			}
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

