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
                            <th class="text-center">商品id</th>
                            <th class="text-center">价格</th>
                            <th class="text-center">一级分类</th>
                            <th class="text-center">二级分类</th>
                            <th class="text-center">状态</th>
                            <th class="text-center">所有者</th>
                            <th class="text-center">被收藏数</th>
                            <th colspan="2" class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list goodsPage.content as good>
                        <tr>
                            <td>
                                <#if good.goodNum??>
                                    ${good.goodNum}
                                <#else>
                                    null
                                </#if>
                            </td>

                            <td>
                                <#if good.price??>
                                    ${good.price}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.summaryClassifyname??>
                                    ${good.summaryClassifyname}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.detailClassifyname??>
                                    ${good.detailClassifyname}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.state??>
                                    ${good.state}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.owner??>
                                    ${good.owner}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.starCount??>
                                    ${good.starCount}
                                <#else>
                                    null
                                </#if>
                            </td>
                            <td>
                                <#if good.state == 1>
                                    <a href="/soldOut?goodsnum=${good.goodNum}">下架</a>
                                <#elseif good.state == 2>
                                    <a href="/putAway?goodsnum=${good.goodNum}">上架</a>
                                <#else>
                                    <label>已售出</label>
                                </#if>
                                <#--<#if productInfo.getProductStatusEnum().message == "在架">-->
                                    <#--<a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>-->
                                <#--<#else>-->
                                    <#--<a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>-->
                                <#--</#if>-->
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
                        <li><a href="/goodlist?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..goodsPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/goodlist?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte goodsPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/goodlist?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>