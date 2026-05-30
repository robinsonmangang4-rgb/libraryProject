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

@WebServlet("/Contactus")
public class Contactus extends HttpServlet {
    String url = "jdbc:mysql://localhost:3306/library1";
    String username = "root";
    String password = "system";
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;

    int id;
    String name = null;
    String phone = null;
    String email = null;
    String subject = null;
    String massage = null;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load success");
        } catch (Exception e) {
            System.out.println("Driver load failed");
        }

        // connection
        try {
            con = DriverManager.getConnection(url, username, password);// database connection
            System.out.println("Connection success");

        } catch (Exception e) {
            System.out.println("Connection failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        name = request.getParameter("name");
        phone = request.getParameter("phone");
        email = request.getParameter("email");
        subject = request.getParameter("subject");
        massage = request.getParameter("massage");

        try {
            pstmt = con.prepareStatement("INSERT INTO contactus(name,phone,email,subject,massage) VALUES(?,?,?,?,?)");

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.setString(4, subject);
            pstmt.setString(5, massage);

            int row = pstmt.executeUpdate();
            System.out.println(row);
            System.out.println("Data insert success");

            response.sendRedirect("success.html");
        } catch (Exception e) {
            System.out.println("data insert failed");
        }

    }

}
