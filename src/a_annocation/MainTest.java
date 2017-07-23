package a_annocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {


//	public static void main(String[] args) {
//		//����������ʱ�򣬲������д���@mytest�� �ķ�����ִ��
//		
//		
//		//��ȡ�ֽ������
//		Class clazz=MyTestTest.class;
//		
//		//��ȡ���еķ���
//		Method[] arr = clazz.getMethods();
//		
//		//�÷���ִ��
//		for (Method method : arr) {
//			//��ӡ���еķ���������
//			System.out.println(method.getName());
//		}
//	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//����������ʱ�򣬲������д���@mytest�� �ķ�����ִ��
		//��ȡ�ֽ������
		Class clazz=MyTestTest.class;
		
		//��ȡ���еķ���
		Method[] arr = clazz.getMethods();
		
		//�ô���ע��ķ���ִ��
		for (Method method : arr) {
			//��ȡ���е�ע��ķ���
			
			//�жϷ����Ƿ���ָ����ע��
			boolean flag =method.isAnnotationPresent(MyTest.class);
			if(flag){
				//System.out.println(method.getName());
				method.invoke(clazz.newInstance());
			}
		}
	}
}
