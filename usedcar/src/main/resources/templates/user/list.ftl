<!DOCTYPE html>
<html lang="en">
<#--头部文件-->
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

                    <form action="/goToQuery">
                        <div class="input-group col-md-3" style="margin-bottom:20px">
                            <input type="text" name="queryName" class="form-control"placeholder="请输入姓名" / >
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-info btn-search">查找</button>
                        </span>
                        </div>
                    </form>

                    <table class="table table-bordered table-condensed text-center">
                        <thead>
                        <tr >
                            <th class="text-center">电话号码</th>
                            <th class="text-center">密码</th>
                            <th class="text-center">昵称</th>
                            <th class="text-center">居住地</th>
                            <th class="text-center">学院</th>
                            <th class="text-center">专业</th>
                            <th class="text-center">年级</th>
                            <th class="text-center">账户余额</th>
                            <th class="text-center">所在苑区</th>
                            <th class="text-center">信誉度</th>
                            <th colspan="2" class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list userPage.content as users>
                        <tr>
                            <td>
                                <#if users.telenum??>
                                    ${users.telenum}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.password??>
                                    ${users.password}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <#--<td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>-->
                            <td>
                                <#if users.nickname??>
                                    ${users.nickname}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.dwells??>
                                    ${users.dwells}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.college??>
                                    ${users.college}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.major??>
                                    ${users.major}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.grade??>
                                    ${users.grade}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.balance??>
                                    ${users.balance}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.dormitory??>
                                    ${users.dormitory}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if users.infoIntegrity??>
                                    ${users.infoIntegrity}
                                <#else>
                                    null
                                </#if>
                            </td>

                            <td><a href="/updateUserBytel?telNum=${users.telenum}">修改信誉度</a></td>
                            <td><a href="/deleteByTel?telNum=${users.telenum}">删除</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/userlist?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/userlist?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/userlist?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>