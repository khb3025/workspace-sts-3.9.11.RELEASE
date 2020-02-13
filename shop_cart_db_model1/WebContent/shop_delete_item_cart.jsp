<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//장바구니에서 원하는 품목을 삭제시킨 후 view_cart.jsp 로 sendRedirect 시킨다..
	
	String cart_item_no = request.getParameter("cart_item_no");
	if (cart_item_no == null || cart_item_no.equals("")) {
		response.sendRedirect("shop_product_list.jsp");
		return;
	}
	CartService cartService=new CartService();
	cartService.deleteCartItem(Integer.parseInt(cart_item_no));
	response.sendRedirect("shop_view_cart.jsp");
%>
