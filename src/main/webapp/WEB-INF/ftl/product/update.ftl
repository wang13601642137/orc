<div class="pageContent">
	<form method="post" action="product/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称：</label>
				<input type="text"  value="" name="name" class="textInput">
				<label>价格：</label>
                <input type="text"  value="" name="price" class="textInput">
                <label>分类：</label>
                <input type="text"  value="" name="category" class="textInput">
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
