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