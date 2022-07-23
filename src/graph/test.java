package graph;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		System.out.println(encrypt(s));
		System.out.println(decrypt(s));
	}
	
	private static String encrypt(String s) {
		StringBuffer sb = new StringBuffer();
		boolean increment = true;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(increment) {
				ch = (char) ((int)ch + 1);
			}else {
				ch = (char) ((int)ch - 1);
			}
			sb.append(ch);
			increment = !increment;
		}
		return sb.toString();
	}
	private static String decrypt(String s) {
		StringBuffer sb = new StringBuffer();
		boolean increment = false;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(increment) {
				ch = (char) ((int)ch + 1);
			}else {
				ch = (char) ((int)ch - 1);
			}
			sb.append(ch);
			increment = !increment;
		}
		return sb.toString();
	}

}
