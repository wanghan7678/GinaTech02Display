<%-- 
    Document   : cn_side_yesterdayframe
    Created on : 2019-7-31, 14:03:20
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="box">
      <h2>Last 10 Days</h2>
      <ul>      
         <h3>Last 10 Days</h3>
         <table>
             <tr>
                 <td></td>
                 <td>Open</td>
                 <td>High</td>
                 <td>Low</td>
                 <td>Close</td>
                 <td></td>
                 <td>Change</td>
             </tr>
             <c:forEach items="${last10}" var="item">
             <tr>
                 <td>${item.trade_date}</td>
                 <td>${item.open}</td>
                 <td>${item.high}</td>
                 <td>${item.low}</td>
                 <td>${item.close}</td>
                 <td>
                     <c:if test="${item.pct_chg>=0}">
                        <img src="images/upar1.png" alt="+" />
                     </c:if>
                     <c:if test="${item.pct_chg<0}">
                        <img src="images/downar2.png" alt="-" />
                     </c:if>
                 </td>
                 <td>${Math.round(item.pct_chg*100)/100}%</td>
             </tr>
             </c:forEach>
         </table>
      </ul>
    </div>
