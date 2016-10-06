package org.hqu.production_ms.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	
	Map uploadPicture(MultipartFile uploadFile);
	
	boolean deleteFile(String picName);
}
