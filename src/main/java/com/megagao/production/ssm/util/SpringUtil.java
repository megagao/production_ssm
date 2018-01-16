package com.megagao.production.ssm.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * created on 2016年9月6日 
 *
 * 加载spring容器
 *
 * @author  megagao
 * @version  0.0.1
 */
public class SpringUtil {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
	}
}
