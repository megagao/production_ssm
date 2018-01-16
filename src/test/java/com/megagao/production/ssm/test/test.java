package com.megagao.production.ssm.test;

import com.megagao.production.ssm.domain.Custom;
import com.megagao.production.ssm.service.CustomService;
import com.megagao.production.ssm.util.FileUtil;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
	
	@Test
	public void testFile(){
		String oldName = "aaa.jpg";
		String date = new DateTime().toString("yyyy/MM/dd");

		//生成新文件名
		//UUID.randomUUID();
		 String newName = oldName.substring(0,oldName.lastIndexOf("."))+"("+date+")"+oldName.substring(oldName.lastIndexOf("."));
	System.out.println(newName);
	}
	
	@Test
	public void testFile1(){
		FileUtil.deleteFile("F:\\upload\\temp\\file\\"+"新建文本文档(2016-10-05).txt");
	}
	
	@Test
	public void test1() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		CustomService customService = (CustomService)context.getBean("customServiceImpl");
		Custom custom = new Custom();
		custom.setCustomId("1253");
		custom.setCustomName("aaa");
		customService.insert(custom);
	}
}
