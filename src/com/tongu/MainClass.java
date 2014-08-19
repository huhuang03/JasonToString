package com.tongu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	public static void main(String[] args) {
		File file = new File("C:" + File.separator + "Users" + File.separator + 
				"Administrator/Desktop/json.txt");
//		System.out.println(file.getPath());
//		System.out.println(file.exists());
		StringBuffer sBuffer = new StringBuffer();
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = "";
			while ((line = bReader.readLine()) != null) {
//				System.out.println(line);
				if (line.startsWith("//")) {
					continue;
				}
				sBuffer.append(line);
			}
			bReader.close();
//			System.out.println(sBuffer.toString());
			String json = sBuffer.toString();
			String replaceAll = json.replaceAll("\r\n", "").replace("xxxxx", "\r\n").replace("\"", "\\\"").replace("    ", "");
			System.out.println(replaceAll);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
