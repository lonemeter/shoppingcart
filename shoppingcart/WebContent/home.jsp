<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER 購物場</title>
		
		<style>
		* {
		  box-sizing: border-box;
		}
		
		body {
		  font-family: Arial, Helvetica, sans-serif;
		}
		
		/* Style the header */
		header {
		  background-color: ;
		  padding: 30px;
		  text-align: center;
		  font-size: 35px;
		  color: black;
		}
		
		/* Create two columns/boxes that floats next to each other */
		nav {
		  float: left;
		  width: 30%;
		  height: 300px; /* only for demonstration, should be removed */
		  background: ;
		  padding: 20px;
		  text-align: center;
		}
		
		/* Style the list inside the menu */
		nav ul {
		  list-style-type: none;
		  padding: 0;
		}
		
		article {
		  float: left;
		  padding: 20px;
		  width: 70%;
		  background-color: pink;
		  height: auto; /* only for demonstration, should be removed */
		}
		
		/* Clear floats after the columns */
		section:after {
		  content: "";
		  display: table;
		  clear: both;
		}
		
		/* Style the footer */
		footer {
		  background-color: #777;
		  padding: 10px;
		  text-align: center;
		  color: white;
		  
		}
		
		/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
		@media (max-width: 600px) {
		  nav, article {
		    width: 100%;
		    height: auto;
		  }
		}
		</style>
	</head>
	<body>

		<header>
		  <h2>歡迎光臨METER購物商場</h2>
		</header>
		
		<section>
		  <nav>
		    <ul>
		      <li><a href="home.jsp">首頁</a></li>
		      <li><a href="home.jsp?page=1">補品</a></li>
		      <li><a href="home.jsp?page=2">防具</a></li>
		      <li><a href="home.jsp?page=3">武器</a></li>
		      <li><a href="home.jsp?page=4">購物車</a></li>
		    </ul>
		  </nav>
		  
		  <article>
			
			<script>
		  		function button(a){
		  	            $.ajax({
		  	                type:"get",  //傳值方式有分 post & get
		  	                url:"sessiontest?ses="+a,
		  	                async:false
		  	            })
		  	          alert("加入購物車");
		  		}  		
			</script>
			
			
			<% if(request.getParameter("page")==null){	
			%>
					<jsp:include page='<%="/home"%>'>
						<jsp:param name="pa" value="home" />
					</jsp:include>
			<%
			}else if(request.getParameter("page").equals("1")){
			%>
					
					<jsp:include page='<%="/home"%>'>
						<jsp:param name="pa" value="1" />
					</jsp:include>
			<%
			}else if(request.getParameter("page").equals("2")){
			%>
					
					<jsp:include page='<%="/home"%>'>
						<jsp:param name="pa" value="2" />
					</jsp:include>
			<%
			}else if(request.getParameter("page").equals("3")){
			%>
					
					<jsp:include page='<%="/home"%>'>
						<jsp:param name="pa" value="3" />
					</jsp:include>
			<%
			}else if(request.getParameter("page").equals("4")){
				%>
				
				<jsp:include page='<%="/home"%>'>
					<jsp:param name="pa" value="4" />
				</jsp:include>
			<%
			}
			%>
			
			
			
		  </article>
		</section>
	</body>
</html>