package org.hqu.production_ms.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.hqu.production_ms.util.JsonUtils;

/**
 * 
 * created on 2016年10月19日 
 *
 *  1.自定义角色鉴权过滤器(满足其中一个角色则认证通过) 2.扩展异步请求认证提示功能;  
 *
 * @author  megagao
 * @version  0.0.1
 */
public class RoleAuthorizationFilter extends AuthorizationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {  
		  
		Logger logger = Logger.getLogger("AuthorizationLogger");  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
  
        Subject subject = getSubject(request, response);  
        
        Map<String,Object> map = new HashMap<String,Object>(); 
  
        if (subject.getPrincipal() == null) {  
        	map.put("msg", "您尚未登录或登录时间过长,请重新登录!");
        	
        } else {  
        	map.put("msg", "您没有足够的权限执行该操作!");
        }
        
        httpResponse.setCharacterEncoding("UTF-8");  
    	httpResponse.setContentType("application/json; charset=utf-8");  
    	PrintWriter out = null;  
        try {  
            out = response.getWriter();  
            out.append(JsonUtils.objectToJson(map));  
            logger.debug(JsonUtils.objectToJson(map));  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (out != null) {  
                out.close();  
            }  
        }  
        return false;  
    }  
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		
	    Subject subject = getSubject(request, response);
		String[] perms = (String[]) mappedValue;
		
		boolean isPermitted = true;
		if (perms != null && perms.length > 0) {
		    if (perms.length == 1) {
		        if (!subject.isPermitted(perms[0])) {
		            isPermitted = false;
		        }
		    } else {
		        if (!subject.isPermittedAll(perms)) {
		            isPermitted = false;
		        }
		    }
		}
		
		return isPermitted;
    }  
	
}
