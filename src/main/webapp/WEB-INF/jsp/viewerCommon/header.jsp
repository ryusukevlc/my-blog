<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.lang.Integer" %>
    
<%
  request.setCharacterEncoding("UTF-8");
  int weather = Integer.parseInt(request.getParameter("weather"));
  
  String weatherOfTokyo = "https://www.google.com/search?q=%E6%9D%B1%E4%BA%AC+%E5%A4%A9%E6%B0%97&oq=%E6%9D%B1%E4%BA%AC%E3%80%80%E5%A4%A9%E6%B0%97&aqs=chrome.0.69i59j35i39j0i512l3j0i131i433l2j0i512l3.4695j1j15&sourceid=chrome&ie=UTF-8";
%>

<header style="margin-bottom: 30px;">
    <div class="title-bar" style="position: relative;">
        <h1 class="title-bar-title" style="margin: 10px;">
            <a href="/" style="color: white; font-size: 40px;">
                RyusukeBlog <i class="fa-solid fa-mountain-sun" style="color:red;"></i>
            </a>
        </h1>
        <h2 style="position: absolute; right: 40px; margin: auto 0;">
        <% if (weather == 0) { %>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-sun"></i></a>
        <% } else if (weather == 1) { %>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-sun-bright"></i></a>
        <% } else if (weather == 2) {%>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-cloud-sun"></i></a>
        <% } else if (weather == 3) { %>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-cloud"></i></a>
        <% } else if (weather == 45) {%>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-smog"></i></a>
        <%} else if (weather == 80) {%>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i class="fa-solid fa-cloud-sun-rain"></i></a>
        <%} else {%>
        	<a href="<%= weatherOfTokyo%>" style="color: white;"><i></i></a>
        <%} %>
        </h2>
    </div>
    <div class="top-bar" style="background-color:#F5F5F5;">
        <div class="top-bar-left">
            <ul class="menu" style="font-family: Helvetica; background-color:   #F5F5F5;">
                <li><a href="#" id="menu-cell"><strong>Tech</strong></a></li>
                <li><a href="#" id="menu-cell"><strong>Launch Info</strong></a></li>
                <li><a href="#" id="menu-cell"><strong>Contact</strong></a></li>
                <li><a href="#" id="menu-cell"><strong>Admin Info</strong></a></li>
                <li><a href="#" id="menu-cell"><strong>Other</strong></a></li>
            </ul>
        </div>
    </div>
</header>