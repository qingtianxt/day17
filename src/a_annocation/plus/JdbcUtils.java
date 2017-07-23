package a_annocation.plus;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcUtils {

	@JdbcInfo(url="jdbc:mysql://localhost:3306/day16",password="121203")
	public static Connection getConnection() throws Exception{
		//1.��ȡ�ֽ����ļ�
		Class clazz = JdbcUtils.class;
		
		//2.��ȡgetConnection
		Method m = clazz.getMethod("getConnection");
		
		//3.�жϷ������Ƿ�jdbcinfo ע�� ���еĻ���ȡ
		if(m.isAnnotationPresent(JdbcInfo.class)){
			JdbcInfo info = m.getAnnotation(JdbcInfo.class);
			
			//4.��ȡע���ĸ�����
			String driverClass = info.driverClass();
			String url = info.url();
			String user = info.user();
			String password = info.password();
			
			//5.ע������
			Class.forName(driverClass);
			
			
			//6.��ȡ����
			return DriverManager.getConnection(url, user, password);
		}
		
		return null;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
}
