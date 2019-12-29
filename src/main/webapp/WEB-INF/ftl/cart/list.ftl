<form id="pagerForm" method="post" action="cart/list">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="cart/list" method="post" onreset="$(this).find('select.combox').comboxReset()">
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
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">商品编号</th>
				<th width="120">商品名称</th>
				<th width="120">数量</th>
				<th width="120">用户ID</th>
				<th width="120">用户姓名</th>
				<th width="150">创建时间</th>
				<th width="150">更新时间</th>
			</tr>
		</thead>
		<tbody>
			<#list cartVOList as cart>
                <tr target="pid" rel="${cart.id}">
                    <td>${cart.productId}</td>
                    <td>${cart.productName}</td>
                    <td>${cart.quantity}</td>
                    <td>${cart.userId}</td>
                    <td>${cart.userName}</td>
                    <td>${cart.createdAt?string('yyyy-MM-dd hh:mm:ss')}</td>
                    <td>${cart.updatedAt?string('yyyy-MM-dd hh:mm:ss')}</td>
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
