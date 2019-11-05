<%-- 
    Document   : cn_side_yesterdayframe
    Created on : 2019-7-31, 14:03:20
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="box">
      <h2>History Scores</h2>
      <ul>      
         <h3>History Scores</h3>
         <table>
             <tr>
                 <td width="80px">Trigger Date</td>
                 <td width="40px">Score</td>
                 <td width="20px"></td>
                 <td width="70px">5 days</td>
                 <td width="70px">to today</td>
             </tr>
             <c:forEach items="${hist}" var="item">
             <tr>
                 <td>${item.trig_date}</td>
                 <td>${item.result}%</td>
                 <td></td>
                 <td>
                     <c:if test="${item.chgpct6>=0}">
                        <img src="images/cn_up.png" alt="+" />${item.chgpct6}%
                     </c:if>
                     <c:if test="${item.chgpct6<0 && item.chgpct6>-100}">
                        <img src="images/cn_dn.png" alt="-" />${item.chgpct6}%
                     </c:if>
                     <c:if test="${item.chgpct6==-100}">
                         -
                     </c:if>
                 </td>
                 <td>
                     <c:if test="${item.ifup==true}">
                        <img src="images/cn_up.png" alt="+" />
                     </c:if>
                     <c:if test="${item.ifup==false}">
                        <img src="images/cn_dn.png" alt="-" />
                     </c:if>
                    ${item.chgpct}%
                 </td>
             </tr>
             </c:forEach>
         </table>
      </ul>
    </div>
