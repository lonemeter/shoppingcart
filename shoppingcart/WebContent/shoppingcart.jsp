<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
		  <h2>你的購物車</h2>
		</header>
		
		<section>
		  <nav>
		    <ul>
		      <li><a href="home.jsp">首頁</a></li>
		      <li><a href="food.jsp">補品</a></li>
		      <li><a href="armor.jsp">防具</a></li>
		      <li><a href="arms.jsp">武器</a></li>
		      <li><a href="shoppingcart.jsp">購物車</a></li>
		    </ul>
		  </nav>
		  
		  <article>
		  
		  <script>
		  		function button(a){
		  	            $.ajax({
		  	                type:"get",  //傳值方式有分 post & get
		  	                url:"sessiontest?sell=t&ses="+a,
		  	                async:false
		  	            })
		  	          alert("移除購物車");
		  		}  		
		  </script>
		  <%if(request.getSession().getAttribute("milk")!=null){ %>
			  <img src='image/food/牛奶.jpg'><br>牛奶  　<a href='sessiontest?ses=milk&sell=t'>移除購物車</a><br> 
		  <% } %>
		  	  
		  <% if(request.getSession().getAttribute("cake")!=null){%>
			  <img src='image/food/蛋糕.jpg'><br>蛋糕 　<a href='sessiontest?ses=cake&sell=t'>移除購物車</a><br> 
		  <%}%>
		  
		  <% if(request.getSession().getAttribute("shied")!=null){%>
			  <img src='image/armor/盾牌.jpg'><br>盾牌 　<a href='sessiontest?ses=shied&sell=t'>移除購物車</a><br>
		  <%}%>
		  
		  <%if(request.getSession().getAttribute("trousers")!=null){%>
			  <img src='image/armor/褲子.jpg'><br>褲子 　<a href='sessiontest?ses=trousers&sell=t'>移除購物車</a><br> 
		  <%}%>
		  
		  <% if(request.getSession().getAttribute("clothes")!=null){%>
			  <img src='image/armor/鎧甲.jpg'><br>鎧甲 　<a href='sessiontest?ses=clothes&sell=t'>移除購物車</a><br>
		  <%}%>
		  
		  <%if(request.getSession().getAttribute("suitcase")!=null){%>
			  <img src='image/arms/公事包.jpg'><br>公事包 　<a href='sessiontest?ses=suitcase&sell=t'>移除購物車</a><br>
		  <%}%>
		  
		  <%if(request.getSession().getAttribute("sword")!=null){%>
			  <img src='image/arms/劍.jpg'><br>劍 　<a href='sessiontest?ses=sword&sell=t'>移除購物車</a><br>
		  <%}%>
		  
		  <%if(request.getSession().getAttribute("mbaseballbat")!=null){%>
			  <img src='image/arms/棒球棍.jpg'><br>棒球棍 　<a href='sessiontest?ses=baseballbat&sell=t'>移除購物車</a><br> 
		  <%}%>
		  <br>
		  <button type="button" onclick="alert('結帳成功');location.href='shoppingcart'">結帳去</button>
		  </article>
		</section>
	</body>
</html>