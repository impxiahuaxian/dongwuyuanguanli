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
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        html,body{height:100%}
        body{display: flex;flex-direction: column}
        #my-table{flex: auto}
        #my-page{padding-bottom: 40px;}
        #my-page .pagination {margin: 0;}
    </style>
</head>
<body>

<%--修改的模态框--%>
<div class="modal fade" id="catUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">编辑更新</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">id</label>
                        <div class="col-sm-8">
                            <p class="form-control-static" id="id_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">sex</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex1_update_input" value="M"> M
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex2_update_input" value="F"> F
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">catname</label>
                        <div class="col-sm-8">
                            <input type="text" name="catname" class="form-control" id="catname_update_input"
                                   placeholder="catname">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">age</label>
                        <div class="col-sm-8">
                            <input type="text" name="age" class="form-control" id="age_update_input" placeholder="age">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">comefrom</label>
                        <div class="col-sm-8">
                            <input type="text" name="comefrom" class="form-control" id="comefrom_update_input"
                                   placeholder="comefrom">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">tozootime</label>
                        <div class="col-sm-8">
                            <input type="date" name="tozootime" class="form-control" id="tozootime_update_input"
                                   placeholder="tozootime">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">catdescribe</label>
                        <div class="col-sm-8">
                            <input type="text" name="catdescribe" class="form-control" id="catdescribe_update_input"
                                   placeholder="catdescribe">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary edit_btn" id="cat_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>





<!-- 新增的模态框 check表示默认是在被选中状态-->
<div class="modal fade" id="catAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">动物添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">sex</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex1_add_input" value="M" checked="checked"> M
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex2_add_input" value="F"> F
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">catname</label>
                        <div class="col-sm-8">
                            <input type="text" name="catname" class="form-control" id="catname_add_input"
                                   placeholder="请输入名称">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">age</label>
                        <div class="col-sm-8">
                            <input type="text" name="age" class="form-control" id="age_add_input" placeholder="请输入年龄">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">comefrom</label>
                        <div class="col-sm-8">
                            <input type="text" name="comefrom" class="form-control" id="comefrom_add_input"
                                   placeholder="请输入来源地">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">tozootime</label>
                        <div class="col-sm-8">
                            <input type="date" name="tozootime" class="form-control" id="tozootime_add_input"
                                   placeholder="请输入到园时间">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">catdescribe</label>
                        <div class="col-sm-8">
                            <input type="text" name="catdescribe" class="form-control" id="catdescribe_add_input"
                                   placeholder="描述">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="cat_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<!--搭建显示页面-->
<form class="container">
    <!-- 显示标题，最多列为12列 -->
    <div class="row">
        <div class="col-md-12">
            <h3>猫科动物信息</h3>
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
            <button class="btn btn-primary" btn-sm id="cat_add_modal_btn">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true" style="width:16px;height:12px;"></span>
                新增
            </button>
            <button class="btn btn-danger delBatch-btn" btn-sm >
                <span class="glyphicon glyphicon-trash" aria-hidden="true" style="width:16px;height:12px;"></span>
                批量删除
            </button>

        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="cats_table" >
                <tr>
                    <th>
                        <input type="checkbox" id="check_all" class="check_item"/>
                    </th>
                    <th>编号</th>
                    <th>性别</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>来自</th>
                    <th>到园时间</th>
                    <th>外貌描述</th>
                    <th>操作</th>
                </tr>
                <%--<遍历分页里的所有数据，每一条数据都被称之为cat--%>

                <c:forEach items="${pageInfo.list}" var="cat" varStatus="status">
                    <tr>
                        <th>
                            <input type="checkbox"  class="check_item" data-name="${cat.catname}" data-id="${cat.id}"/>
                        </th>
                        <th>${status.index + 1 + (pageInfo.pageNum - 1) * 6}</th>
                        <th>${cat.sex}</th>
                        <th>${cat.catname}</th>
                        <th>${cat.age}</th>
                        <th>${cat.comefrom}</th>
                        <th>${cat.tozootime}</th>
                        <th>${cat.catdescribe}</th>
                        <th>
                            <button class="btn btn-primary btn-sm edit_btn" style="width:60px;height:32px;" edit-id="${cat.id}">编辑</button>
                            <button class="btn btn-danger btn-sm del_btn" style="width:60px;height:32px;" del-id="${cat.id}" del-catname="${cat.catname}">删除</button>
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
                    <li><a href="${APP_PATH }/cats?pn=1">首页</a></li>
                    <%--                    s上一页的连接地址，当前页码减一,如果有上一页则显示上一页图标，如果没有，例如第一页，则不显示上一页图标--%>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${APP_PATH }/cats?pn=${pageInfo.pageNum-1}"
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
                            <li><a href="${APP_PATH }/cats?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${APP_PATH }/cats?pn=${pageInfo.pageNum+1 }"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${APP_PATH }/cats?pn=${pageInfo.pages}" id="enf" onclick="checkk(${pageInfo.pageNum},${pageInfo.pages})">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</form>



