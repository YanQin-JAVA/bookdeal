<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/3
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="../common.jsp"%>
    <style type="text/css">
        #app{
            width:2500px;
            margin-top:50px;
        }
    </style>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div id="app">
        <template>
            <el-table
                    :data="tableData"
                    style="width: 100%">
                <el-table-column
                        prop="id"
                        label="图书ID"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="createDate"
                        label="添加时间"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="categoryName"
                        label="类别名称"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="bookName"
                        label="图书名称"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="bookDesc"
                        label="图书描述"
                        width="400">
                </el-table-column>
                <el-table-column
                        prop="author"
                        label="作者"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="publishHouse"
                        label="出版社"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="publishDate"
                        label="出版时间"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="价格"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="bookNumber"
                        label="图书编号"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="contentDesc"
                        label="内容描述"
                        width="600">
                </el-table-column>
                <el-table-column
                        prop="authorDesc"
                        label="作者描述"
                        width="400">
                </el-table-column>
            </el-table>
        </template>
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data() {
            return {
                tableData: []
            }
        },
        mounted() {
            this.list();
            nav._data.activeIndex = '3-1'
        },
        methods: {
            list() {
                var that = this;

                $.ajax({
                    url:'../book/list',
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            console.log(result.data);
                            that.tableData = result.data;
                        }
                    }
                });
            }
        }
    })
</script>
</html>
