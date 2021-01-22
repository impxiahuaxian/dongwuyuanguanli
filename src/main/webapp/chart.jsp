<%--
  Created by IntelliJ IDEA.
  User: lihanli
  Date: 2020/4/27
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>图表统计</title>
    <%
        request.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- 引入 echarts.js -->
    <script src="${APP_PATH }/static/chart/echarts.min.js"></script>
    <style type="text/css">
        .chart{
            width: 700px;
            height:500px;
            position: relative;
            top: 100px;
            left: 50px;
        }
    </style>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" class="chart"></div>

<script type="text/javascript">


    $(function () {
        $.ajax({
            url:"/numAndName",
            type:"post",
            dataType:"json",
            success:function (result) {
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '各科动物数量展示'
                    },
                    tooltip: {},
                    legend: {
                        data:['数量']
                    },
                    xAxis: {
                        /*data: ["马科","猫科","犬科","鱼类","脊索动物","鼠类"]*/
                        data: result.name
                    },
                    yAxis: {},
                    series: [{
                        name: '数量',
                        type: 'bar',
                        //data: [5, 20, 36, 10, 10, 20]
                        data : result.count
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
    })


</script>
</body>
</html>
