<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="common.jsp" %>
    <style type="text/css">
        .form-div{
            position: absolute;
            width:450px;
            height: 200px;
            top:0;
            left: 0;
            right: 0;
            bottom: 0;
            margin:auto;
            z-index: 99;
            background:#f0f0f0;
            opacity: 1;
        }
        .inner-form-div{
            background: #f0f0f0;
            width: 400px;
            height: 150px;
            margin-top:25px;
        }
        .register{
            float:right;
        }


        .el-carousel__item h3 {
            color: #475669;
            font-size: 18px;
            opacity: 0.75;
            line-height: 300px;
            margin: 0;
        }

        .el-carousel__item:nth-child(2n) {
            background-color: #99a9bf;
        }

        .el-carousel__item:nth-child(2n+1) {
            background-color: #d3dce6;
        }
    </style>
<body>
<div id="app">

    <template>
        <el-carousel
                :height="screenHeight"
                arrow="never"
                indicator-position="none">
            <el-carousel-item v-for="item in imgUrls" :key="item">
                <div class="image">
                    <el-image
                            style="width: 100%; height: 100%"
                            :src="item"
                            ></el-image>
                </div>
            </el-carousel-item>
        </el-carousel>
    </template>

    <div class="form-div">
        <div class="inner-form-div">
        <el-form ref="user" :model="user" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="user.userid"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="user.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-link class="register" href="register" type="primary">注册</el-link>

            </el-form-item>
        </el-form>
        </div>
    </div>
</div>
</body>

<script>
    var app = new Vue({
        el: '#app',
        data() {
            return {
                screenHeight: '',
                imgUrls: ['../img/1.jpg','../img/2.jpg','../img/3.jpg','../img/4.jpg'],
                user: {
                    userid: '',
                    password: ''
                }
            }
        },
        mounted() {
            this.screenHeight = window.innerHeight + 'px';
        },
        methods: {
            onSubmit() {
                var that = this;

                $.ajax({
                    url:'../login/login',
                    type:'post',
                    contentType:'application/json;charset=UTF-8',
                    data:JSON.stringify(that.user),
                    success:function(result){
                        if(result.code == 0){
                            location.href = '../user/book'
                        }else{
                            that.$message(result.msg);
                        }
                    }
                });
            }
        }
    })
</script>
</html>