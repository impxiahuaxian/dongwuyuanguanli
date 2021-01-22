<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8"%>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <%
        request.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script src="static/js/jquery-1.12.4.min.js"></script>
    <style type="text/css">
        #login-box {
            width: 30%;
            height: auto;
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
        input{
            height: 38px;
            margin-top: 10px;
            border-radius: 15px;
            width: 200px;
            height: 27px;
        }
        .formStyle{
            width: 15%;
            height: 700px;
        }
    </style>
</head>
<body background="${APP_PATH }/static/imgs/cat.ico">
<div id="login-box" class="formStyle">
    <form action="/SignUp" method="post">
        <h1>Sign Up</h1>
        <div>
            <div class="item">
                <img src="${APP_PATH }/static/imgs/user2.ico" width=20 height=20/>
                <input type="text" placeholder="UserName" name="username" style="height:20px;">
            </div>
            <div class="item">
                <img src="${APP_PATH }/static/imgs/password2.ico" width=20 height="20"/>
                <input type="password" name="password" placeholder="Password..." style="height:20px;">
            </div>

            <div class="item">
                <img src="${APP_PATH }/static/imgs/sex.ico" width=20 height="20"/>
                <input type="text" name="sex" placeholder="sex..." style="height:20px;">
            </div>

            <div class="item">
                <img src="${APP_PATH }/static/imgs/email.ico" width=20 height="20"/>
                <input type="text" name="email" placeholder="Email..." style="height:20px;">
            </div>

        </div>
        <button id="register" onclick="registerFun()">Sign Up</button>
        <button id="cancle" type="reset">Cancle</button>
    </form>
</div>

<script type="text/javascript">

    //提示注册成功
    function registerFun() {
        alert("注册成功！！" +
            "即将返回登录页面");
    }


</script>

</body>
</html>