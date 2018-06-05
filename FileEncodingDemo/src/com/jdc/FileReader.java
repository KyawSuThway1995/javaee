package com.jdc;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader {

	private FileReader reader;
	private Charset charset;

	public FileReader() {
		for (Charset cs : getStandardCharSet()) {
			FileReader r = new FileReader(cs);
			this.addReader(r);
		}
	}

	private FileReader(Charset cs) {
		super();
		this.charset = cs;
	}

	private void addReader(FileReader reader) {
		if (null != this.reader) {
			this.reader.addReader(reader);
		} else {
			this.reader = reader;
		}
	}

	public List<String> read(File file) {
		
		try {
			if (null == charset) {
				
				return Files.readAllLines(file.toPath());
			}
			System.out.println(charset.name());
			return Files.readAllLines(file.toPath(), charset);
		} catch (Exception e) {
			if (null != this.reader) {
				return this.reader.read(file);
			}
		}

		return null;
	}

	private static List<Charset> getStandardCharSet() {
		List<Charset> list = new ArrayList<>();

		Field[] fields = StandardCharsets.class.getDeclaredFields();

		for (Field f : fields) {
			if (Modifier.isPublic(f.getModifiers()) && Modifier.isStatic(f.getModifiers())
					&& f.getType().equals(Charset.class)) {
				try {
					list.add((Charset) f.get(null));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		Collections.reverse(list);

		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(getStandardCharSet());
	}
}
