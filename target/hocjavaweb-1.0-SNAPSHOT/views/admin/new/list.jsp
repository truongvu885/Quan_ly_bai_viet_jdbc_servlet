<%--
  Created by IntelliJ IDEA.
  User: Truon
  Date: 5/17/2022
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <title>Danh sách bài viết</title>
</head>

<body>
  <form action="<c:url value="/admin-new"/>" id="formSubmit" method="get" class="main-content">
    <div >
      <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
          <script type="text/javascript">
            try {
              ace.settings.check('breadcrumbs', 'fixed')
            } catch (e) {}
          </script>

          <ul class="breadcrumb">
            <li>
              <i class="ace-icon fa fa-home home-icon"></i>
              <a href="#">Home</a>
            </li>
            <li class="active">Dashboard</li>
          </ul><!-- /.breadcrumb -->

          <div class="nav-search" id="nav-search">
            <form class="form-search">
              <span class="input-icon">
                <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input"
                  autocomplete="off" />
                <i class="ace-icon fa fa-search nav-search-icon"></i>
              </span>
            </form>
          </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
          <div class="row">
            <div class="col-xs-12">
              <div class="row">
                <div class="col-xs-12">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="">
                      <thead>
                        <tr>
                          <th>Tên bài viết</th>
                          <th>Mô tả ngắn</th>
                        </tr>
                      </thead>
                      <tbody>

                        <c:forEach var="item" items="${model.listResult}">
                          <tr>
                            <td>${item.title}</td>
                            <td>${item.sort_descri}</td>
                          </tr>
                        </c:forEach>

                      </tbody>
                    </table>
                    <ul class="pagination d-flex justify-content-center fs-15" style="font-size: 1.5rem"
                      id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page" />
                    <input type="hidden" name="maxPageItem" id="maxPageItem" value="" />
                    <input type="hidden" name="sortName" value="" id="sortName">
                    <input type="hidden" name="sortBy" value="" id="sortBy">
                  </div>
                </div>
              </div>
            </div><!-- /.col -->
          </div><!-- /.row -->
        </div><!-- /.page-content -->
      </div>
    </div><!-- /.main-content -->
  </form>
  <script type="text/javascript">
    var totalPage = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 2;
    $(function () {
      window.pagObj = $('#pagination').twbsPagination({
        totalPages: totalPage,
        visiblePages: 10,
        startPage: currentPage,
        onPageClick: function (event, page) {
          //console.info(page + ' (from options)');
          if (currentPage != page) {
            $('#maxPageItem').val(limit);
            $('#page').val(page);
            $('#sortName').val('title');
            $('#sortBy').val('desc');
            $('#formSubmit').submit();
          }
        }
      });
    });
  </script>
</body>

</html>