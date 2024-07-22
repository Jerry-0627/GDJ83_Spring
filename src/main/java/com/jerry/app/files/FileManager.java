package com.jerry.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	// HDD 파일 저장 메서드
	// FileSave
	public String fileSave(String path, MultipartFile files) throws Exception {
		// 1. 파일 생성
		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일 HDD에 저장
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + files.getOriginalFilename();
		file = new File(file, fileName);
		files.transferTo(file);

		return fileName;

	}
}
