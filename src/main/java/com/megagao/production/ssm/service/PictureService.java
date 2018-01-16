package com.megagao.production.ssm.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	
	/**
	 * 
	 *
	 * @param  
	 * @return
	 */
	Map<String,Object> uploadPicture(MultipartFile uploadFile) throws Exception;
	
	boolean deleteFile(String picName) throws Exception;
}
