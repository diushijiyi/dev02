<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/user/testServlet">
  <table align="center">
    <tr>
      <td>用户名</td>
      <td><input type="text" name="userInfos[0].username"></td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input type="text" name="userInfos[0].password"></td>
    </tr>
    <tr>
      <td>姓名</td>
      <td><input type="text" name="userMap['user1'].user.name"></td>
    </tr>
    <tr>
      <td>年龄</td>
      <td><input type="text" name="userMap['user1'].user.age"></td>
    </tr>
    <tr>
      <td>性别</td>
      <td>
        <input type="radio" name="userMap['user1'].user.gender">男
        <input type="radio" name="userMap['user1'].user.gender">女
      </td>
    </tr>
    <tr>
      <td>备注</td>
      <td><input type="text" name="userMap['user1'].user.info"></td>
    </tr>
    <tr>
      <td>日期</td>
      <td><input type="date" name="userMap['user1'].user.birthday"></td>
    </tr>
    <tr>
      <td><input type="reset" value="重置"></td>
      <td><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>