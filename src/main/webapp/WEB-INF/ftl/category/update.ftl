<div class="pageContent">
	<form method="post" action="product/category/modify" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>商品分类名称：</label>
				<input type="text"  value="${category.name}" name="name"  class="textInput">

				<input type="hidden"  value="${category.id}" name="cid"  class="textInput">

			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
