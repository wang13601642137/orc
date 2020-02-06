<form id="pagerForm" method="post" action="product/category/list">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="product/category/list" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">

	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="product/category/toAdd" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="product/category/delete?cid={cid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="product/category/toUpdate?cid={cid}" target="dialog"><span>修改</span></a></li>
			<li class="line">line</li>

		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">会员编号</th>
				<th width="100">用户名</th>
				<th width="100">密码</th>
				<th width="80" align="center">是否有效</th>
				<th width="150">创建时间</th>
				<th width="150">更新时间</th>
			</tr>
		</thead>
		<tbody>

		<#list memberList as member>
            <tr target="mid" rel=${member.id}>
				<td>${member.id}</td>
				<td>${member.userName}</td>
				<td>${member.password}</td>
                <td>${product.status?string ("是","否")}</td>
                <td>${product.createdAt?string('yyyy-MM-dd hh:mm:ss')}</td>
                <td>${product.updatedAt?string('yyyy-MM-dd hh:mm:ss')}</td>
			</tr>
	    </#list>

		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>