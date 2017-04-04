package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import org.hqu.production_ms.service.PictureService;
import org.hqu.production_ms.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * created on 2016年9月27日 
 *
 * 上传图片处理
 *
 * @author  megagao
 * @version  0.0.1
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) throws Exception{
		Map<String,Object> result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
	
	@RequestMapping("/pic/delete")
	@ResponseBody
	public String pictureDelete(@RequestParam String picName) throws Exception{
		pictureService.deleteFile(picName);
		Map<String,Object> result = new HashMap<String,Object>();	
		result.put("data", "success");
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
