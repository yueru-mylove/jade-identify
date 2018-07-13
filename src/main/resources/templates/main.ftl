<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>

        table {
            text-align: center;
            border-width: 0px;
            padding: 0px;
            border-collapse: collapse;
        }

        table tr {
            text-align: center;
        }

        tr td {
            width: 500px;
            height: auto;
            vertical-align: middle;
        }


    </style>

</head>
<body>

<div id="main" name="main">
    <div>
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">保利玉品</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="navbar-item"><a href="#">新增商品</a></li>
                        <li class="navbar-item"><a href="#">商品列表</a></li>
                        <li class="dropdown navbar-item">
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
                <div class="pull-right">
                    <ul class="nav navbar-nav">
                        <li class="success"><a href="/login.html">登录</a></li>
                        <li class="success"><a href="/static/manager/register.html">注册</a></li>
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
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">编号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="born" class="col-sm-2 control-label">年代</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="born" name="born" placeholder="请输入年代">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inch" class="col-sm-2 control-label">尺寸</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inch" name="inch" placeholder="请输入尺寸（5*10）">
                    </div>
                </div>
                <div class="form-group">
                    <label for="value" class="col-sm-2 control-label">价值</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="value" name="value" placeholder="请输入价值">
                    </div>
                </div>
                <div class="form-group">
                    <label for="source" class="col-sm-2 control-label">图片</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" id="source" name="source" placeholder="请选择图片">
                    </div>
                </div>
                <!--<div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">请记住我
                            </label>
                        </div>
                    </div>
                </div>-->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="submit" class="btn btn-success">添加</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript" src="/templates/default/js/jquery-1.8.0.min.js"/>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script>
    $(function () {

        var filePath = {};
        var fileName = {};


        $("#source").change(function () {
            var file = this.files[0];
            if (window.FileReader) {
                var reader = new FileReader();
                reader.readAsDataURL(file);
                //监听文件读取结束后事件
                reader.onloadend = function (e) {
                    alert(e.target.result);
                }
            }
            var checkResult = verificationPicFile(file);
            if (checkResult) {
                alert(checkResult);
            }


        })

        $("#submit").click(function() {

        })

        function verificationPicFile(file) {
            var fileTypes = [".jpg", ".png"];
            var filePath = file.value;
            //当括号里面的值为0、空字符、false 、null 、undefined的时候就相当于false
            if(filePath){
                var isNext = false;
                var fileEnd = filePath.substring(filePath.indexOf("."));
                for (var i = 0; i < fileTypes.length; i++) {
                    if (fileTypes[i] == fileEnd) {
                        isNext = true;
                        break;
                    }
                }
                if (!isNext){
                    alert('不接受此文件类型');
                    file.value = "";
                    return false;
                }
            }else {
                return false;
            }
        }


    })
</script>

</body>
</html>