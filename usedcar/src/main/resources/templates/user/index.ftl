<html>
<#include "../common/head.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/saveUpdate">
                        <div class="form-group" >
                            <h2>
                                <label>电话号码(主键)：</label>
                                <label>${(user.telenum)}</label>
                            </h2>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(user.password)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>昵称</label>
                            <input name="nickname" type="text" class="form-control" value="${(user.nickname)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>账户余额</label>
                            <input name="balance" type="text" class="form-control" value="${(user.balance)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>信誉度</label>
                            <input name="infoIntegrity" type="text" class="form-control" value="${(user.infoIntegrity)!''}"/>
                        </div>


                        <input hidden type="text" name="telenum" value="${(user.telenum)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>