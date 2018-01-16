package com.megagao.production.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.megagao.production.ssm.domain.customize.ActiveUser;
import com.megagao.production.ssm.util.CollectionsFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.megagao.production.ssm.common.Constants.NO_PERMISSION;

/**
 * created on 2017年3月25日 
 *
 * 权限判断controller
 *
 * @author  megagao
 * @version  0.0.1
 */
@RestController
public class AuthorityJudgeController {

	private static final Logger logger = LoggerFactory.getLogger(AuthorityJudgeController.class);

	@RequestMapping("*/*_judge")
	public Map<String,Object> authorityJudge(HttpServletRequest request) throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		
		//根据uri,使用shiro判断相应权限
		String uri = request.getRequestURI();
		String[] names = uri.split("/");
		String featureName = names[2];
		String operateName = names[3].split("_")[0];
		Map<String,Object> map = CollectionsFactory.newHashMap();
		if(!activeUser.getUserStatus().equals("1")){
			if (logger.isDebugEnabled()) {
				logger.debug(NO_PERMISSION, "账户已被锁定！");
			}
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			if (logger.isDebugEnabled()) {
				logger.debug(NO_PERMISSION, "角色已被锁定!");
			}
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if (logger.isDebugEnabled()) {
				logger.debug(NO_PERMISSION, "没有权限!");
			}
			if(!subject.isPermitted(featureName+":"+operateName)){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
}
