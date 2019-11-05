<%-- 
    Document   : cn_side_yesterdayframe
    Created on : 2019-7-31, 14:03:20
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="box">
      <h2>Top Scores</h2> 
         <ul>
        <h3>Highest Scores</h3>
         
         <table>
             <c:forEach items="${trackTop15}" var="item">
             <tr>
                 <td><a href="${pageContext.request.contextPath}/usaOnePage?ts_code=${item.symbol}">${item.symbol} ${item.name}</a></td>
                 <td></td>
                 <td>${item.result}</td>
                 <td> </td>
                 <td>${item.pastdays}D</td>
                 <td>
                     <c:if test="${item.ifup==true}">
                        <img src="images/upar1.png" alt="+" />
                     </c:if>
                     <c:if test="${item.ifup==false}">
                        <img src="images/downar2.png" alt="-" />
                     </c:if>
                 
                 </td>
                 <td>${item.chgpct}%</td>
             </tr>
             </c:forEach>
         </table>
         </ul>
    </div>
