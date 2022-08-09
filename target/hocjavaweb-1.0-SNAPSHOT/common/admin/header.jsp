<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#">
                        <img class="nav-user-photo" src="<c:url value="/templates/admin/assets/avatars/user.jpg"/>" alt="Jason's Photo" />
                        <span class="user-info">
									<small>Welcome,</small>
									${USERMODEL.fullName}
								</span>
                    </a>
                </li>
                <li class="light-blue">
                    <a style="color: white;font-size: 1.2rem" href="<c:url value="/thoat?action=logout"/>">Thoát</a>
                </li>
            </ul>
        </div>
    </div><!-- /.navbar-container -->
</div>