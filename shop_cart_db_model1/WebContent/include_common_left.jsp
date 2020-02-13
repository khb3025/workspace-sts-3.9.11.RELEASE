<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	
	<%if(session.getAttribute("sUserId")==null){ %>
		<li><a href="user_write_form.jsp">회원가입</a></li>
		<li><a href="user_login_form.jsp">로그인</a></li>
		<li><a href="shop_product_list.jsp">쇼핑몰</a></li>
		<li><a></a></li>
	<%}else{ %>
		<li><a href="user_view.jsp"><%=session.getAttribute("sUserId")%>님</a>&nbsp;<a href="user_logout_action.jsp">로그아웃</a></li>
		<li><a href="shop_product_list.jsp">쇼핑몰</a></li>
		<li><a href="shop_view_cart.jsp">장바구니</a></li>
	<%} %>
		<li><a href="board_list.jsp">게시판리스트</a></li>
		<li><a href="board_write.jsp">게시판쓰기</a></li>
</ul>
