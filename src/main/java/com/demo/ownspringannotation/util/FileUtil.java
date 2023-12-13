package com.demo.ownspringannotation.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static void write(String text, String path) throws IOException {
		File file = new File(path);

		if (!file.exists()) {

			/**
			 * If parent folder doesn't exist, it is created, but if creation fails, we
			 * throw an exception
			 */
			if (!file.getParentFile().exists()) {
				if (!file.getParentFile().mkdir()) {
					throw new RuntimeException("Folder cannot be created");
				}
			}

			/**
			 * If file doesn't exist, it is created, but if creation fails, we throw an
			 * exception
			 */
			if (!file.createNewFile()) {
				throw new RuntimeException("File cannot be created");
			}

		}

		FileWriter fw = new FileWriter(file, true);

		try (fw; BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(text);
			bw.newLine();
		}

	}
}
