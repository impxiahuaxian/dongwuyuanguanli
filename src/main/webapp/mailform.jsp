<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>mailform.jsp</title>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <style>
        #mail-form p{
            font-size: 24px;
        }
        #mail-form table{
            border-collapse: collapse;
        }
        #mail-form table td{
            background: -webkit-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
        }
        #mail-form td>div{
            display: flex;
            justify-content: center;
        }
        #mail-form td>div input,#mail-form td>div textarea{
            width: calc(100% - 20px);
            margin: 5px 10px;
            height: 30px;
        }
        #mail-form td>div textarea{
            height: 100%;
        }
        #mail-form td>div input[type="submit"]{
            width: 100px;
            padding: 0 10px;
        }
    </style>
</head>
<body>
<form name="form1" method="post" action="/sendmail" id="mail-form">
    <p align="center">发件箱</p>
    <div align="center">
        <table width="75%" border="1">
            <tr>
                <td><div align="center">收件人</div></td>
                <td><div align="center">
                    <input name="to" type="text" id="to" size="30" maxlength="30">
                </div></td>
            </tr>
            <tr>
                <td><div align="center">发件人</div></td>
                <td><div align="center">
                    <input name="from" type="text" id="from" size="30" maxlength="30">
                </div></td>
            </tr>

            <tr>
                <td><div align="center">主题</div></td>
                <td><div align="center">
                    <input name="subject" type="text" id="subject" size="30" maxlength="30">
                </div></td>
            </tr>
            <tr>
                <td colspan="2"><div align="center">
                    <textarea name="content" cols="40" rows="10" id="body"></textarea>
                </div></td>
            </tr>
            <tr>
                <td colspan="2"><div align="center">
                    <input type="submit" name="Submit" value="发送">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="Reset" type="submit" id="Reset" value="清空">
                </div></td>
            </tr>
        </table>
    </div>
    <p align="center">&nbsp;</p>
</form>
<p align="center">&nbsp;</p>
<script type="application/javascript">

</script>
</body>
</html>