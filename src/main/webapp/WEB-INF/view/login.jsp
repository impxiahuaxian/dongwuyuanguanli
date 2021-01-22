<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <%
        request.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script src="static/js/jquery-1.12.4.min.js"></script>
    <style type="text/css">
        #login-box {
            width: 15%;
            height: 300px;
            margin: 0 auto;
            margin-top: 15%;
            text-align: center;
            background: #00000060;
            padding: 20px 50px;
        }

        #login-box h1 {
            color: #fff;
        }

        #login-box.form {
            margin-top: 50px;
        }

        #login-box.form.item {
            margin-top: 15px;
        }

        #login-box.form.item i {
            font-size: 18px;
            color: #fff;
        }

        #login-box.form input {
            background: #ffffff00;
            color: white;
            width: 180px;
            font-size: 18px;
            border-bottom: 2px solid white;
            border: 0;
        }

        #login-box button {
            margin-top: 15px;
            width: 120px;
            height: 30px;
            background-image: linear-gradient(to right, #e4afcb 0%, #b8cbb8 0%, #b8cbb8 0%, #e2c58b 30%, #c2ce9c 64%, #7edbdc 100%);
            font-size: 15px;
            font-weight: 500;
            border: 0;
            border-radius: 15px;
        }

        body {
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }

        .inputuser {
            border-radius: 15px;
            width: 200px;
            height: 27px;
        }

        .inputpassword {
            margin-top: 10px;
            border-radius: 15px;
            width: 200px;
            height: 27px;
        }

        .login-btn{
            margin-top: 20px;
            position: relative;
            left: 10px;
        }
        .sign-btn{
            position: relative;
            left: 10px;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #opcity {
            background-color: rgba(0,0,0,0.3);
            height: 100%;
        }
        #opcity:before {
            content: "";
            display: table;
            clear: both;
        }
    </style>
</head>
<body background="${APP_PATH }/static/imgs/cat.ico">
<div id="opcity">
    <div style="color: red" align="center">${msg}</div>
    <div id="login-box">
        <form action="/login" method="post">
            <h1>Login</h1>
            <div>
                <div class="item">
                    <img src="${APP_PATH }/static/imgs/user2.ico" width=20 height=20/>
                    <input type="text" placeholder="UserName" name="username" class="inputuser">
                </div>
                <div class="item">
                    <img src="${APP_PATH }/static/imgs/password2.ico" width=20 height="20"/>
                    <input type="password" name="password" placeholder="Password" class="inputpassword">
                </div>

            </div>
            <div class="login-btn">
                <button id="login" style="width: 100px">登录</button>
            </div>
        </form>
        <button onClick="window.location.href = 'SignUp.jsp'" style="width: 100px" class="sign-btn">注册</button>

    </div>
</div>


<script type="text/javascript">


</script>
</body>
</html>