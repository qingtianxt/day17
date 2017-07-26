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
//��̬�����ڵ��÷�����ʱ�򣬲Ŵ�����һ������������ģ�
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("filterִ����");
		//1.ǿת
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//�����������
		HttpServletRequest requestProxy=(HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(), request.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if("getParamter".equals(method.getName())){
					//��ȡ����ʽ
					String m = request.getMethod();
					if("get".equalsIgnoreCase(m)){
						String s= (String) method.invoke(request, args);//�൱��request.getParamter��args��
						return new String(s.getBytes("iso8859-1"),"utf-8");
						
					}else if("post".equalsIgnoreCase(m)){
						System.out.println("post");
						request.setCharacterEncoding("utf-8");
						return method.invoke(request, args);
					}
				}
				//����Ҫ��ǿ�ķ���
				return method.invoke(request, args);
			}
		});
		
		//2.����
		arg2.doFilter(requestProxy, response);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
