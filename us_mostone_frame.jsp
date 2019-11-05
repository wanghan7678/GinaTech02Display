<%-- 
    Document   : cn_mostone_frame
    Created on : 2019-7-23, 9:26:34
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript" 
        src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" 
        src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type ="text/javascript" 
        src="${pageContext.request.contextPath}/js/echarts-gl.min.js"></script>

        
        

<!DOCTYPE html>
<div class="details">
      <h2 class="title">Top 1 Prob</h2>
      <div class="buffer">
          
          <div class="thumb"></div>
          <h1>Score：${top.result}</h1>
          <p></p>
          <h2><a href="${pageContext.request.contextPath}/usaOnePage?ts_code=${top.symbol}">${top.symbol}:  ${top.name}</a></h2>
          <h2>Trigger Date：${top.trade_date}</h2>
          <p><br></p>
          <h3>Sector：${top.sector}, Industry：${top.industry}</h3>
          <br>
          <h3>According to the stock's 1800 data and technical indicators, the Gina AI artificial neural network predicts that the stock is very likely to have a 5% or more increase in the next 5 trading days.</h3>
      </div>
      <div id="echart0" style="width: 528px; height: 288px">
      </div>

</div>

<script type="text/javascript">
    var myChart0 = echarts.init(document.getElementById('echart0'));
    var downColor='#ec0000';
    var downBorderColor='8A0000';
    var upColor='#00da3c';
    var upBorderColor='#008F28';
    var categoryData = ${top.category}
    var values = ${top.data}
    

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
        text: '${top.symbol}',
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
            start: 50,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 50,
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