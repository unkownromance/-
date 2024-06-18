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
                    <table class="table table-bordered table-condensed text-center">
                        <thead>
                        <tr>
                            <th class="text-center">订单id</th>
                            <th class="text-center">买家</th>
                            <th class="text-center">交易日期</th>
                            <th class="text-center">描述</th>
                            <th class="text-center">商品id</th>
                            <th class="text-center">金额</th>
                            <th class="text-center">卖家</th>
                            <th class="text-center">state</th>
                            <th class="text-center">订单状态</th>
                            <th colspan="2" class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list orderPage.content as order>
                        <tr>
                            <td>
                                <#if order.orderid??>
                                    ${order.orderid}
                                <#else>
                                    null
                                </#if>
                            </td>

                            <td>
                                <#if order.buyer??>
                                    <a href="/whatBuyAndSold?name=${order.buyer}">${order.buyer}</a>
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if order.date??>
                                    ${order.date}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if order.description??>
                                    ${order.description}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if order.goodnum??>
                                    ${order.goodnum}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if order.price??>
                                    ${order.price}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if order.seller??>
                                    <a href="/whatBuyAndSold?name=${order.seller}">${order.seller}</a>
                                <#else>
                                    null
                                </#if>
                            </td>

                            <td>
                                <#if order.state??>
                                    ${order.state}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                 <#if order.state??>
                                    <#if order.state == 1>
                                        <a href="#">买家已支付</a>
                                    <#elseif order.state == 2>
                                        <a href="#">等待线下交易</a>
                                    <#elseif order.state == 3>
                                        <a href="#">卖家拒绝交易</a>
                                    <#elseif order.state == 5>
                                        <a href="#">卖家取消订单</a>
                                    <#else>
                                        <a href="#">交易成功</a>
                                    </#if>
                                 <#else>
                                    null
                                 </#if>
                            </td>

                            <td>
                                <a href="/delOrder?orderId=${order.orderid}">删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/orderlist?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..orderPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/orderlist?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte orderPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/orderlist?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>