<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>jQuery/CSS3分步骤注册表单切换动画在线演示</title>
    <link rel="stylesheet" media="screen" href="/templates/default/style/login.css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">保利玉品</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="#">新增商品</a></li>
                <li><a href="#">商品列表</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="nav navbar-nav pull-right">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/login.html">登录</a></li>
                <li><a href="/static/manager/register.html">注册</a></li>
                <!--<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>-->
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <form id="msform" action="/manager/login" method="post">
<!--        &lt;!&ndash; progressbar &ndash;&gt;
        <ul id="progressbar">
            <li class="active">Account Setup</li>
            <li>Social Profiles</li>
            <li>Personal Details</li>
        </ul>-->
        <!-- fieldsets -->
        <fieldset>
            <h2 class="fs-title">Sign In your account</h2>
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name="password" placeholder="Password"/>
            <input type="submit" name="submit" class="next action-button" value="Sign In"/>
        </fieldset>
    </form>
    <script src="/templates/default/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/templates/default/js/jquery.easing.min.js" type="text/javascript"></script>
    <script src="/templates/default/js/jQuery.time.js" type="text/javascript"></script>
    <br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br>
</div>

    <script>
        $(function () {

            $("button").click(function () {
                var result = $("#msform").submit;
                alert(result);
            })

        })
    </script>


</body>
</html>