<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../manager/head.jsp"%>

<body class="overflow-hidden">
	<div class="wrapper preload">
		<%@ include file="../manager/sidebar-right.jsp"%>
		<%@ include file="../manager/menu.jsp"%>
		<div class="main-container">
			<div class="padding-md">
				<ul class="breadcrumb">
					<li><span class="primary-font"><i class="icon-home"></i></span><a
						href="index.html"> 系统管理</a></li>
					<li>角色管理</li>
					<li>列表</li>
				</ul>

				<table class="table table-striped" id="dataTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>角色名称</th>
							<th>角色说明</th>
							<th>创建时间</th>
							<th width="20%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="list">
							<tr>
								<td>${list.id }</td>
								<td>${list.name }</td>
								<td>${list.description }</td>
								<td>30</td>
								<td><a href="#" data-toggle="modal"
									data-target="#normalModal"><span
										class="label label-primary"
										onclick="showPermissionTreeModel('${list.id}','${list.name }')">授权</span></a>
									<a href="#" class="" data-target="#menuModel"
									data-toggle="modal"
									onclick="showMenuTreeModel('${list.id}','${list.name }')"><span
										class="label label-info">配置菜单</span></a> <a href="#" class=""><span
										class="label label-danger">删除</span></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="normalModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">授予权限</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="id" value="" id="roleId">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary">保存更改</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Menu Model -->
		<div class="modal fade" id="menuModel">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="menu-role-title">配置菜单</h4>
					</div>
					<div class="modal-body">
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
						<input type="hidden" id="menu_model_roleId" value="" >
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="saveMenu()">保存更改</button>
					</div>
				</div>
			</div>
		</div>


		<%@ include file="../manager/footer.jsp"%>

		<link rel="stylesheet"
			href="/resources/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
		 
		<script type="text/javascript"
			src="/resources/zTree/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript"
			src="/resources/zTree/js/jquery.ztree.excheck-3.5.js"></script>


		<script>
			var setting = {
				view : {
					selectedMulti : false
				},
				check : {
					enable : true
				},
				data : {
					simpleData : {
						enable : true
					}
				},
				callback : {
					onCheck : onCheck
				}
			};

			var clearFlag = false;
			function onCheck(e, treeId, treeNode) {
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = treeObj.getCheckedNodes(true);
				if (clearFlag) {
					clearCheckedOldNodes();
				}
			}

			function clearCheckedOldNodes() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
						.getChangeCheckedNodes();
				for (var i = 0, l = nodes.length; i < l; i++) {
					nodes[i].checkedOld = nodes[i].checked;
				}
			}
			function count() {

			}
			function createTree(znode) {
				$.fn.zTree.init($("#treeDemo"), setting, znode);
				count();
				clearFlag = $("#last").attr("checked");
			}

			function showMenuTreeModel(id, name) {
				$("#menu-role-title").html("配置[" + name + "]菜单")
				$("#menu_model_roleId").val(id);
				$.ajax({
					type : "get",
					url : "getMenuList?roleId="+id,
					success : function(data) {
						createTree(data.list)

					}

				})
			}
			
			function saveMenu(){
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = treeObj.getCheckedNodes(true);
				var menuParams = "";
				var permParams = "";
				var roleId = $("#menu_model_roleId").val();
				nodes.forEach(function(data){
					if(data.tag=="menu"){
						menuParams = menuParams + "&menuId="+data.id
					}
					if(data.tag=="perm"){
						permParams = permParams + "&permId="+data.id
					}
				})

				$.ajax({
					type:'post',
					data:"roleId="+roleId+"&"+menuParams+permParams,
					url:"saveMenu",
					success:function(data){
						window.location="/system/role/list"
					}
				})
				
			}

			function showPermissionTreeModel(id, name) {
				$(".modal-title").html("授予[" + name + "]权限")
				$("#roleId").val(id)
			}

			$(function() {
				$('#dataTable').dataTable();
			});
		</script>
</body>
</html>


