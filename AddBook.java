package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet
{
	String url="jdbc:mysql://localhost:3306/library1";
	String username="root";
	String password="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet res=null;
	
	int id;
	String bookname=null;
	String author=null;
	String price=null;
	String rentprice=null;
	
	
	public void init()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load success");
		}
		catch(Exception e)
		{
			System.out.println("Driver load failed");
		}
		
		//connection
		try
		{
			con=DriverManager.getConnection(url,username,password);//database connection
			System.out.println("Connection success");
			
		}
		catch(Exception e)
		{
			System.out.println("Connection failed");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		bookname=request.getParameter("bookname");
		author=request.getParameter("author");
		price=request.getParameter("price");
		rentprice=request.getParameter("rentprice");
		
		
		try
		{
			pstmt=con.prepareStatement("INSERT INTO addbook(bookname,author,price,renprice) VALUES(?,?,?,?,)");
			
			pstmt.setString(1,bookname);
			pstmt.setString(2,author);
			pstmt.setString(3,price);
			pstmt.setString(4,rentprice);
			
			
			int row=pstmt.executeUpdate();
			System.out.println(row);
			System.out.println("Data insert success");
		}
		catch(Exception e)
		{
			System.out.println("data insert failed");
		}
		
	}

}
