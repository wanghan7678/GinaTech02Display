<%-- 
    Document   : cn_top5_frame1
    Created on : 2019-7-31, 9:45:40
    Author     : hanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="post">
    <div class="details">
          <p class="l"> <span class="category"><a href="#">T3 Velocity</a></span> -  Powered by <a href="#">GINA AI Tech Analysis</a> </p>
          <p class="r"><p class="r"><a href="#"></a></p>
    </div>
          <div class="thumb2" id="t3"></div>
</div>

        
<script type="text/javascript">
    var myChart1 = echarts.init(document.getElementById('t3'));
    var upColor='#ec0000';
    var upBorderColor='8A0000';
    var downColor='#00da3c';
    var downBorderColor='#008F28';
    var categoryData = ${category}
    var values1 = ${t3}



myChart1.setOption(option = {
    title: {
        text: '${basic.symbol} T3 ',
        left: 0
    },
    legend:{
        data:['T3']
    },
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
            name: 'T3',
            type: 'line',
            data: values1,
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
        
    ]
});

</script>
