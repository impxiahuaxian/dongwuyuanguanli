<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--引入核心标签库  prefix值照应后面的cforeach 用于遍历--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>动物园管理系统</title>
    <%
        request.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<%--    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>--%>
<%--    <script type="text/javascript" src="${APP_PATH }/static/js/jquery.form.js"></script>--%>

    <script type="text/javascript" src="${APP_PATH }/static/js/jquery1_4/jquery.min.js"></script>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery1_4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery1_4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery1_4/plugins/myview.js"></script>

    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/upphoto/bootstrap-fileinput.css">
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/upphoto/bootstrap-fileinput.js"></script>
    <style type="text/css">
        html,body{height:100%}
        body{display: flex;flex-direction: column}
        #my-table{flex: auto}
        #my-page{padding-bottom: 40px;}
        #my-page .pagination {margin: 0;}
        .modal-body.form-img {
            display: flex;
        }
        .modal-body.form-img>.form-horizontal {
            flex: auto;
        }
        .modal-body.form-img>div {
            width: 118px;
            flex: none;
        }
        .modal-body.form-img>div>img{
            width: 100%;
        }
        /*上传图片*/
        .upload-img {
            display: inline-block;
            position: relative;
            border: 1px dashed #d9d9d9;
            border-radius: 6px;
            cursor: pointer;
            overflow: hidden;
            width: 100px;
            height: 140px;
            text-align: center;
        }
        .upload-img .glyphicon {
            line-height: 140px;
        }
        .base-box{
            position: absolute;
            display: block;
            opacity: 0;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
        }
        .up-img{
            width: 100%;
            height: 100%;
            opacity: 1;
        }
        .base-box.delete{
            display: none;
        }
        .up-img ~ .delete{
            display:block;
        }
        .up-img ~ .delete:hover{
            opacity: 1;
            background-color: rgba(0,0,0,.4);
            color:#fff
        }
    </style>
</head>
<body>

<%--修改的模态框--%>
<div class="modal fade" id="manageUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">编辑更新</h4>
            </div>
            <div class="modal-body form-img">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">manageid</label>
                        <div class="col-sm-8">
                            <p class="form-control-static" id="manageid_update_static"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">managename</label>
                        <div class="col-sm-4">
                            <input type="text" name="managename" class="form-control" id="managename_update_input"
                                   placeholder="managename">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">sex</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex1_update_input" value="男"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex2_update_input" value="女"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">classes</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="classes" id="classes_update_input">
                                <c:forEach items="${pageInfo.list}" var="manage">
                                    <option value="${manage.classes}">${manage.classes}</option>
                                </c:forEach >
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">phone</label>
                        <div class="col-sm-8">
                            <input type="text" name="phone" class="form-control" id="phone_update_input"
                                   placeholder="Phone">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <input type="text" name="img" style="display: none" value="" id="editImgFile">
                    <input type="text" name="fileType" style="display: none" value="" id="editFileType">
                </form>

                <div class="upload-img">
                    <span class="glyphicon glyphicon-plus"></span>
                    <img class="base-box" src="" id="photo"/>
                    <input type="file" name="file" class="base-box up-input" id="up-file"/>
                    <div class="base-box delete" id="delete-photo">
                        <span class="glyphicon glyphicon-trash"></span>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
<%--                <button onclick="uploadPhoto()">上传</button>--%>
<%--                <button id="aaaaaa">提交图片</button>--%>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary edit_btn" id="manage_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>


