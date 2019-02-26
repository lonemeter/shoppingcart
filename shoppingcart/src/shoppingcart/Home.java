package shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String i = request.getParameter("pa");
		if(i.equals("home")){
			for(Goods good: Items.arms){
				out.printf("<img src='image/arms/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
			for(Goods good: Items.food){
				out.printf("<img src='image/food/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
			for(Goods good: Items.armor){
				out.printf("<img src='image/armor/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
		}
		
		
		if(i.equals("1")){
			for(Goods good: Items.food){
				out.printf("<img src='image/food/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
		}
		
		
		if(i.equals("2")){
			for(Goods good: Items.armor){
				out.printf("<img src='image/armor/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
		}
		
		
		if(i.equals("3")){
			for(Goods good: Items.arms){
				out.printf("<img src='image/arms/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='button(\"%s\")'>�[�J�ʪ���</button><br>", good.name, good.name, good.price, good.engname);
			}
		}
		
		
		if(i.equals("4")){
			double sum = 0;
			for(Goods good: Items.arms){
				if(request.getSession().getAttribute(good.engname)!=null){
					out.printf("<img src='image/arms/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='alert(\"�����ʪ���\");location.href=\"sessiontest?ses=%s&sell=t\"'>�����ʪ���</button><br>",good.name, good.name, good.price, good.engname);
					sum += good.price;
				}
			}
			for(Goods good: Items.food){
				if(request.getSession().getAttribute(good.engname)!=null){
					out.printf("<img src='image/food/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='alert(\"�����ʪ���\");location.href=\"sessiontest?ses=%s&sell=t\"'>�����ʪ���</button><br>",good.name, good.name, good.price, good.engname);
					sum += good.price;
				}	
			}
			for(Goods good: Items.armor){
				if(request.getSession().getAttribute(good.engname)!=null){
					out.printf("<img src='image/armor/%s.jpg'><br>%s�@����:%.2f�@<button type='button' onclick='alert(\"�����ʪ���\");location.href=\"sessiontest?ses=%s&sell=t\"'>�����ʪ���</button><br>",good.name, good.name, good.price, good.engname);
					sum += good.price;
				}
			}
			out.printf("<br><br>�`�@���B�G%.2f�@<button type='button' onclick='alert(\"�I�ڡG %.2f���A ���\�I\");location.href=\"sessiontest?clc=t\"'>�h���b</button><br>", sum, sum);
		}
	}
}
