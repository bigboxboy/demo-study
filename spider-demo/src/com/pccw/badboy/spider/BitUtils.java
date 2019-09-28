package com.pccw.badboy.spider;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class BitUtils {

	public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {

		int aa = -032;
		int bb = -0xF2;
//		System.out.println(aa);
//		System.out.println(bb);
		// 1 00101
		int cc = -5;
		
//		System.out.println(cc >> 1);
		
		int a = 5;
		int b = 6;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
//		0000 0000 0000 0000 0000 0000 0000 0010
//		1111 1111 1111 1111 1111 1111 1111 1101
		int c = -24;
		System.out.println(c >> 2);
		
		
		String encode = encode("cwf", 0xf);
		System.out.println(encode);
		String encode2 = encode(encode, 0xf);
		System.out.println(encode2);
		
		System.out.println(mulTwo(9));
		
		System.out.println(mulTwoPower(2,3));

	}

	public static String encode(String source, int key) throws UnsupportedEncodingException {
		byte[] b = source.getBytes("UTF-8");
		for (int i = 0, size = b.length; i < size; i++) {
			for (byte keyBytes0 : b) {
				b[i] = (byte) (b[i] ^ key);
			}
		}
		return new String(b);
	}
	
	// X 2      10010
	public static int mulTwo(int n) {
	    return n << 1;
	}
	
	public static int mulTwoPower(int n,int m) {
	    return n << m;
	}
}
