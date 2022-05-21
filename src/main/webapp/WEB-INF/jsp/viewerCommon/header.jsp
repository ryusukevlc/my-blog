<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.lang.Integer" %>
    
<%
  request.setCharacterEncoding("UTF-8");
  int weather = Integer.parseInt(request.getParameter("weather"));
%>

<header style="margin-bottom: 30px;">
    <div class="title-bar" style="position: relative;">
        <h1 class="title-bar-title" style="margin: 10px;">
            <a href="/Morgenrot/home" style="color: white;">
                Morgenrot <i class="fa-solid fa-mountain-sun" style="color:red;"></i>
            </a>
        </h1>
        <h2 style="position: absolute; right: 40px; margin: auto 0;">
        <% if (weather == 0) { %>
        	<i class="fa-solid fa-sun"></i>
        <% } else if (weather == 1) { %>
        	<i class="fa-solid fa-sun-bright"></i>
        <% } else if (weather == 2) {%>
        	<i class="fa-solid fa-cloud-sun"></i>
        <% } else if (weather == 3) { %>
        	<i class="fa-solid fa-cloud"></i>
        <% } else if (weather == 45) {%>
        	<i class="fa-solid fa-smog"></i>
        <%} else if (weather == 80) {%>
        	<i class="fa-solid fa-cloud-sun-rain"></i>
        <%} else {%>
        	<i></i>
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