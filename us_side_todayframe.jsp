<%-- 
    Document   : cn_side_todayframe
    Created on : 2019-7-31, 2:00:08
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
 java.util.Date date = new java.util.Date();
 String str_date1 = formatter.format(date);
 
%>
<div class="box">

      <h2>Today</h2>
     
      <ul>      
         <h3><%= str_date1 %></h3>
        <li><a href="https://www.reuters.com/news/archive/worldNews">World News</a></li>
        <li><a href="https://www.usatoday.com/">USA Today</a></li>
        <li><a href="https://www.marketwatch.com/markets/us">USA Financial News</a></li>
        <li><a href="https://finance.yahoo.com">Global Financial News</a></li>
        <li><a href="https://hk.finance.yahoo.com">Hong Kong Financial News</a></li>
      </ul>

</div>