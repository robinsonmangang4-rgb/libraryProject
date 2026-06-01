<%@ page import="java.util.*, p1.MemberInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
   <link rel="stylesheet" type=" text/css" href="dashboardStyles.css"> 
     
    <!----===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    

    <title>Admin Dashboard Panel</title> 
</head>
<body> 

<% response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
		if (session.getAttribute("username")==null) {
			response.sendRedirect("index.html");
		}
	%>


    <script type="text/javascript" src="dashoard.js"></script>
    <nav>
        <div class="logo-name">
            <div class="logo-image">
                <img src="images/logo.png" alt="">
            </div>

            <span class="logo_name">ABC LAIBRARY</span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="#">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Dahsboard</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-files-landscapes"></i>
                    <span class="link-name">Content</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-chart"></i>
                    <span class="link-name">Analytics</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-thumbs-up"></i>
                    <span class="link-name">Like</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-comments"></i>
                    <span class="link-name">Comment</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-share"></i>
                    <span class="link-name">Share</span>
                </a></li>
                <li><a href="addbook.jsp">
                    <i class="uil uil-share"></i>
                    <span class="link-name">Book List</span>
                </a></li>
            </ul>
            
            <ul class="logout-mode">
                <li><a href="Logout">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>

                <li class="mode">
                    <a href="#">
                        <i class="uil uil-moon"></i>
                    <span class="link-name">Dark Mode</span>
                </a>

                <div class="mode-toggle">
                  <span class="switch"></span>
                </div>
            </li>
            </ul>
        </div>
    </nav>

    <section class="dashboard">
        <div class="top">
            <i class="uil uil-bars sidebar-toggle"></i>

            <div class="search-box">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Search here...">
            </div>
            
            <img src="images/profile.jpg" alt="">
        </div>

        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">Dashboard</span>
                </div>

                <div class="boxes">
                    <div class="box box1">
                        <i class="uil uil-thumbs-up"></i>
                        <span class="text">Total Likes</span>
                        <span class="number">50,120</span>
                    </div>
                    <div class="box box2">
                        <i class="uil uil-comments"></i>
                        <span class="text">Comments</span>
                        <span class="number">20,120</span>
                    </div>
                    <div class="box box3">
                        <i class="uil uil-share"></i>
                        <span class="text">TOTAL USER</span>
                        <span class="number">${sum}</span>
                    </div>
                </div>
            </div>

       
    <table>
        <tr>
            <th>ID</th><th>Name</th><th>Address</th><th>dob</th><th>email</th><th>phone</th>
        </tr>

        <%
            List<MemberInfo> members = (List<MemberInfo>) request.getAttribute("members");
            if (members != null) 
            {
                for (MemberInfo m : members) {
        %>
        <tr>
            <td><%= m.getId() %></td>
            <td><%= m.getName() %></td>
            <td><%= m.getAddress() %></td>
            <td><%= m.getDob() %></td>
            <td><%= m.getEmail() %></td>
            <td><%= m.getPhone() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    
    
                     

    <script src="script.js"></script>
</body>
</html>