<!-- 新增的模态框 check表示默认是在被选中状态-->
<div class="modal fade" id="manageAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <div class="upload-img">
                            <input type="text" name="img" style="display: none" value="" id="addImgFile">
                            <input type="text" name="fileType" style="display: none" value="" id="addFileType">
                            <span class="glyphicon glyphicon-plus"></span>
                            <img class="base-box" src="" id="photo2"/>
                            <input type="file" name="file" class="base-box up-input" id="up-file2"/>
                            <div class="base-box delete" id="delete-photo2">
                                <span class="glyphicon glyphicon-trash"></span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">managename</label>
                        <div class="col-sm-8">
                            <input type="text" name="managename" class="form-control" id="managename_add_input"
                                   placeholder="managename">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">sex</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex1_add_input" value="男" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex2_add_input" value="女"> 女
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">classes</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="classes">
                                <c:forEach items="${pageInfo.list}" var="manage">
                                    <option value="${manage.classes}">${manage.classes}</option>
                                </c:forEach >
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">phone</label>
                        <div class="col-sm-8">
                            <input type="text" name="phone" class="form-control" id="phone_add_input"
                                   placeholder="Phone">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="manage_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<!--搭建显示页面-->
<form class="container">
    <!-- 显示标题，最多列为12列 -->
    <div class="row">
        <div class="col-md-12">
            <h3>管理员信息</h3>
        </div>
    </div>

    <%--    显示搜索框--%>
    <form action=""method="post">
        <input  type="text" name="inputData"  placeholder="Type to search">
        <input type="button" value="搜索" onClick="addParam()">
    </form>
    <!-- 两个按钮，新增删除 第一个表示占多少行，offset 表示偏移多少行  -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" btn-sm id="manage_add_modal_btn">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true" style="width:16px;height:12px;"></span>
                新增
            </button>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="manages_table" >
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>所管理科类</th>
                    <th>电话</th>
                </tr>
                <%--<遍历分页里的所有数据，每一条数据都被称之为manage--%>

                <c:forEach items="${pageInfo.list}" var="manage" varStatus="status">
                    <tr>
                        <th>${status.index + 1 + (pageInfo.pageNum - 1) * 6}</th>
                        <th>${manage.managename}</th>
                        <th>${manage.sex}</th>
                        <th>${manage.classes}</th>
                        <th>${manage.phone}</th>
                        <th>
                            <button class="btn btn-primary btn-sm edit_btn" style="width:60px;height:32px;" edit-id="${manage.manageid}">编辑</button>
                            <button class="btn btn-danger btn-sm del_btn" style="width:60px;height:32px;" del-id="${manage.manageid}" del-managename="${manage.managename}">删除</button>
                        </th>
                    </tr>
                </c:forEach >

            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row" id="my-page">
        <!--分页文字信息 -->
        <div class="col-md-6">

            当前${pageInfo.pageNum}页，总${pageInfo.pages}页，总${pageInfo.total}条记录
        </div>
        <!--分页条信息 -->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${APP_PATH }/manages?pn=1">首页</a></li>
                    <%--                    s上一页的连接地址，当前页码减一,如果有上一页则显示上一页图标，如果没有，例如第一页，则不显示上一页图标--%>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${APP_PATH }/manages?pn=${pageInfo.pageNum-1}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>
                    <%--                    如果是当前页码，就执行li标签内容--%>
                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <%--                        如果不是当前页码，就跳到指定href的URL地址--%>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${APP_PATH }/manages?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${APP_PATH }/manages?pn=${pageInfo.pageNum+1 }"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${APP_PATH }/manages?pn=${pageInfo.pages}" id="enf" onclick="checkk(${pageInfo.pageNum},${pageInfo.pages})">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</form>



