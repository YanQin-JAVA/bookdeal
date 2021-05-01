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
            <el-form-item label="用户名">
                <el-input v-model="form.userid"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码">
                <el-input type="password" v-model="form.password2"></el-input>
            </el-form-item>
            <el-form-item label="收货地址">
                <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item label="手机号">
                <el-input v-model="form.mobile"></el-input>
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
                form:{

                }
            }
        },
        mounted() {
            nav._data.activeIndex = '4-2'
        },
        methods: {
            onSubmit() {
                var that = this;

                $.ajax({
                    url:'../user/add',
                    type:'post',
                    contentType:'application/json;charset=UTF-8',
                    data:JSON.stringify(that.form),
                    success:function(result){
                        that.$message(result.msg);
                    }
                });
            }
        }
    })
</script>
</html>
