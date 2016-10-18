<%--
  Created by IntelliJ IDEA.
  User: qiutian
  Date: 16-8-30
  Time: 上午2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript"  src="jquery3.js" ></script>
  </head>
  <body>
  <script type="text/javascript">
    function test(){
      $.ajax({
        type: "POST",
        url: "abc/json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({name:"仇恬",age:30,address:"南京东路2006弄"}),
        dataType: "json",
        success: function (message) {
          //if (message > 0) {
            alert("请求已提交！我们会尽快与您取得联系"+JSON.stringify(message));
          //}
        },
        error: function (message) {
          alert("Error:"+message.toString());
          //$("#request-process-patent").html("提交数据失败！");
        }
      });
    }
    test();
  </script>
  Welcome to My home!
  </body>
</html>
