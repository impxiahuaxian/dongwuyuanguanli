<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Title</title>
    <%
        request.setAttribute("APP_PATH", request.getContextPath());
    %>
    <style type="text/css">
        #main-nav {
            margin-left: 1px;
        }

        #main-nav.nav-tabs.nav-stacked > li > a {
            padding: 10px 8px;
            font-size: 12px;
            font-weight: 600;
            color: #4A515B;
            background: #E9E9E9;
            background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #FAFAFA), color-stop(100%, #E9E9E9));
            background: -webkit-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            background: -o-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            background: -ms-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            background: linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
            border: 1px solid #D5D5D5;
            border-radius: 4px;
        }

        #main-nav.nav-tabs.nav-stacked > li > a > span {
            color: #4A515B;
        }

        #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover {
            color: #FFF;
            background: #3C4049;
            background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #4A515B), color-stop(100%, #3C4049));
            background: -webkit-linear-gradient(top, #4A515B 0%, #3C4049 100%);
            background: -o-linear-gradient(top, #4A515B 0%, #3C4049 100%);
            background: -ms-linear-gradient(top, #4A515B 0%, #3C4049 100%);
            background: linear-gradient(top, #4A515B 0%, #3C4049 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
            border-color: #2B2E33;
        }

        #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover > span {
            color: #FFF;
        }

        #main-nav.nav-tabs.nav-stacked > li {
            margin-bottom: 4px;
        }

        /*定义二级菜单样式*/
        .secondmenu a {
            font-size: 10px;
            color: #4A515B;
            text-align: center;
        }

        .navbar-static-top {
            background-color: #212121;
            margin-bottom: 5px;
        }

        .navbar-brand {
            background: url('') no-repeat 10px 8px;
            display: inline-block;
            vertical-align: middle;
            padding-left: 50px;
            color: #fff;
            position: relative;
            top: 3px;
            font-size: 20px;

        }
    </style>
    <script
            type="text/javascript"
            src="${APP_PATH }/static/js/jquery-1.12.4.min.js"
    ></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
    <div class="container-fluid" style="height: 10px">
        <div class="navbar-header">
            <h2 class="navbar-brand" id="logo">动物园管理系统
            </h2>
            </div>
        </div>
    </div>
<%--container 类和container-fluid类的区别体现在是否有随视口宽度改变的margin存在。--%>
<%--container类所谓的自适应也是通过margin的改变来完成，container-fluid类的百分百宽度是指在固有的15px的padding前提下宽度总是当前视口的宽度。--%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                    <li class="active">
                        <a href="#">
                            <i class="glyphicon glyphicon-th-large"></i>
                            首页
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            动物管理
                            <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="/horses" target="center">马科动物管理</a>
                            </li>
                            <li><a href="/cats" target="center">猫科动物管理</a>
                            </li>
                            <li><a href="/dogs" target="center">犬科动物管理</a>
                            </li>
                            <li><a href="/mouses" target="center">鼠科动物管理</a>
                            </li>
                            <li><a href="/fishs" target="center">鱼类动物管理</a>
                            </li>
                            <li><a href="/eles" target="center">脊索动物管理</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#systemSetti" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>
                            游览服务
                            <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetti" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="http://localhost:8082/rules.jsp" target="center">停车场管理</a></li>
                            <li><a href="http://localhost:8082/ticket.jsp" target="center">票价查询</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="http://localhost:8082/chart.jsp" target="center">
                            <i class="glyphicon glyphicon-signal"></i>
                            图表统计
                        </a>
                    </li>
                    <li>
                        <a href="/manages" target="center">
                            <i class="glyphicon glyphicon-user"></i>
                            各科类管理员
                        </a>
                    </li>

                    <li>
                        <a href="http://localhost:8082/mailform.jsp" target="center">
                            <i class="glyphicon glyphicon-envelope"></i>
                            邮件发送
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-md-30">
                <iframe src="/horses" name="center" scrolling="no" height="580" width="1200"></iframe>
            </div>
            <div>
                <img src="./../../../static/imgs/phone.ico" width="25px" height="20px"/>
                客服电话：12345678
            </div>
        </div>
    </div>
    <script type="text/javascript">


    </script>
</body>

</html>
