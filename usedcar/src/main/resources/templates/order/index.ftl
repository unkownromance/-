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
                    <h3>${name}买到的东西</h3>
                    <table class="table table-bordered table-condensed text-center">
                        <thead>
                        <tr>
                            <th class="text-center">商品id</th>
                            <th class="text-center">价格</th>
                            <th class="text-center">一级分类</th>
                            <th class="text-center">二级分类</th>
                            <th class="text-center">所有者</th>
                            <th class="text-center">被收藏数</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list buyList as good>
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

                        </tr>
                        </#list>
                        </tbody>
                    </table>


                    <h3>${name}卖出的东西</h3>
                    <table class="table table-bordered table-condensed text-center">
                        <thead>
                        <tr>
                            <th class="text-center">商品id</th>
                            <th class="text-center">价格</th>
                            <th class="text-center">一级分类</th>
                            <th class="text-center">二级分类</th>
                            <th class="text-center">所有者</th>
                            <th class="text-center">被收藏数</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list sellList as good>
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

                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>