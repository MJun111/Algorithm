package com.ssafy.day0817.problem;

import java.io.*;
import java.util.*;

public class BOJ_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split("-");
		int ans = 0;
		
		for (int i = 0; i < data.length; i++) 
			for (String v : data[i].split("[+]")) 
				ans += (i == 0) ? Integer.parseInt(v) : -Integer.parseInt(v);
		
		System.out.println(ans);
	}
}
