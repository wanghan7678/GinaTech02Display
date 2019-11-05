<%-- 
    Document   : cn_top5_frame1
    Created on : 2019-7-31, 9:45:40
    Author     : hanwang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${topother}" var="item">
<div class="post">
        <div class="details">
          <p class="l"> <span class="category"><a href="#">${item.symbol}</a></span> - Posted by <a href="#">GINA AI Tech Analysis</a> on ${item.trade_date} </p>
          <p class="r"> <a href="#"></a> </p>
        </div>
        <div class="thumb" id="${item.name}"></div>
        <h2>Score：${item.result}</h2>
        <h2><a href="${pageContext.request.contextPath}/usaOnePage?ts_code=${item.symbol}">${item.symbol}:  ${item.name}</a></h2>
        <h2>Trigging Date：${item.trade_date}</h2>
        <p>Sector：${item.sector}, Industry：${item.industry}</p>
        <p>According to the stock's 1800 data and technical indicators, the Gina AI artificial neural network predicts that the stock is very likely to have a 5% or more increase in the next 5 trading days.</p>
</div>

        
<script type="text/javascript">
    var myChart1 = echarts.init(document.getElementById('${item.name}'));
    var downColor='#ec0000';
    var downBorderColor='8A0000';
    var upColor='#00da3c';
    var upBorderColor='#008F28';
    var categoryData = ${item.category}
    var values = ${item.data}
    

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



myChart1.setOption(option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
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
            start: 0,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 0,
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
                tooltip: {
                    formatter: function (param) {
                        return param.name + '<br>' + (param.data.coord || '');
                    }
                }
            },

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

</c:forEach>