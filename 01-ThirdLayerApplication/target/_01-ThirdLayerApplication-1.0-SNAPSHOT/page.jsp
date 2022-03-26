<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2022/3/3
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询学生</title>
    <style>
        #t3{
            height: 200px;
            border: 1px solid black;
            border-radius: 10px;
            background-color: white;
            opacity: 0.5;
        }
        body{
            margin: 0 auto;
            height: 600px;
            background-repeat: no-repeat;
            background-size:cover;

            background-position: center;
            background-attachment: fixed;
        }

        input{
            border-radius: 15px;
        }
        a{
            text-decoration: none;
            color: pink;
        }
        a:hover{
            color: darkorange;
        }
        #i1{height: 50px;background-color: black;}
        #t1{
            color: white;
            height: 50px;
        }
        #t1 td,#t2 td{
            width: 100px;}
        #t2{
            height: 50px;
            color: white;
            float: right;
            margin-top: -50px;}
    </style>
</head>
<body>
<div id="i1">
    <table>
        <tr id="t1">
            <td>首页</td>
            <td>消息</td>
        </tr>
    </table>
    <table id="t2">
        <tr>
            <td id="username" oninput="ulogin()">gpy</td>
            <td><a href="login.html">退出登录</a></td>
        </tr>
    </table>
</div>
<table align="center" border="1px" id="t3">
    <caption><h1 style="color: pink">查询学生</h1></caption>
    <%--    <tr>--%>
    <%--        <td>请输入您要查询的人的姓名</td>--%>
    <%--        <td><input type="text" name="name" id="name"></td>--%>
    <%--        <td><input type="submit" value="提交"  onclick="getStudent()"></td>--%>
    <%--    </tr>--%>
    <tr>
        <td><input type="checkbox"></td>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>信息</td>
        <td>操作</td>
    </tr>

    <%--    <c:if test="${empty list}">--%>
    <%--        <tr>--%>
    <%--            <td colspan="6" align="center">暂无数据</td>--%>
    <%--        </tr>--%>
    <%--    </c:if>--%>

    <%--    <c:if test="${not empty list}">--%>
    <c:forEach var="student" items="${pageInfo.list}">
        <tr align="center">
            <td><input type="checkbox"></td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
            <td>${student.info}</td>
            <td>
                <a href="jspSelect?id=${student.id}">修改</a>
                <a id="id${student.id}" onmouseover="over(${student.id})" onmouseout="out(${student.id})" onclick="del(${student.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
    <%--    </c:if>--%>
    <tr>
        <td colspan="6" align="center">
            <a href="update.jsp">添加学生</a>
        </td>
    </tr>
    <%--    <tr>--%>
    <%--        <td colspan="6" align="center">--%>
    <%--            <a href="login.html">退出登录</a>--%>
    <%--        </td>--%>
    <%--    </tr>--%>
</table>
<%--form表单用来提交页码--%>
<form action="page" method="get">
    <table align="right">
        <tr>
            <%--如果当前页为第一页，则首页和上一页设置无法选中--%>
            <c:if test="${pageInfo.pageNo == 1}">
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">首页</a></td>
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">上一页</a></td>
            </c:if>

            <%--如果当前不为第一页--%>
            <c:if test="${pageInfo.pageNo != 1}">
                <%--设置首页直接跳转为第一页，传递pageNo为1--%>
                <td><a href="page?pageNo=1" style="text-decoration: none">首页</a></td>
                <%--设置上一页，传递pageNo为 当前页 - 1--%>
                <td><a href="page?pageNo=${pageInfo.pageNo - 1}" style="text-decoration: none">上一页</a></td>
            </c:if>

            <%--遍历当前页数--%>
            <c:forEach var="pageNo" varStatus="pageStatus" begin="1" end="${pageInfo.pageCount}">
                <%--如果是当前页，就设置不可点击--%>
                <c:if test="${pageNo == pageInfo.pageNo}">
                    <td><input type="submit" name="pageNo" value="${pageNo}" disabled></td>
                </c:if>

                <%--非当前页设置可点击--%>
                <c:if test="${pageNo != pageInfo.pageNo}">
                    <td><input type="submit" name="pageNo" value="${pageNo}"></td>
                </c:if>
            </c:forEach>

            <%--如果当前页为最后一页，则尾页和下一页设置无法选中--%>
            <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">下一页</a></td>
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">尾页</a></td>
            </c:if>

            <%--如果当前不为最后一页--%>
            <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                <%--设置下一页，传递pageNo为 当前页 + 1--%>
                <td><a href="page?pageNo=${pageInfo.pageNo + 1}" style="text-decoration: none">下一页</a></td>
                <%--设置尾页直接跳转为最后一页，传递pageNo为总页数--%>
                <td><a href="page?pageNo=${pageInfo.pageCount}" style="text-decoration: none">尾页</a></td>
            </c:if>

            <%--从分页信息中获取数据总数和总页数--%>
            <td>共${pageInfo.totalCount}条内容，共${pageInfo.pageCount}页</td>
        </tr>
    </table>
</form>

</body>
<script>
    function ulogin(){
        var username = $("#username").val();
        $.ajax({
            url: "index",
            type: "GET",
            data: {"username": username},
            success: function (data) {
                username=session.getAttribute("username");
            }
        })
    }
    function getStudent(){
        var name = $("#name").val();
        $.ajax({
            url: "selectStudent",
            type: "POST",
            data: {"name": name},
            success: function (data) {
                if (data === "true") {
                    window.location.href='selectStudent?name='+name;
                }
            }
        })
    }
    function del(id) {
        if (confirm('是否确认删除？') === true) {
            window.location.href = 'jspDelete?id=' + id;
        }
    }

    function over(id) {
        var a = document.getElementById('id' + id);

        a.style.color = 'red';
        a.style.cursor = 'pointer';
    }

    function out(id) {
        var a = document.getElementById('id' + id);

        a.style.color = 'black';
    }
</script>
</html>
