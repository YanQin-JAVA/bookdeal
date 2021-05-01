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
            margin-top:50px;
        }
        #app p{
            margin-bottom:10px;
        }
        #app p span{
            display: inline-block;
            width:80px;
            color:#888;
        }
    </style>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div id="app">
        <p><span>书籍名称：</span>{{book.bookName}}</p>
        <p><span>分类名称：</span>{{book.categoryName}}</p>
        <p><span>书籍描述：</span>{{book.bookDesc}}</p>
        <p><span>作者：</span>{{book.author}}</p>
        <p><span>出版社：</span>{{book.publishHouse}}</p>
        <p><span>出版时间：</span>{{book.publishDate}}</p>
        <p><span>价格：</span>{{book.price}}元</p>
        <p><span>编号：</span>{{book.bookNumber}}</p>
        <p><span>内容描述：</span>{{book.contentDesc}}</p>
        <p><span>作者描述：</span>{{book.authorDesc}}</p>
        <el-button @click="addorder()" type="primary">购买</el-button>
    </div>
</body>
<script>
    var id = '${id}';
    var app = new Vue({
        el: '#app',
        data() {
            return {
                book:{},
                order:{}
            }
        },
        mounted() {
            this.select();
            nav._data.activeIndex = '1'
        },
        methods: {
            select() {
                var that = this;
                $.ajax({
                    url:'../book/getbook?id='+id,
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            console.log(result.data);
                            that.book = result.data[0];
                        }
                    }
                });
            },
            addorder(){
                var that = this;
                this.order.bookId = this.book.id;
                this.order.totalPrice = this.book.price;

                $.ajax({
                    url:'../order/add',
                    type:'post',
                    contentType:'application/json;charset=UTF-8',
                    data:JSON.stringify(that.order),
                    success:function (result){
                        location.href='../user/order'
                    }
                });
            }
        }
    })
</script>
</html>
