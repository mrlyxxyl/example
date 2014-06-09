package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String user = (String) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            return actionInvocation.invoke();
        }
        ActionContext.getContext().put("message", "��û��Ȩ�ޣ�");
        return "message";
    }
}
