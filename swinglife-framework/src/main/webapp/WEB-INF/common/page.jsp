<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pagination">

	<a href="#">总页数:${sumPage }</a>
	<a href="#">当前页:${thisPage }</a>
	
<!-- 
	<c:forEach items="${listPage }" var="listPage">
		<a href="${listPage.url }" class="number" title="1">${listPage.index
			}</a>
	</c:forEach> -->
	<a href="${url }${next }" title="Next Page">下一页 &raquo;</a><a
		href="${url }${up }" title="Last Page">上一页 &raquo;</a>
</div>
