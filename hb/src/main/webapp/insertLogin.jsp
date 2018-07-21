<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>注册账户</title>
    <link rel="stylesheet" href="./js/layui/css/layui.css" media="all">
    <script src="./js/layui/layui.js"></script>
    <script src="./js/jquery.js"></script>
    <script src="./js/global.js"></script>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>注册用户</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">账户名</label>
            <div class="layui-input-inline">
                <input type="text" name="loginName" lay-verify="required|inputName" autocomplete="off"
                       placeholder="您登录所需的账户" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="loginPwd" id="pwd1" lay-verify="required|inputPwd" autocomplete="off"
                       placeholder="您登录所需的密码" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" id="pwd2" lay-verify="required|inputPwd" autocomplete="off"
                       placeholder="重复你所输入的密码" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="loginNickName" lay-verify="required|inputName" autocomplete="off"
                       placeholder="您的个性昵称" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="insertRome">注册</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            inputName: function (value) {
                if (value.length < 4) {
                    return '账户至少4个字符';
                }

                if (value.length > 10) {
                    return '账户至多10个字符'
                }
            },
            inputPwd: function (value) {
                if (value.length < 4) {
                    return '密码至少4个字符';
                }

                if (value.length > 18) {
                    return '密码至多18个字符'
                }
            }
        });

        //监听提交
        form.on('submit(insertRome)', function (data) {

            var pwd1 = $("#pwd1").val();
            var pwd2 = $("#pwd2").val();

            if (pwd1 != pwd2) {
                layer.msg("二次密码验证不一致");
            } else {

                $.ajax({
                    timeout: 6000,
                    type: "POST",
                    url: baseUrl + "/LoginController/insertLogin.do",
                    data: JSON.stringify(data.field),
                    success: function (data) {
                        if (data == "ok") {
                            layer.msg("插入成功", {
                                anim: 4
                            });
                        } else if (data == "1") {
                            layer.msg("已存在的用户名", {
                                anim: 6
                            });
                        } else {
                            layer.msg("插入失败", {
                                anim: 6
                            });
                        }
                    },
                    error: function () {
                        layer.msg("请求失败", {
                            anim: 6
                        });
                    }
                });
            }

            return false;
        });
    });
</script>
</body>

</html>