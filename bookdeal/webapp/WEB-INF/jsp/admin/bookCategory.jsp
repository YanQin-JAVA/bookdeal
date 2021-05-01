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
            width:800px;
            margin-top:50px;
            margin-left:50px;
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
                        label="类别ID"
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
                        width="300">
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
            nav._data.activeIndex = '2-1'
        },
        methods: {
            list() {
                var that = this;

                $.ajax({
                    url:'../bookCategory/list',
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
