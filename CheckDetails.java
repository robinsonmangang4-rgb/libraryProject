package p1;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/Checkdetails")
public class Checkdetails extends HttpServlet {
    String url = "jdbc:mysql://localhost:3306/library1";
    String username = "root";
    String password = "system";
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;

    int id;
    String name = null;
    String address = null;
    String dob = null;
    String email = null;
    String phone = null;

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

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        try {
            pstmt = con.prepareStatement("SELECT * FROM MEMBERREGISTRATION WHERE id=?");
            pstmt.setInt(1, id);
            res = pstmt.executeQuery();

            while (res.next() == true) {
                id = res.getInt(1);
                name = res.getString(2);
                address = res.getString(3);
                dob = res.getString(4);
                email = res.getString(5);
                phone = res.getString(6);

                PrintWriter pw = response.getWriter();
                pw.println(id + " " + name + " " + address + " " + dob + " " + email + " " + phone);

            }
        } catch (Exception e) {
            PrintWriter pw = response.getWriter();
            pw.println("ID not found");
        }

    }

}
