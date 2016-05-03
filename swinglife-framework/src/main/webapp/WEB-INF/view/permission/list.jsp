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
				<div class="smart-widget">
						<div class="smart-widget-header">
							添加动作
							<span class="smart-widget-option">
								<span class="refresh-icon-animated">
									<i class="fa fa-circle-o-notch fa-spin"></i>
								</span>
	                            <a href="#" class="widget-toggle-hidden-option">
	                                <i class="fa fa-cog"></i>
	                            </a>
	                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
	                                <i class="fa fa-chevron-up"></i>
	                            </a>
	                            <a href="#" class="widget-refresh-option">
	                                <i class="fa fa-refresh"></i>
	                            </a>
	                            <a href="#" class="widget-remove-option">
	                                <i class="fa fa-times"></i>
	                            </a>
	                        </span>
						</div>
						<div class="smart-widget-inner">
							<div class="smart-widget-hidden-section">
								<ul class="widget-color-list clearfix">
									<li style="background-color:#20232b;" data-color="widget-dark"></li>
									<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
									<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
									<li style="background-color:#2baab1;" data-color="widget-green"></li>
									<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
									<li style="background-color:#fbc852;" data-color="widget-orange"></li>
									<li style="background-color:#e36159;" data-color="widget-red"></li>
									<li style="background-color:#7266ba;" data-color="widget-purple"></li>
									<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
									<li style="background-color:#fff;" data-color="reset"></li>
								</ul>
							</div>
							<div class="smart-widget-body">
								<form class="form-inline no-margin">
									<div class="form-group">
									    <label class="sr-only">动作名称</label>
									    <input type="text" class="form-control" placeholder="动作名称">
									</div><!-- /form-group -->
									<div class="form-group">
									    <label class="sr-only">动作URL</label>
									    <input type="text" class="form-control" placeholder="动作URL">
									</div><!-- /form-group -->
										<div class="form-group">
										<label class="col-lg-2 control-label" style="width:80px;margin-top:10px">所属:</label>
											<select class="form-control" style="margin-left:0px">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
									</div>									</div><!-- /form-group -->
								 	 
									<button type="submit" class="btn btn-sm btn-success">保存</button>
								</form>
							</div>
						</div><!-- ./smart-widget-inner -->
					</div><!-- ./smart-widget -->
				<div class="smart-widget widget-green">
					<div class="smart-widget-header">
						权限列表 <span class="smart-widget-option"> <span
							class="refresh-icon-animated"> <i
								class="fa fa-circle-o-notch fa-spin"></i>
						</span> <a href="#" class="widget-toggle-hidden-option"> <i
								class="fa fa-cog"></i>
						</a> <a href="#" class="widget-collapse-option" data-toggle="collapse">
								<i class="fa fa-chevron-up"></i>
						</a> <a href="#" class="widget-refresh-option"> <i
								class="fa fa-refresh"></i>
						</a> <a href="#" class="widget-remove-option"> <i
								class="fa fa-times"></i>
						</a>
						</span>
					</div>
					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>描述</th>
								<th>动作</th>
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
									<td>${list.url }</td>
									<td>${list.createTime }</td>
									<td><a href="#" class="" data-target="#menuModel"
										data-toggle="modal" onclick="toEdit('${list.id}')"><span
											class="label label-info">编辑</span></a> <a href="#" class=""><span
											class="label label-danger">删除</span></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>


			</div>
		</div>


		<!-- subMenu Model -->
		<div class="modal fade" id="subMenuModel">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="smart-widget widget-purple" style="border: 0px">
						<div class="smart-widget-header">
							子菜单列表 <span class="smart-widget-option"> </span>
						</div>
						<div class="smart-widget-inner">
							<div class="smart-widget-body">
								<form class="form-horizontal">
									<table class="table table-striped" id="dataTable">
										<thead>
											<tr>
												<th>编号</th>
												<th>名称</th>
												<th>描述</th>
												<th>URL</th>
												<th width="20%">操作</th>
											</tr>
										</thead>
										<tbody id="subMenuBody">

										</tbody>
									</table>

									<!-- /form-group -->
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Menu Model -->
		<div class="modal fade" id="menuModel">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="smart-widget widget-purple" style="border: 0px">
						<div class="smart-widget-header" id="addOrEditTitle">
							添加菜单 <span class="smart-widget-option"> </span>
						</div>
						<div class="smart-widget-inner">
							<div class="smart-widget-body">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="inputEmail1" class="col-lg-2 control-label">菜单名称</label>
										<div class="col-lg-10">
											<input type="email" class="form-control" id="name"
												name="name" placeholder="菜单名称">
										</div>
										<!-- /.col -->
									</div>
									<!-- /form-group -->
									<div class="form-group">
										<label for="inputPassword1" class="col-lg-2 control-label">菜单描述</label>
										<div class="col-lg-10">
											<input type="text" name="description" class="form-control"
												id="content" placeholder="菜单描述">
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword1" class="col-lg-2 control-label">URL</label>
										<div class="col-lg-10">
											<input type="text" name="url" class="form-control" id="url"
												placeholder="URL">
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword1" class="col-lg-2 control-label">图标样式</label>
										<div class="col-lg-10">
											<input type="text" name="icon" class="form-control" id="icon"
												placeholder="图标样式">
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword1" class="col-lg-2 control-label">所属菜单</label>
										<div class="col-lg-10" id="parent_menu">
											<select style="margin-top: 6px" id="parentId">
												<option value="0">一级菜单</option>
												<c:forEach items="${list }" var="list">
													<option id="select_${list.id }" value="${list.id }">${list.name }</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<!-- /form-group -->
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary" id="saveButton"
											onclick="add()">保存</button>
									</div>
								</form>
							</div>
						</div>
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
			function excAjax(params, url, fn) {
				$.ajax({
					type : 'get',
					url : url,
					data : params,
					success : fn
				})
			}

			function postAjax(params, url, fn) {
				$.ajax({
					type : 'post',
					url : url,
					data : params,
					success : fn
				})
			}

			function delData(params, url, fn) {
				excAjax(params, url, fn);
			}

			function editMenu(id) {
				var name = $("#name").val();
				var content = $("#content").val()
				var url = $("#url").val();
				var parentId = $("#parentId").val();
				var icon = $("#icon").val();

				var params = "name=" + name + "&menuId=" + id + "&description="
						+ content + "&url=" + url + "&parentId=" + parentId
						+ "&icon=" + icon;
				postAjax(params, 'editMenu', function(msg) {
					if (msg.code == 1) {
						window.location = "/system/menu/list"
					}
				})

			}

			function toEditSubMenu(id) {
				$("#addOrEditTitle").html("编辑菜单")
				excAjax("menuId=" + id, "getMenu", function(msg) {
					$("#name").val(msg.menu.name);
					$("#content").val(msg.menu.description)
					$("#url").val(msg.menu.url);
					$("#icon").val(msg.menu.icon)
					$("#select_" + msg.menu.parentId).attr("selected",
							"selected")

					$("#saveButton").attr("onclick", "editMenu('" + id + "')");
				})
			}

			function toEdit(id) {
				$("#addOrEditTitle").html("编辑菜单")
				excAjax("menuId=" + id, "getMenu", function(msg) {
					$("#name").val(msg.menu.name);
					$("#content").val(msg.menu.description)
					$("#url").val(msg.menu.url);
					$("#icon").val(msg.menu.icon)
					$("#saveButton").attr("onclick", "editMenu('" + id + "')");
				})
			}

			function delSubMenu(id) {
				if (confirm("确定删除？")) {
					delData("id=" + id, "delSubMenu", function(msg) {
						if (msg.code == 1) {
							$("#subMenu" + id).hide(300);
						}
					})
				}
			}

			function getSubMenuList(menuId) {
				$("#subMenuBody").html("");
				excAjax(
						"menuId=" + menuId,
						"getSubMenuList",
						function(msg) {
							msg.list
									.forEach(function(data) {
										var tr = "<tr id='subMenu"+data.id+"' ><td>"
												+ data.id
												+ "</td><td>"
												+ data.name
												+ "</td><td>"
												+ data.description
												+ "</td><td>"
												+ data.url
												+ "</td><td><a href=#' class='' onclick='delSubMenu("
												+ data.id
												+ ")'><span class='label label-danger'>删除</span></a>"
												+ " <a href='#' class='' data-target='#menuModel' data-toggle='modal' onclick='toEditSubMenu("
												+ data.id
												+ ")' ><span class='label label-info'>编辑</span></a></td></tr>";
										var html = $("#subMenuBody").html();
										$("#subMenuBody").html(html + tr);
									})
						})
			}

			function chargeButtonToSave() {
				$("#addOrEditTitle").html("添加菜单")
				$("#saveButton").attr("onclick", "add()");
			}

			function add() {
				var name = $("#name").val();
				var content = $("#content").val()
				var url = $("#url").val();
				var parentId = $("#parentId").val();
				var icon = $("#icon").val();
				$.ajax({
					type : 'post',
					url : 'add',
					data : 'name=' + name + "&description=" + content + "&url="
							+ url + "&parentId=" + parentId + "&icon=" + icon,
					success : function(msg) {
						if (msg.code == 1) {
							window.location = "/system/menu/list";
						} else {
							alert(msg.errMsg);
						}
					}
				})
			}

			$(function() {
				$('#dataTable').dataTable();
			});
		</script>
</body>
</html>


