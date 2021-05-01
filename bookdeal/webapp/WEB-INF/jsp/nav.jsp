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

        <el-menu-item index="1">书籍浏览</el-menu-item>
        <el-menu-item index="2">管理订单</el-menu-item>
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
                    location.href = '../user/book'
                }else if(key == '2'){
                    location.href = '../user/order'
                }
            }
        }
    })
</script>