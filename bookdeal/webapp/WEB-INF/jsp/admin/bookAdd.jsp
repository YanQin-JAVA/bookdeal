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
            width:500px;
            margin-top:50px;
            margin-left:50px;
        }
    </style>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div id="app">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="分类名称">
                <el-select v-model="form.categoryId" placeholder="请选择">
                    <el-option
                            v-for="item in categorys"
                            :key="item.categoryName"
                            :label="item.categoryName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="书籍名称">
                <el-input v-model="form.bookName"></el-input>
            </el-form-item>
            <el-form-item label="书籍描述">
                <el-input type="textarea"
                          :autosize="{ minRows: 3, maxRows: 8}"
                          v-model="form.bookDesc"></el-input>
            </el-form-item>
            <el-form-item label="作者">
                <el-input v-model="form.author"></el-input>
            </el-form-item>
            <el-form-item label="出版社">
                <el-input v-model="form.publishHouse"></el-input>
            </el-form-item>
            <el-form-item label="出版时间">
                <el-date-picker
                        v-model="form.publishDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择日期">
                </el-date-picker>
            </el-date-picker>
            </el-form-item>
            <el-form-item label="价格">
                <el-input type="number" v-model="form.price"></el-input>
            </el-form-item>
            <el-form-item label="书籍编号">
                <el-input v-model="form.bookNumber"></el-input>
            </el-form-item>
            <el-form-item label="内容描述">
                <el-input type="textarea"
                          :autosize="{ minRows: 3, maxRows: 8}"
                        v-model="form.contentDesc"></el-input>
            </el-form-item>
            <el-form-item label="作者描述">
                <el-input type="textarea"
                          :autosize="{ minRows: 3, maxRows: 8}"
                        v-model="form.authorDesc"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">保存</el-button>
            </el-form-item>
        </el-form>
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data() {
            return {
                categorys:[],
                form:{
                    categoryId:'',
                    bookName:'',
                    bookDesc:'',
                    author:'',
                    publishHouse:'',
                    publishDate:'',
                    price:'',
                    bookNumber:'',
                    contentDesc:'',
                    authorDesc:''
                }
            }
        },
        mounted() {
            this.list();
            nav._data.activeIndex = '3-2'
        },
        methods: {
            onSubmit() {
                var that = this;

                $.ajax({
                    url:'../book/add',
                    type:'post',
                    contentType:'application/json;charset=UTF-8',
                    data:JSON.stringify(that.form),
                    success:function(result){
                        that.$message(result.msg);
                    }
                });
            },
            list() {
                var that = this;

                $.ajax({
                    url:'../bookCategory/list',
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            that.categorys = result.data;
                        }
                    }
                });
            }
        }
    })
</script>
</html>
