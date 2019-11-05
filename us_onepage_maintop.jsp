<%-- 
    Document   : cn_onepage_maintop
    Created on : 2019-8-5, 9:51:23
    Author     : hanwang
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" 
        src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" 
        src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type ="text/javascript" 
        src="${pageContext.request.contextPath}/js/echarts-gl.min.js"></script>
        

<div class="featured">
      <h2 class="title">Basic</h2>
      <div class="buffer">
          <table>
              <tr>
                  <td width="225px"><h1>Score：${basic.score} %</h1></td>
                  <td width="85px"></td>
                  <td width="168px"></td>
                  <td width="60px"></td>
              </tr>
              <tr>
                  <td><h2><a href="${pageContext.request.contextPath}/usaOnePage?ts_code=${basic.symbol}">${basic.symbol} ${basic.name}</a></h2><br/><h3>Trigger Date： ${basic.trig_date}</h3></td>
                  <td></td>
                  <td>
                            <table>
                                <tr><td>${basic.last_date}</td></tr>
                                <tr><td>Open：${basic.open}</td><td>Close：${basic.close}</td></tr>
                                <tr><td>High：${basic.high}</td><td>Low：${basic.low}</td></tr>
                                <tr><td colspan="2">Volume：${basic.vol}</td></tr>
                            </table>
                  </td>
                  <td>
                      <c:if test="${basic.pct_chg>=0}">
                          <img src="images/upus02.png" alt="+" />
                      </c:if>
                      <c:if test="${basic.pct_chg<0}">
                        <img src="images/downus02.png" alt="-" />
                     </c:if>
                      <h3>${basic.pct_chg}%</h3>
                  </td>
          </table>
          <div>
              <p><br/></p>
              <h3>Sector：${basic.sector},  Industry：${basic.industry}   </h3>
              <p><a href="http://${basic.website}">Sum Quote Website</a></p>
              <p><br/></p>
              <p>${basic.introduction}</p>
          </div>
          
     </div>
      <div id="echart0" class="echart1"></div>

</div>
                  
                  
<script type="text/javascript">
    var myChart0 = echarts.init(document.getElementById('echart0'));
    var downColor='#ec0000';
    var downBorderColor='8A0000';
    var upColor='#00da3c';
    var upBorderColor='#008F28';
    var categoryData = ${basic.category}
    var values = ${basic.data}
    

    function calculateMA(dayCount) {
        var result = [];
        for (var i = 0, len = values.length; i < len; i++) {
            if (i < dayCount) {
                result.push('-');
                continue;
            }
            var sum = 0;
            for (var j = 0; j < dayCount; j++) {
                sum += values[i - j][1];
            }
            result.push((sum / dayCount).toFixed(2));
        }
        return result;
    }



myChart0.setOption(option = {
    title: {
        text: '${basic.symbol}',
        left: 0
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data: ['日K', 'MA5', 'MA10', 'MA20']
    },
    grid: {
        left: '10%',
        right: '10%',
        bottom: '15%'
    },
    xAxis: {
        type: 'category',
        data: categoryData,
        scale: true,
        boundaryGap : false,
        axisLine: {onZero: false},
        splitLine: {show: false},
        splitNumber: 20,
        min: 'dataMin',
        max: 'dataMax'
    },
    yAxis: {
        scale: true,
        splitArea: {
            show: true
        }
    },
    dataZoom: [
        {
            type: 'inside',
            start: 60,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 60,
            end: 100
        }
    ],
    series: [
        {
            name: '日K',
            type: 'candlestick',
            data: values,
            itemStyle: {
                normal: {
                    color: upColor,
                    color0: downColor,
                    borderColor: upBorderColor,
                    borderColor0: downBorderColor
                }
            },
            markPoint: {
                label: {
                    normal: {
                        formatter: function (param) {
                            return param != null ? Math.round(param.value) : '';
                        }
                    }
                },
                data: [
                    {
                        name: 'highest value',
                        type: 'max',
                        valueDim: 'highest'
                    },
                    {
                        name: 'lowest value',
                        type: 'min',
                        valueDim: 'lowest'
                    },
                    {
                        name: 'average value on close',
                        type: 'average',
                        valueDim: 'close'
                    }
                ],
                tooltip: {
                    formatter: function (param) {
                        return param.name + '<br>' + (param.data.coord || '');
                    }
                }
            },
            markLine: {
                symbol: ['none', 'none'],
                data: [
                    [
                        {
                            name: 'from lowest to highest',
                            type: 'min',
                            valueDim: 'lowest',
                            symbol: 'circle',
                            symbolSize: 10,
                            label: {
                                normal: {show: false},
                                emphasis: {show: false}
                            }
                        },
                        {
                            type: 'max',
                            valueDim: 'highest',
                            symbol: 'circle',
                            symbolSize: 10,
                            label: {
                                normal: {show: false},
                                emphasis: {show: false}
                            }
                        }
                    ],
                    {
                        name: 'min line on close',
                        type: 'min',
                        valueDim: 'close'
                    },
                    {
                        name: 'max line on close',
                        type: 'max',
                        valueDim: 'close'
                    }
                ]
            }
        },
        {
            name: 'MA5',
            type: 'line',
            data: calculateMA(5),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA10',
            type: 'line',
            data: calculateMA(10),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA20',
            type: 'line',
            data: calculateMA(20),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },

    ]
});

</script>