<script type="application/javascript">
    function addParam(){
        var catname = $('input[name=inputData]').val();
        url = '/cats?style=tp&catname='+catname;
        window.location.href = url;
    }

    //点击新增按钮弹出模态框。
    $("#cat_add_modal_btn").click(function(){
        //弹出模态框
        $("#catAddModal").modal({
            backdrop:"static"
        });
    });

    //新增页面点击保存，即保存
    $("#cat_save_btn").click(function() {

        $.ajax({
            url:"/cat",
            type:"POST",
            data:$("#catAddModal form").serialize(),
            success:function (result) {
                // alert(result.msg);
                if(result.code == 100){
                    //1、关闭模态框
                    alert("保存成功！");
                    document.location.reload();
                    $("#catAddModal").modal('hide');

                }else{
                    if(undefined != result.extend.errorFields.catName){
                        //显示名字的错误信息
                        show_validate_msg("#catname_add_input", "error", result.extend.errorFields.catName);
                    }
                }
            }

        });

    });

    /**
     * 校验修改信息
     * @returns {boolean}
     */
    function validate_update_form(){
        //1、拿到要校验的数据，使用正则表达式
        var catName = $("#catname_update_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(catName)){
            debugger;
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            alert("名称可以是2-5位中文或者3-10位英文和数字的组合");
            return false;
        }else{
            // alert("#catname_add_input", "success", "");
            return true;
        };
    }

    //校验新增名称是否可用，给catname绑定一个change事件
    $("#catname_add_input").change(function(){
        //发送ajax请求校验名是否可用
        var catName = this.value;
        $.ajax({
            url:"${APP_PATH}/checkuser",
            data:"catName="+catName,
            type:"POST",
            success:function(result){
                if(result.code==100){
                    //alert("用户名可用！");
                    //show_validate_msg("#catname_add_input","success","名称可用");
                    $("#cat_save_btn").attr("ajax-va","success");
                }else{
                    alert(result.msg);
                    $("#cat_save_btn").attr("ajax-va","error");
                }
            }
        });
    });



    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(event){
        //2、查出动物信息
        getCat($(this).attr("edit-id"));
        //3、把动物的id传递给模态框的更新按钮
        $("#cat_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#catUpdateModal").modal({
            backdrop:"static"
        });
    });

    function getCat(id){
        $.ajax({
            url:"${APP_PATH}/cat/"+id,
            type:"GET",
            success:function(result){
                showInfo(result.extend.cat);
            }
        });
    }

    function showInfo(data) {
        document.getElementById("id_update_static").innerText = data.id
        document.getElementById("catname_update_input").value = data.catname
        document.getElementById("age_update_input").value = data.age
        document.getElementById("comefrom_update_input").value = data.comefrom
        document.getElementById("tozootime_update_input").value = data.tozootime
        document.getElementById("catdescribe_update_input").value = data.catdescribe
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

    //点击更新，更新动物信息
    $("#cat_update_btn").click(function(){
        var flag = validate_update_form();
        //2、发送ajax请求保存更新的动物数据
        if(flag){
            $.ajax({
                url:"${APP_PATH}/cat2/"+$(this).attr("edit-id"),
                type:"PUT",
                data:$("#catUpdateModal form").serialize(),
                success:function(){
                    document.location.reload();
                    //1、关闭对话框
                    $("#catUpdateModal").modal("hide");
                }
            });
        }
    });

    //删除
    $(document).on("click",".del_btn",function () {
        debugger;
        //弹出是否确认删除对话框
        var catname=$(this).attr("del-catname");
        var id=$(this).attr("del-id");
        if(confirm("确认删除【"+catname+"】吗？")){
            $.ajax({
                url:"${APP_PATH}/cat1/"+id,
                type:"DELETE",
                success:function(result){
                    document.location.reload();
                    alert(result.msg);
                }
            });
        }
    });

    //批量删除
    $(document).on("click",".delBatch-btn",function () {
        //弹出是否确认删除对话框
        var catnames="";
        var del_idstr=[];
        $.each($(".check_item:checked"),function(i,item){
            //自定义属性值的获取方法
            catnames += item.dataset.name+",";
            //组装id字符串
            del_idstr.push(item.dataset.id);
        });
        var ids = "";
        for(var i = 0;i < del_idstr.length;i++){
            ids = ids + del_idstr[i]+",";
        }
        catnames = catnames.substring(0, catnames.length-1);
        if(confirm("确认删除【"+catnames+"】吗？")){
            $.ajax({
                url:"${APP_PATH}/catDeleteBatch",
                type:"POST",
                data:{
                    ids:ids
                },
                dataType:"text",
                success:function(result){
                    alert("删除成功！");
                    document.location.reload();
                }
            });
        }
    });


    //完成全选/全不选功能
    $("#check_all").click(function(){
        //attr获取checked是undefined;
        //我们这些dom原生的属性；attr获取自定义属性的值；
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    //check_item
    $(document).on("click",".check_item",function(){
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });


</script>
</body>
</html>
