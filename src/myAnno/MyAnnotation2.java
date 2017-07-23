package myAnno;

import myenum.Color;

public @interface MyAnnotation2 {
	//◊¢Ω‚ Ù–‘
	int i();
	String s();
	
	//Date d();
	String []ss();
	Class cl();
	MyAnnotation1 m1();
	
	Color RED();
}
