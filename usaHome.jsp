<%-- 
    Document   : index
    Created on : 2019-7-22, 18:16:30
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Gina AI Tech Analysis</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lte IE 6]><link rel="stylesheet" type="text/css" href="ie.css" /><![endif]-->
</head>
<body>
<!-- BEGIN wrapper -->
<div id="wrapper">
  <!-- BEGIN header -->
  <div id="header">
    <ul class="pages">
      <li><a href="chineseHome">China Stocks</a></li>
      <li><a href="usaHome">USA Stocks</a></li>
      <li><a href="http://greenrich.dk/about.html">About Us</a></li>
      <li><a href="http://greenrich.dk/contact-me.html">Contact Page</a></li>
    </ul>
    <form action="#">

    </form>
    <div class="break"></div>
    <h1><a href="#">GINA AI TECH ANALYSIS</a></h1>
    <div class="ad"><a href="http://www.greenrich.dk">GREENRICH ApS, Copenhagen</a></div>
    <ul class="categories">
      <li><a href="#">New York Stock Exchange</a></li>
      <li><a href="#">NASDAQ</a></li>
      <li><a href="#">American Stock Exchange</a></li>
    </ul>
  </div>
  <!-- END header -->
  <!-- BEGIN content -->
  <div id="content">
    <!-- begin featured -->
    <div class="featured">
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_mostone_frame.jsp"></jsp:include>
    </div>
    <!-- end featured -->
    <!-- begin more articles -->
    <div class="articles">
      <h2 class="title">More Results</h2>
      <!-- begin post -->
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_top5_frame.jsp"></jsp:include>
    <!-- end more articles -->
    <!-- begin post navigation -->
    <!-- end post navigation -->
    <div class="break"></div>
    </div>
    <div class="postnav"></div>
  </div>
  <!-- END content -->
  <!-- BEGIN sidebar -->
  <div id="sidebar">
    <!-- begin sponsors -->

        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_side_claimsframe.jsp"></jsp:include>
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_side_todayframe.jsp"></jsp:include>
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_side_yesterdayframe.jsp"></jsp:include>
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_side_pre5frame.jsp"></jsp:include>
        <jsp:include page="${request.contextPath}/WEB-INF/jsp/us_side_topScoreframe.jsp"></jsp:include>
  </div>
  <!-- END sidebar -->
  <!-- BEGIN footer -->
  <div id="footer">
    <p>Copyright &copy; 2019 - <a href="#">GINA AI POWER</a> &middot; All Rights Reserved | Powered by: <a href="http://www.greenrich.dk/">GREENRICH Aps</a> | Learn More <a href="#">GINA GREEN AI Solutions</a></p>
  </div>
  <!-- END footer -->
</div>
<!-- END wrapper -->
</body>
</html>

