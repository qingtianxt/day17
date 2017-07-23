package a_annocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {


//	public static void main(String[] args) {
//		//运行这个类的时候，测试类中带有@mytest中 的方法都执行
//		
//		
//		//获取字节码对象
//		Class clazz=MyTestTest.class;
//		
//		//获取所有的方法
//		Method[] arr = clazz.getMethods();
//		
//		//让方法执行
//		for (Method method : arr) {
//			//打印所有的方法的名称
//			System.out.println(method.getName());
//		}
//	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//运行这个类的时候，测试类中带有@mytest中 的方法都执行
		//获取字节码对象
		Class clazz=MyTestTest.class;
		
		//获取所有的方法
		Method[] arr = clazz.getMethods();
		
		//让带有注解的方法执行
		for (Method method : arr) {
			//获取所有的注解的方法
			
			//判断方法是否有指定的注解
			boolean flag =method.isAnnotationPresent(MyTest.class);
			if(flag){
				//System.out.println(method.getName());
				method.invoke(clazz.newInstance());
			}
		}
	}
}
