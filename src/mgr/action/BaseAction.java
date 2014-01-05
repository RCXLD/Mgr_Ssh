package mgr.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ApplicationAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected boolean hasMessage = false;

	public void setMessage(String key, String value) {
		hasMessage = true;
		request.setAttribute(key, value);
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
