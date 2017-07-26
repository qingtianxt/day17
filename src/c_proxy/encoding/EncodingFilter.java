package c_proxy.encoding;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//动态代理：在调用方法的时候，才创建的一个方法（虚拟的）
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("filter执行了");
		//1.强转
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//创建代理对象
		HttpServletRequest requestProxy=(HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(), request.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if("getParamter".equals(method.getName())){
					//获取请求方式
					String m = request.getMethod();
					if("get".equalsIgnoreCase(m)){
						String s= (String) method.invoke(request, args);//相当于request.getParamter（args）
						return new String(s.getBytes("iso8859-1"),"utf-8");
						
					}else if("post".equalsIgnoreCase(m)){
						System.out.println("post");
						request.setCharacterEncoding("utf-8");
						return method.invoke(request, args);
					}
				}
				//不需要加强的方法
				return method.invoke(request, args);
			}
		});
		
		//2.放行
		arg2.doFilter(requestProxy, response);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
