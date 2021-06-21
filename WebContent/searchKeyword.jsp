<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
   <%@ page import ="java.util.List"%>
   <%@ page import =" main.model.site.SiteVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>

<%
List<SiteVO> list = (List<SiteVO>)request.getAttribute("list");



 %>



<body>

   			<form action="keyword" method="GET">
            	<input name="tag" type="text" />
            	<input type="submit" value="찾기"/>
            </form>
               <%if(list!=null){%>
            		<ul>
 
           			 <%for(SiteVO site :list){%>
            	  	<li>이름 : <%=site.getOriginUri()%> 설명 : <%=site.getText() %> 코드 : <%=site.getShortCode() %></li>
            		 <%}%>
            		</ul>
            		 <%}else{%>
            	<h2>일치하는 정보가 없습니다</h2>
            	 <%}%>
            
            
</body>
</html>