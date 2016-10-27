package org.hqu.production_ms.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	Map<String,Object> uploadFile(MultipartFile uploadFile);
	
	boolean deleteFile(String fileName);
}
