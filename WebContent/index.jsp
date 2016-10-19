<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IP Positioning</title>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<script type="text/javascript">
    $(document).ready(function() {
      $.ajax({
        url : "/ip-positioning/getIP",
        dataType : "text",
        method : "get",
        success : function(data) {
          alert("IP: " + data);
        },
        error : function() {
          alert("get ip failed.");
        }
      });
    });
  </script>
</body>
</html>