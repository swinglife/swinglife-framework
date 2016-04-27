<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript">
function dialog_show(){
	 $( "#dialog-message" ).dialog({
	      modal: true,
	      buttons: {
	       
	      }
	    });
}
</script>
	
<div id="dialog-message" style="display:none" title="系统提示">
	<p>
		<span class="ui-icon ui-icon-circle-check"
			style="float: left; margin: 0 7px 50px 0;"></span>
	<p>正在提交设置..请稍等..
</div>