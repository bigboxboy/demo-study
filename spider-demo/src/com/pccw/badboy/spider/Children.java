package com.pccw.badboy.spider;

public class Children extends Parent {

	String department;

	public String getDetails() {
		return " Name: " + name + " \n " + " Manager of " + department;
	}

	public void test() {
		// 调用父类的方法，怎么办？
		System.out.println(super.getDetails());
	}

	public static void main(String[] args) {

		Children child = new Children();
		System.out.println(child.getDetails());
//		String hello = child.sayHello();
//		System.out.println(hello);

//		String s1 = "hello";
//		String s2 = s1.toString();
//		String s4 = new StringBuffer(s1).toString();
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s4);

		String s1 = "ab" + "c";
		String s2 = "abc";
		System.out.println(s1 == s2);
	}

}