<script type="application/javascript">
    /**
     * 搜索绑定事件
     */
    function addParam(){
        var managename = $('input[name=inputData]').val();
        url = '/manages?style=tp&managename='+managename;
        window.location.href = url;
    }

    //点击新增按钮弹出模态框。
    $("#manage_add_modal_btn").click(function(){
        //弹出模态框
        $("#manageAddModal").modal({
            backdrop:"static"
        });
    });

    //点击保存，即保存
    $("#manage_save_btn").click(function() {
        console.log($("#manageAddModal form").serialize())
        $.ajax({
            url:"/manage",
            type:"POST",
            data:$("#manageAddModal form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    //1、关闭模态框
                    alert("保存成功！");
                    $("#manageAddModal").modal('hide');

                }else{
                    if(undefined != result.extend.errorFields.managename){
                        //显示名字的错误信息
                        show_validate_msg("#managename_add_input", "error", result.extend.errorFields.managename);
                    }
                }
            }

        });

    });

    function validate_update_form(){
        //1、拿到要校验的数据，使用正则表达式
        var managename = $("#managename_update_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(managename)){
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            alert("名称可以是2-5位中文或者3-10位英文和数字的组合");
            return false;
        }else{
            return true;
        };
    }

    //校验新增名称是否可用，给managename绑定一个change事件
    $("#managename_add_input").change(function(){
        //发送ajax请求校验名是否可用
        var managename = this.value;
        $.ajax({
            url:"${APP_PATH}/checkuserManage",
            data:"managename="+managename,
            type:"POST",
            success:function(result){
                if(result.code==100){
                    $("#manage_save_btn").attr("ajax-va","success");
                }else{
                    alert(result.msg);
                    $("#manage_save_btn").attr("ajax-va","error");
                }
            }
        });
    });



    // 编辑的名称校验
    function validate_update_form(){
        //1、拿到要校验的数据，使用正则表达式
        var managename = $("#managename_update_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(managename)){
            debugger;
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            alert("名称可以是2-5位中文或者3-10位英文和数字的组合");
            return false;
        }else{
            // alert("#horsename_add_input", "success", "");
            return true;
        };
    }

    //校验新增名称是否可用，给horsename绑定一个change事件
    $("#managename_add_input").change(function(){
        //发送ajax请求校验名是否可用
        var managename = this.value;
        $.ajax({
            url:"${APP_PATH}/checkuserManage",
            data:"managename="+managename,
            type:"POST",
            success:function(result){
                if(result.code==100){
                    //alert("用户名可用！");
                    //show_validate_msg("#managename_add_input","success","名称可用");
                    $("#manage_save_btn").attr("ajax-va","success");
                }else{
                    alert(result.msg);
                    $("#manage_save_btn").attr("ajax-va","error");
                }
            }
        });
    });

    //根据id查询数据详情
    function getManage(manageid){
        $.ajax({
            url:"${APP_PATH}/manageByid/"+manageid,
            type:"GET",
            success:function(result){
                showInfo(result.extend.manage);
            }
        });
    }
    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(event){
        //2、查出管理员信息
        getManage($(this).attr("edit-id"));
        //3、把管理员的id传递给模态框的更新按钮
        $("#manage_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#manageUpdateModal").modal({
            backdrop:"static"
        });
    });

    //查询是否已存在图片，如果以存在则调用显示图片接口
    function showInfo(data) {
        $.ajax({
            url:"${APP_PATH}/selectAddr?manageid="+data.manageid,
            type:"GET",
            success:function(result){
                if(result === 1){
                    var photoDownloadAddr = "/downloadPhoto?manageid=" + data.manageid;
                    addOrDelPhoto("add",photoDownloadAddr)
                }
            }
        });
        document.getElementById("manageid_update_static").innerText = data.manageid
        document.getElementById("managename_update_input").value = data.managename
        document.getElementById("classes_update_input").value = data.classes
        document.getElementById("phone_update_input").value = data.phone
        var radio1 = document.getElementById("sex1_update_input")
        var radio2 = document.getElementById("sex2_update_input")
        radio1.checked = false;
        radio2.checked = false;
        switch (data.sex) {
            case radio1.value:
                radio1.checked = true
                break;
            case radio2.value:
                radio2.checked = true
                break;
        }
    }


    //上传图片
    var delPhoto = document.getElementById("delete-photo")
    var inputFile = document.getElementById("up-file")
    //给上传图片绑定change事件
    inputFile.addEventListener("change",imgLoad,false)
    delPhoto.addEventListener("click",function(){
        addOrDelPhoto("delete")
    },false)
    //删除图片、添加图片是对src的添加、移除
    function addOrDelPhoto(addOrDel,url){
        //photo是img输入框的id
        var photo = document.getElementById("photo")
        if(addOrDel === "delete"){
            photo.removeAttribute("src")
            photo.classList.remove("up-img")
        }else if(addOrDel === "add"){
            photo.setAttribute("src",url)
            photo.classList.add("up-img")
        }
    }

    //当上传图片时就会触发该方法
    function imgLoad(){
        //获取上传图片
        var file = this.files[0]
        if(file){
            // 判断图片类型是否符合该正则表达式
            var type = /^image\//
            var isImg = type.test(file.type)
            if(!isImg){
                return
            }
        //创建一个读file对象
            var reader = new FileReader()
            ////异步方法,文件读取成功完成时触发
            reader.onload = function(e){
                //文件一旦开始读取，无论成功或失败，实例的 result 属性都会被填充。如果读取失败，则 result 的值为 null ，否则即是读取的结果
                var imgFile = e.target.result
                addOrDelPhoto("add",imgFile)
                //截取只保留图片的base64部分,去掉了data:image/jpeg;base64,这段内容
                document.getElementById("editImgFile").value = imgFile.substring(imgFile.indexOf(",") + 1)
                //返回图片名称.后面的图片格式
                document.getElementById("editFileType").value = file.name.substring(file.name.lastIndexOf(".") + 1)
            }
            // readAsDataURL方法会读取指定的File对象。读取操作完成的时候，readyState会变成已完成DONE，
            // 并触发 loadend 事件，同时 result 属性将包含一个data:URL格式的字符串（base64编码）以表示所读取文件的内容。
        //读取完file之后，返回了个URL
            reader.readAsDataURL(file)
        }
    }


    // 获取要删除的图片
    var delPhoto2 = document.getElementById("delete-photo2")
    //获取要传入的图片
    var inputFile2 = document.getElementById("up-file2")
    inputFile2.addEventListener("change",imgLoad2,false)
    delPhoto2.addEventListener("click",function(){
        addOrDelPhoto2("delete")
    },false)

    //添加、删除图片
    function addOrDelPhoto2(addOrDel,url){
        var photo = document.getElementById("photo2")
        if(addOrDel === "delete"){
            photo.removeAttribute("src")
            photo.classList.remove("up-img")
            document.getElementById("addImgFile").value = ""
            document.getElementById("addFileType").value = ""
        }else if(addOrDel === "add"){
            photo.setAttribute("src",url)
            photo.classList.add("up-img")
        }
    }


    function imgLoad2(){
        var file = this.files[0]
        if(file){
            var type = ["image/jpeg","image/png"]
            var isImg = type.toString().indexOf(file.type)
            if(isImg === -1){
                return
            }
            var reader = new FileReader()
            reader.onload = function(e){
                var imgFile = e.target.result
                addOrDelPhoto2("add",imgFile)
                document.getElementById("addImgFile").value = imgFile.substring(imgFile.indexOf(",") + 1)
                document.getElementById("addFileType").value = file.name.substring(file.name.lastIndexOf(".") + 1)
            }
            reader.readAsDataURL(file)
        }
    }

    //点击更新，更新g管理员信息
    $("#manage_update_btn").click(function(){
        var flag = validate_update_form();
        console.log($("#manageUpdateModal form").serialize());
        //2、发送ajax请求保存更新的数据
        if(flag){
            $.ajax({
                url:"${APP_PATH}/manage2/"+$(this).attr("edit-id"),
                type:"PUT",
                data:$("#manageUpdateModal form").serialize(),
                success:function(result){
                    document.location.reload();
                    //1、关闭对话框
                    $("#manageUpdateModal").modal("hide");
                }
            });
        }
    });

    //删除
    $(document).on("click",".del_btn",function () {
        //弹出是否确认删除对话框
        var managename=$(this).attr("del-managename");
        var manageid=$(this).attr("del-id");
        if(confirm("确认删除【"+managename+"】吗？")){
            $.ajax({
                url:"${APP_PATH}/manage1/"+manageid,
                type:"DELETE",
                success:function(result){
                    document.location.reload();
                    alert(result.msg);
                }
            });
        }
    });



</script>
</body>
</html>
