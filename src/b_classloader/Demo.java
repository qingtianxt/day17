package b_classloader;
public class Demo {
	public static void main(String[] args) {
		
		ClassLoader ap = Demo.class.getClassLoader();
//		System.out.println(ap);
		
//		ClassLoader ex = DNSNameService.class.getClassLoader();
//		System.out.println(ex);
		
		ClassLoader co = String.class.getClassLoader();
		System.out.println(co);
	}
}
