<div class="pageContent">
	<form method="post" action="product/modify" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<input type="hidden" value="${product.id}" name="id" class="textInput">
				<label>名称：</label>
				<input type="text" value="${product.name}" name="name" class="textInput">
				<label>价格：</label>
                <input type="text" value="${product.price}" name="price" class="textInput">
                <label>库存：</label>
                <input type="text" value="${product.quantity}" name="quantity" class="textInput">
                <label>分类：</label>
                <input type="text" value="${product.categoryId}" name="cid" class="textInput">
                <label>商品图片：</label>
                <input type="text" value="${product.imageUrl}" name="imageUrl" class="textInput">
                <input id="file" name="file" type="file" /> <button id="button" type="button">上传</button>
                <label>描述：</label>
                <input type="text"  value="${product.description}" name="description" class="textInput">
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

<script type="text/javascript">
    $(document).ready(function(){
        $("#button").click(function(){
            uploadFile();
        });
    });

    function uploadFile(){
        var type = "file";
    	var formData = new FormData();
    	formData.append(type,$("#file")[0].files[0]);
    	$.ajax({
    		type : "post",
    		url : "upload/upload",
    		data : formData,
    		processData : false,
    		contentType : false,
    		success : function(data){
    			if (data=="error") {
    				alert("文件提交失败!");
    			}else{
    			$("input[name='imageUrl']").val(data);
    			alert("文件上传成功!");
    		}}
    	});
    }

</script>
