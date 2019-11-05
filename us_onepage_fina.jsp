<%-- 
    Document   : cn_onepage_maintop
    Created on : 2019-8-5, 9:51:23
    Author     : hanwang
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        

<div class="featured">
      <h2 class="title">Finance</h2>
      <div class="buffer">
          <h2>Finance Indicators</h2>
          <p><br/></p>
          <table>
              <tr>
                  <td width="108px"></td>
                  <td width="108px"></td>
                  <td width="108px"></td>
                  <td width="108px"></td>
                  <td width="106px"></td>
              </tr>
              <tr>
                  <td></td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          <b>${item.end_date}</b>
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Total Revenue</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.total_rev}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Cost of Revenue</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.cost_of_rev}
                      </td>
                  </c:forEach>
              </tr>          
              <tr>
                  <td>Gross Profit</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.gross_profit}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Operating Expenses</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.ops_exp}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Research Development</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.r_n_d}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Selling General and Administrative</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.selling_ga}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Non Recurring</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.non_rec}万
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Others</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.Others}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Total Operating Expenses</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.total_ops}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Operating Income or Loss</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.ops_il}
                      </td>
                  </c:forEach>
              </tr>              
              <tr>
                  <td>Income from Continuing Operations</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.income_cops}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Total Other Income/Expenses Net</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.total_other}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>EBIT</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.ebit}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Interest Expense</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.interest_exp}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Income Before Tax</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.income_before_tax}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Income Tax Expense</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.income_tax_expense}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Minority Interest</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.min_int}
                      </td>
                  </c:forEach>
              </tr>
             <tr>
                  <td>Net Income From Continuing Ops</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.net_income_cs}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Discontinued Operations</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.disc_ops}
                      </td>
                  </c:forEach>
              </tr>
               <tr>
                  <td>Extraordinary Items</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.extra_items}
                      </td>
                  </c:forEach>
              </tr>
                <tr>
                  <td>Effect Of Accounting Changes</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.effect_ofac}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Other Items</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.other_items}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                        <td>Preferred Stock And Other Adjustments</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.pre_stk}
                      </td>
                  </c:forEach>
              </tr>
              <tr>
                  <td>Net Income Applicable To Common Shares</td>
                  <c:forEach items="${fina}" var="item">
                      <td>
                          ${item.net_income_to_cs}
                      </td>
                  </c:forEach>
              </tr>
          </table>

      </div>
</div>
             