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
    <%@include file="common.jsp"%>
    <style type="text/css">
        #app{
            width:1200px;
            margin-left:50px;
        }
    </style>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div id="app">
        <el-container>
            <el-header>
                <br/>
                <div style="width:500px;">
                    <el-input v-model="like" placeholder="search">
                        <el-button @click="list()" slot="append" icon="el-icon-search"></el-button>
                    </el-input>
                </div>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <br/>
                    <p cateid=""><el-link @click="selcate('')" type="primary">全部分类</el-link></p>
                    <p v-for="i in categorys" :cateid="i.id"><el-link @click="selcate(i.id)" type="primary">{{i.categoryName}}</el-link></p>
                </el-aside>
                <el-main>

                    <template>
                        <el-table
                                :data="tableData"
                                style="width: 100%">
                            <el-table-column
<%--                                    prop="bookName"--%>
                                    label="图书名称"
                                    width="300">
                                <template slot-scope="scope">
                                    <el-link
                                       :href="'bookdetail?id='+scope.row.id"
                                       >{{scope.row.bookName}}</el-link>
                                </template>
                            </el-table-column>
                            <el-table-column
                                    prop="author"
                                    label="作者"
                                    width="150">
                            </el-table-column>
                            <el-table-column
                                    prop="publishHouse"
                                    label="出版社"
                                    width="150">
                            </el-table-column>

                            <el-table-column
                                    prop="price"
                                    label="价格"
                                    width="100">
                            </el-table-column>
                            <el-table-column
                                    prop="bookNumber"
                                    label="图书编号"
                                    width="150">
                            </el-table-column>
                        </el-table>
                    </template>
                </el-main>
            </el-container>
        </el-container>
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data() {
            return {
                tableData: [],
                categorys:[],
                cateid:'',
                like:''
            }
        },
        mounted() {
            this.cate();
            this.list();
            nav._data.activeIndex = '1'
        },
        methods: {
            list() {
                var that = this;
                $.ajax({
                    url:'../book/list?cateid='+that.cateid+"&like="+that.like,
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            console.log(result.data);
                            that.tableData = result.data;
                        }
                    }
                });
            },
            selcate(id){
              this.cateid = id;
              this.list();
            },
            cate() {
                var that = this;

                $.ajax({
                    url:'../bookCategory/list',
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            console.log(result.data);
                            that.categorys = result.data;
                        }
                    }
                });
            },
        }
    })
</script>
</html>
