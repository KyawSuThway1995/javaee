package com.jdc;

import java.io.File;
import java.util.List;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("Ho-2.TXT");

		List<String> lines = new FileReader().read(file);
		
		lines.forEach(System.out::println);
	}

}
