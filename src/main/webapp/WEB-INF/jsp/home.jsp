<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生产管理系统首页</title>
<style type="text/css">
.content {
	padding: 10px 10px 10px 10px;
}
</style>
</head>
<body class="easyui-layout">
	<!-- <div data-options="region:'west',title:'功能菜单',split:true"
		style="width:213px;"> -->
	<div class="easyui-accordion" style="width:213px;"
		data-options="region:'west',title:'功能菜单',split:false">
		<div title="功能搜索"
			data-options="iconCls:'icon-search',collapsed:false,collapsible:false"
			style="padding:10px;">
			<input class="easyui-searchbox" prompt="请输入想要搜索的功能"
				style="width:178px;height:25px;">
			<!---------------------------------------------------->
			<!-- http://www.jeasyui.net/demo/408.html#  ExpandTo-->
			<!---------------------------------------------------->
		</div>

		<div title="计划进度" style="padding:10px;">

			<ul id="scheduleMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
				<li><span>计划进度</span>
					<ul>
						<li><span>订单管理</span>
							<ul>
								<li data-options="attributes:{'url':'order/add'}">新增订单</li>
								<li data-options="attributes:{'url':'order/find'}">订单查询</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li>
							<span>客户管理</span>
							<ul>
								<li data-options="attributes:{'url':'custom/add'}">新增客户</li>
								<li data-options="attributes:{'url':'custom/find'}">客户查询</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li><span>产品管理</span>
							<ul>
								<li data-options="attributes:{'url':'product/add'}">新增产品</li>
								<li data-options="attributes:{'url':'product/find'}">产品查询</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>

		</div>

		<div title="设备管理" data-options="selected:true" style="padding:10px">

			<ul id="deviceMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
				<li><span> 设备管理 </span>
					<ul>
						<li data-options="attributes:{'url':'device/deviceList'}">设备列表</li>
						<li data-options="attributes:{'url':'device/deviceType'}">设备种类</li>
						<li data-options="attributes:{'url':'device/deviceCheck'}">设备例检</li>
						<li data-options="attributes:{'url':'device/deviceFault'}">设备故障</li>
						<li data-options="attributes:{'url':'device/deviceMaintain'}">设备维修</li>
					</ul></li>
				<li><span> 测试</span>
					<ul>
						<li data-options="attributes:{'url':'device/add'}">新增设备</li>
						<li data-options="attributes:{'url':'device/test'}">测试</li>
					</ul></li>
			</ul>

		</div>

		<div title="工艺监控" style="padding:10px">
			<p>~。~</p>
		</div>
	</div>

	<!-- </div> -->
	<div data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs">
			<div title="首页" style="padding:20px;"></div>

		</div>

	</div>
	<script type="text/javascript">
		$(function() {
			/* Schedule Manager Tree onClick Event */
			$('#scheduleMonitor').tree({
				onClick : function(node) {
					if ($('#scheduleMonitor').tree("isLeaf", node.target)) {
						var tabs1 = $("#tabs");
						var tab1 = tabs1.tabs("getTab", node.text);
						if (tab1) {
							tabs1.tabs("select", node.text);
						} else {
							tabs1.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});

			/* Device Manager Tree onClick Event */
			$('#deviceMonitor').tree({
				onClick : function(node) {
					if ($('#deviceMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
		});
	</script>

</body>
</html>