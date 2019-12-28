<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单实用国产jQuery UI框架 - DWZ富客户端框架(J-UI.com)</title>

<link href="../../themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../../themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../../themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="../../uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="../../themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lt IE 9]><script src="../../js/speedup.js" type="text/javascript"></script><script src="../../js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!--><script src="../../js/jquery-2.1.4.min.js" type="text/javascript"></script><!--<![endif]-->

<script src="../../js/jquery.cookie.js" type="text/javascript"></script>
<script src="../../js/jquery.validate.js" type="text/javascript"></script>
<!--<script src="../../js/jquery.bgiframe.js" type="text/javascript"></script>-->
<script src="../../xheditor/xheditor-1.2.2.min.js" type="text/javascript"></script>
<script src="../../xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="../../uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<script type="text/javascript" src="../../chart/echarts.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6PYkS1eDz5pMnyfO0jvBNE0F"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>

<script src="../../js/dwz.core.js" type="text/javascript"></script>
<script src="../../js/dwz.util.date.js" type="text/javascript"></script>
<script src="../../js/dwz.validate.method.js" type="text/javascript"></script>
<script src="../../js/dwz.barDrag.js" type="text/javascript"></script>
<script src="../../js/dwz.drag.js" type="text/javascript"></script>
<script src="../../js/dwz.tree.js" type="text/javascript"></script>
<script src="../../js/dwz.accordion.js" type="text/javascript"></script>
<script src="../../js/dwz.ui.js" type="text/javascript"></script>
<script src="../../js/dwz.theme.js" type="text/javascript"></script>
<script src="../../js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="../../js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="../../js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="../../js/dwz.navTab.js" type="text/javascript"></script>
<script src="../../js/dwz.tab.js" type="text/javascript"></script>
<script src="../../js/dwz.resize.js" type="text/javascript"></script>
<script src="../../js/dwz.dialog.js" type="text/javascript"></script>
<script src="../../js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="../../js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="../../js/dwz.cssTable.js" type="text/javascript"></script>
<script src="../../js/dwz.stable.js" type="text/javascript"></script>
<script src="../../js/dwz.taskBar.js" type="text/javascript"></script>
<script src="../../js/dwz.ajax.js" type="text/javascript"></script>
<script src="../../js/dwz.pagination.js" type="text/javascript"></script>
<script src="../../js/dwz.database.js" type="text/javascript"></script>
<script src="../../js/dwz.datepicker.js" type="text/javascript"></script>
<script src="../../js/dwz.effects.js" type="text/javascript"></script>
<script src="../../js/dwz.panel.js" type="text/javascript"></script>
<script src="../../js/dwz.checkbox.js" type="text/javascript"></script>
<script src="../../js/dwz.history.js" type="text/javascript"></script>
<script src="../../js/dwz.combox.js" type="text/javascript"></script>
<script src="../../js/dwz.file.js" type="text/javascript"></script>
<script src="../../js/dwz.print.js" type="text/javascript"></script>

<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换时下面dwz.regional.zh.js还需要引入)
<script src="../bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="../../js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("../../dwz.frag.xml", {
		//loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>

</head>

<body>
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li><a href="changepwd.html" target="dialog" rel="changepwd" width="600">设置</a></li>
					<li><a href="login.html">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="tabsPage.html" target="navTab">商品管理</a>
							    <ul>
                                    <li><a href="product/category/list" target="navTab" rel="page1" fresh="false">分类</a></li>
                                </ul>
								<ul>
                                    <li><a href="product/list" target="navTab" rel="page1" fresh="false">商品</a></li>
								</ul>
							</li>
						</ul>
						<ul class="tree treeFolder">
                            <li><a href="tabsPage.html" target="navTab">订单管理</a>
                                <ul>
                                    <li><a href="product/list" target="navTab" rel="page1" fresh="false">订单列表</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="tree treeFolder">
                            <li><a href="tabsPage.html" target="navTab">购物车管理</a>
                                <ul>
                                    <li><a href="product/list" target="navTab" rel="page1" fresh="false">添加记录</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="tree treeFolder">
                            <li><a href="tabsPage.html" target="navTab">会员管理</a>
                                <ul>
                                    <li><a href="product/list" target="navTab" rel="page1" fresh="false">会员</a></li>
                                </ul>
                            </li>
                        </ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">


					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> 京ICP备15053290号-2</div>

</body>
</html>