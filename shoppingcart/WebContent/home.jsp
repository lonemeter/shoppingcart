<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER �ʪ���</title>
		
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
		  <h2>�w����{METER�ʪ��ӳ�</h2>
		</header>
		
		<section>
		  <nav>
		    <ul>
		      <li><a href="home.jsp">����</a></li>
		      <li><a href="food.jsp">�ɫ~</a></li>
		      <li><a href="armor.jsp">����</a></li>
		      <li><a href="arms.jsp">�Z��</a></li>
		      <li><a href="shoppingcart.jsp">�ʪ���</a></li>
		    </ul>
		  </nav>
		  
		  <article>
			
			<script>
		  		function button(a){
		  	            $.ajax({
		  	                type:"get",  //�ǭȤ覡���� post & get
		  	                url:"sessiontest?ses="+a,
		  	                async:false
		  	            })
		  	          alert("�[�J�ʪ���");
		  		}  		
			</script>
			<img src="image/food/����.jpg"><br>�����@<button type="button" onclick="button('milk')">�[�J�ʪ���</button><br>
		  	<img src="image/food/�J�|.jpg"><br>�J�|�@<button type="button" onclick="button('cake')">�[�J�ʪ���</button><br>
		  	
		  	<img src="image/armor/�޵P.jpg"><br>�޵P�@<button type="button" onclick="button('shied')">�[�J�ʪ���</button><br>
		  	<img src="image/armor/�Ǥl.jpg"><br>�Ǥl�@<button type="button" onclick="button('trousers')">�[�J�ʪ���</button><br>
		  	<img src="image/armor/�Z��.jpg"><br>�Z�ҡ@<button type="button" onclick="button('clothes')">�[�J�ʪ���</button><br>
		  	
		  	<img src="image/arms/���ƥ].jpg"><br>���ƥ]�@<button type="button" onclick="button('suitcase')">�[�J�ʪ���</button><br>
		  	<img src="image/arms/�C.jpg"><br>�C�@<button type="button" onclick="button('sword')">�[�J�ʪ���</button><br>
		  	<img src="image/arms/�βy��.jpg"><br>�βy�ҡ@<button type="button" onclick="button('mbaseballbat')">�[�J�ʪ���</button><br>
		  </article>
		</section>
	</body>
</html>