package c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TT {
	public static void main(String[] args) {
		final QQ qq = new QQ();
		//qq.run();
		//qq.stop();
		//����
		Car qqProxy =(Car) Proxy.newProxyInstance(QQ.class.getClassLoader(), new Class[]{Car.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//System.out.println("����");
//				System.out.println(method.getName());
				//obj���Ǵ������
//				Object obj = method.invoke(qq, args);
//				return obj;
				
				//�����з�����ǿ
				/*System.out.println("���ϵ��");
				Object obj = method.invoke(qq, args);
				System.out.println("5���ư�");
				
				
				return obj;*/
				
				//ֻ��run������ǿ
				if("run".equals(method.getName())){
					System.out.println("���ϵ��");
					Object obj = method.invoke(qq, args);
					System.out.println("5���ư�");
					return obj;
				}
				return method.invoke(qq, args);
			}
		});
		
//		qqProxy.run();
		qqProxy.stop();
	}
}
