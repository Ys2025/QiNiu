<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>2025-图床</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
    <ul class="layui-nav" lay-filter="" style="text-align: center">
        <li class="layui-nav-item layui-this"><a href="javascript:;">七牛云-图床</a></li>
    </ul>
    <div class="layui-container">
        <div class="layui-row"  style="margin-top: 50px">
            <div class="layui-col-md5" style="text-align: center">
                <img src="http://images.yanghuisen.cn/FrSM1F9XlcU8Jmu06BiqG6dAEXZv" alt="" style="width: 100%">
            </div>
            <div class="layui-col-md6" align="center" style="margin-left: 10px;margin-top: 10px;margin-bottom: 20px">
                <button type="button" class="layui-btn" id="uploadImage">
                    <i class="layui-icon">&#xe67c;</i>上传图片
                </button>
                <table class="layui-table">
                    <tbody>
                    <tr>
                        <td id="fileName">请先上传图片</td>
                    </tr>
                    <tr>
                        <td><a href="#" id="downloadUrl" target="_blank">点击下载图片</a></td>
                    </tr>
                    <tr>
                        <td id="htmlCode">点击显示HTML版本代码</td>
                    </tr>
                    <tr>
                        <td id="markdownCode">点击显示Markdown版本代码</td>
                    </tr>
                    </tbody>
                </table>
                <textarea name="desc" placeholder="..." class="layui-textarea"></textarea>
            </div>
        </div>
    </div>

<script>
    layui.use(['element','upload'], function(){
        var element = layui.element;
        var layer = layui.layer;
        var upload = layui.upload;
        var $ = layui.jquery;
        var url;
        var uploadInst = upload.render({
            elem: '#uploadImage' //绑定元素
            ,url: 'upload' //上传接口
            ,done: function(res) {
                if (res.code !== 200) {
                    layer.msg(res.msg);
                } else {
                    // 获取key
                    var key = res.data.key;
                    // 拼接文件地址
                    url = "http://images.yanghuisen.cn/" + key;
                    // 设置图片显示的文件
                    $("img").attr("src", url);
                    // 设置表的文件文件名
                    $("#fileName").html(res.data.key);
                    // 设置下载地址
                    $("#downloadUrl").attr("href", url);
                    // 设置默认显示markdown代码
                    $("textarea").html("![](" + url + ")");
                }
            }
        });

        $("#htmlCode").click(function () {
            $("textarea").html("<img src='"+url+"' alt=''>");
        });
        $("#markdownCode").click(function () {
            $("textarea").html("![]("+url+")");
        })

    });
</script>
</body>
</html>