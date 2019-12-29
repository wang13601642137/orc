<form id="pagerForm" method="post" action="product/list">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="product/list" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					商品名称：<input type="text" name="keyword" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="product/toAdd" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="product/delete?uid={pid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="product/toUpdate?uid={pid}" target="dialog"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">商品名称</th>
				<th width="50">价格</th>
				<th>图片</th>
				<th width="50">库存</th>
				<th width="80">是否上架</th>
				<th width="80" align="center">是否有效</th>
				<th width="150">创建时间</th>
				<th width="150">更新时间</th>
			</tr>
		</thead>
		<tbody>
			<#list productList as product>
                <tr target="sid_user" rel="${product.id}">
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td class="imgs"><img style="width:100px;height:100px" src="http://localhost/upload/${product.imageUrl}"/></td>
                    <td>${product.quantity}</td>
                    <td>${product.status?string ("是","否")}</td>
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

<style type="text/css" media="screen">
    .imgs{text-align:center;}
    .imgs div{height:100px!important;}
</style>
