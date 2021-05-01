<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/3
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div id="nav">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">

        <el-menu-item index="1">首页</el-menu-item>
        <el-submenu index="2">
            <template slot="title">图书类别管理</template>
            <el-menu-item index="2-1">图书类别列表</el-menu-item>
            <el-menu-item index="2-2">增加图书类别</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
            <template slot="title">图书管理</template>
            <el-menu-item index="3-1">图书列表</el-menu-item>
            <el-menu-item index="3-2">增加图书</el-menu-item>
        </el-submenu>
        <el-submenu index="4">
            <template slot="title">会员管理</template>
            <el-menu-item index="4-1">会员列表</el-menu-item>
            <el-menu-item index="4-2">增加会员</el-menu-item>
        </el-submenu>
        <el-submenu index="5">
            <template slot="title">订单管理</template>
            <el-menu-item index="5-1">订单列表</el-menu-item>
        </el-submenu>
        <%--            <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>--%>
    </el-menu>
</div>
<script type="text/javascript">
    var nav = new Vue({
        el: '#nav',
        data() {
            return {
                activeIndex: '1'
            }
        },
        methods: {
            handleSelect(key, keyPath) {
                // console.log(key, keyPath);
                console.log(key);
                if(key == '1'){
                    location.href = '../admin/index'
                }else if(key == '2-1'){
                    location.href = '../admin/bookCategory'
                }else if(key == '2-2'){
                    location.href = '../admin/bookCategoryAdd'
                }else if(key == '3-1'){
                    location.href = '../admin/book'
                }else if(key == '3-2'){
                    location.href = '../admin/bookAdd'
                }else if(key == '4-1'){
                    location.href = '../admin/user'
                }else if(key == '4-2'){
                    location.href = '../admin/userAdd'
                }else if(key == '5-1'){
                    location.href='../admin/order'
                }
            }
        }
    })
</script>