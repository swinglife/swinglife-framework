<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../manager/head.jsp"%>

<body class="overflow-hidden">
	<div class="wrapper preload">
		<div class="sidebar-right">
			<div class="sidebar-inner scrollable-sidebar">
				<div class="sidebar-header clearfix">
					<input class="form-control dark-input" placeholder="Search"
						type="text">
					<div class="btn-group pull-right">
						<a href="#" class="sidebar-setting" data-toggle="dropdown"><i
							class="fa fa-cog fa-lg"></i></a>
						<ul class="dropdown-menu pull-right flipInV">
							<li><a href="#"><i class="fa fa-circle text-danger"></i><span
									class="m-left-xs">Busy</span></a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i><span
									class="m-left-xs">Turn Off Chat</span></a></li>
						</ul>
					</div>
				</div>
				<div class="title-block">Group Chat</div>
				<div class="content-block">
					<ul class="sidebar-list">
						<li><a href="#"> <i class="fa fa-circle-o text-success"></i><span
								class="m-left-xs">Close Friends</span>
						</a></li>
						<li><a href="#"> <i class="fa fa-circle-o text-success"></i><span
								class="m-left-xs">Business</span>
						</a></li>
					</ul>
				</div>
				<div class="title-block">Favorites</div>
				<div class="content-block">
					<ul class="sidebar-list">
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile2.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">Where are you?</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-success"></i>
								</div>
								<div class="chat-alert">
									<span class="badge badge-purple bounceIn animation-delay2">2</span>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile3.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">Jane Doe</div>
									<div class="chat-message">Hello</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-success"></i>
								</div>
								<div class="chat-alert">
									<span class="badge badge-info bounceIn animation-delay2">1</span>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile4.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">See you again next week.</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-danger"></i>
								</div>
								<div class="chat-alert">
									<i class="fa fa-check text-success"></i>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile5.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">Hello, Are you there?</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-danger"></i>
								</div>
								<div class="chat-alert">
									<i class="fa fa-reply"></i>
								</div>
						</a></li>
					</ul>
				</div>
				<div class="title-block">More friends</div>
				<div class="content-block">
					<ul class="sidebar-list">
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile6.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">Where are you?</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-success"></i>
								</div>
								<div class="chat-alert">
									<span class="badge badge-success bounceIn animation-delay2">2</span>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile7.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">Jane Doe</div>
									<div class="chat-message">Hello</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-success"></i>
								</div>
								<div class="chat-alert">
									<span class="badge badge-danger bounceIn animation-delay2">1</span>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile8.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">See you again next week.</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-danger"></i>
								</div>
								<div class="chat-alert">
									<i class="fa fa-check text-success"></i>
								</div>
						</a></li>
						<li><a href="#" class="clearfix"> <img
								src="images/profile/profile9.jpg" class="img-circle"
								alt="user avatar">
								<div class="chat-detail m-left-sm">
									<div class="chat-name">John Doe</div>
									<div class="chat-message">Hello, Are you there?</div>
								</div>
								<div class="chat-status">
									<i class="fa fa-circle-o text-danger"></i>
								</div>
								<div class="chat-alert">
									<i class="fa fa-reply"></i>
								</div>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- sidebar-inner -->
		</div>
		<!-- sidebar-right -->
		<%@ include file="../manager/menu.jsp"%>


		<div class="main-container">
			<div class="padding-md">
				<ul class="breadcrumb">
					<li><span class="primary-font"><i class="icon-home"></i></span><a
						href="index.html"> 系统管理</a></li>
					<li>管理员管理</li>
					<li>列表</li>
				</ul>

				<table class="table table-striped" id="dataTable">
					<thead>
						<tr>
							<th>编号</th>
							<th>用户名</th>
							<th>邮箱</th>
							<th>手机</th>
							<th>最后登录时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>#1001</td>
							<td>Leather Bag</td>
							<td>$89</td>
							<td>30</td>
							<td>187</td>
							<td><a href="#" class=""><span class="label label-danger">delete</span></a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- ./padding-md -->
		</div>
		<!-- /main-container -->

		<footer class="footer">
			<span class="footer-brand"> <strong class="text-danger">Simplify</strong>
				Admin
			</span>
			<p class="no-margin">
				&copy; 2014 <strong>Simplify Admin</strong>. ALL Rights Reserved.
			</p>
		</footer>
	</div>
	<!-- /wrapper -->

	<a href="#" class="scroll-to-top hidden-print"><i
		class="fa fa-chevron-up fa-lg"></i></a>

	<!-- Le javascript
	    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- Jquery -->
	<script src="/resources/js/jquery-1.11.1.min.js"></script>

	<!-- Bootstrap -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- Datatable -->
	<script src='/resources/js/jquery.dataTables.min.js'></script>
	<script src='/resources/js/uncompressed/dataTables.bootstrap.js'></script>

	<!-- Slimscroll -->
	<script src='/resources/js/jquery.slimscroll.min.js'></script>

	<!-- Popup Overlay -->
	<script src='/resources/js/jquery.popupoverlay.min.js'></script>

	<!-- Modernizr -->
	<script src='/resources/js/modernizr.min.js'></script>

	<!-- Simplify -->
	<script src="/resources/js/simplify/simplify.js"></script>

	<script>
		$(function() {
			$('#dataTable').dataTable();
		});
	</script>

</body>
</html>


