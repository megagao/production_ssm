package org.hqu.production_ms.test;

import java.util.List;

import org.hqu.production_ms.util.FileUtil;
import org.joda.time.DateTime;
import org.junit.Test;

public class test {
	@Test
	public void test(){
		String oldName = "aaa.jpg";
		String date = new DateTime().toString("yyyy/MM/dd");

		//生成新文件名
		//UUID.randomUUID();
		 String newName = oldName.substring(0,oldName.lastIndexOf("."))+"("+date+")"+oldName.substring(oldName.lastIndexOf("."));
	System.out.println(newName);
	}
	
	@Test
	public void test1(){
		FileUtil.deleteFile("F:\\upload\\temp\\file\\"+"新建文本文档(2016-10-05).txt");
	}
	

}
