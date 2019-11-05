<%-- 
    Document   : index
    Created on : 2019-7-28, 1:01:51
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gina AI Power</title>
    </head>
    <body style="padding: 50px 50px 50px 50px">
        <h1>Welcome to Gina AI Tech Analysis!</h1>
        <ul>
            <li>The GINA AI artificial neural network consists of a three-layer 128-unit GRU neural network that analyzes 1,800 data and technical indicators for each stock.</li>
            <li>The analysis of GINA AI is based solely on transaction data and technical indicators of individual stocks. Did not consider any basic factors, corporate governance and macro and corporate news and other data.</li>
            <li>The analysis results displayed on this website are for the sole purpose of scientific research in computer science and financial engineering.</li>
            <li>The information displayed on this website does not constitute any form of investment advice.</li>
            <li>Greenrich Aps does not hold any securities showing on our websites.</li>
        </ul>
        <ul>
            <a href="/chineseHome">Chinese Stock 中国股市</a>
            <a href="/usaHome">USA Stock 美国股市</a>
            <c:redirect url="/chineseHome"></c:redirect>
        </ul>
    </body>
</html>
