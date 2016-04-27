<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>管理系统 - LEPU</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Font Awesome -->
<link href="/resources/css/font-awesome.min.css" rel="stylesheet">

<!-- ionicons -->
<link href="/resources/css/ionicons.min.css" rel="stylesheet">

<!-- Simplify -->
<link href="/resources/css/simplify.min.css" rel="stylesheet">

</head>

<body class="overflow-hidden light-background">
	<div class="wrapper no-navigation preload">
		<div class="sign-in-wrapper">
			<div class="sign-in-inner">
				<div class="login-brand text-center">
					  管理系统 <strong
						class="text-skin">LEPU</strong>
				</div>
				<form method="post" action="login" id="form1">
					<div style="color:red">${msg }</div>
					<div class="form-group m-bottom-md">
						<input type="text" class="form-control"
							placeholder="username" name="username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password" placeholder="password">
					</div>

					<div class="form-group">
						<div class="custom-checkbox">
							<input type="checkbox" id="chkRemember"> <label
								for="chkRemember"></label>
						</div>
						记住我
					</div>

					<div class="m-top-md p-top-sm">
						<a href="#" class="btn btn-success block" onclick="login()">登录</a>
					</div>

					<div class="m-top-md p-top-sm">
						<div class="font-12 text-center m-bottom-xs">
							<a href="#" class="font-12">忘记密码</a>
						</div>
						<div class="font-12 text-center m-bottom-xs">如果还没有账户?</div>
						<a href="signup.html" class="btn btn-default block">创建账户</a>
					</div>
				</form>
			</div>
			<!-- ./sign-in-inner -->
		</div>
		<!-- ./sign-in-wrapper -->
	</div>
	<!-- /wrapper -->

	<a href="" id="scroll-to-top" class="hidden-print"><i
		class="icon-chevron-up"></i></a>

	<!-- Le javascript
	    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- Jquery -->
	<script src="/resources/js/jquery-1.11.1.min.js"></script>

	<!-- Bootstrap -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- Slimscroll -->
	<script src='/resources/js/jquery.slimscroll.min.js'></script>

	<!-- Popup Overlay -->
	<script src='/resources/js/jquery.popupoverlay.min.js'></script>

	<!-- Modernizr -->
	<script src='/resources/js/modernizr.min.js'></script>

	<!-- Simplify -->
	<script src="/resources/js/simplify/simplify.js"></script>
	
	<script>
		function login(){
			$("#form1").submit();
		}
	</script>

</body>
</html>
