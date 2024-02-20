package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1076 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long value = mapColorToValue(br.readLine()) * 10 + mapColorToValue(br.readLine());
		System.out.println(value * (long) Math.pow(10, mapColorToValue(br.readLine())));
	}
	
	private static int mapColorToValue(String color) {
		if (color.equals("black")) {
			return 0;
		} else if (color.equals("brown")) {
			return 1;
		} else if (color.equals("red")) {
			return 2;
		} else if (color.equals("orange")) {
			return 3;
		} else if (color.equals("yellow")) {
			return 4;
		} else if (color.equals("green")) {
			return 5;
		} else if (color.equals("blue")) {
			return 6;
		} else if (color.equals("violet")) {
			return 7;
		} else if (color.equals("grey")) {
			return 8;
		}
		return 9;
	}

}
