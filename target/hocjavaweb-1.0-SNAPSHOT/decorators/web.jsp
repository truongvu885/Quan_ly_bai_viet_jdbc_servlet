
<%@ include file="../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><dec:title default="Trang chủ"/></title>
  <link rel="icon" type="image/x-icon" href="<c:url value="/templates/web/homePage/assets/favicon.ico"/>" />
  <!-- Bootstrap icons-->
  <link href="<c:url
          value="https://cdn.jsdelivr.net/npm/bootstrap-ic ons@1.5.0/font/bootstrap-icons.css"/>" rel="stylesheet" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="<c:url value="/templates/web/homePage/css/styles.css"/>" rel="stylesheet" />
  </head>
  <body>

  <!-- header-->
  <%@ include file="../common/web/header.jsp"%>
  <!-- header-->

  <div class="wrapper">
  <dec:body />
  </div>
  <!--footer-->
  <%@ include file="../common/web/footer.jsp"%>
  <!--footer-->
  
  <!-- Bootstrap core JS-->
  <script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"/>"></script>
  <!-- Core theme JS-->
  <script src="<c:url value="/templates/web/homePage/js/scripts.js"/>"></script>
  </body>
</html>
