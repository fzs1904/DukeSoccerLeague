package duke.soccer.web.interceptor;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LeagueFormInterceptor implements Interceptor{
	private String[]seasons_list;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
//		if(seasons_list==null)
//		{
//			ServletContext ctx=ServletActionContext.getServletContext();
//			seasons_list = ctx.getInitParameter("seasons_list").split(",");
//			
//		}
		ActionContext actCtx = invocation.getInvocationContext();
		actCtx.put("seasons_list", seasons_list);
		String result = invocation.invoke();
		return result;
	}

	public void setSeasons_list(String[] seasons_list) {
		this.seasons_list = seasons_list;
	}

}
