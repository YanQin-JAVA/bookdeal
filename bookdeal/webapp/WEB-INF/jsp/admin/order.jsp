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
            width:1600px;
            margin-left:50px;
        }
    </style>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div id="app">
            <el-container>
                <el-main>

                    <template>
                        <el-table
                                :data="tableData"
                                style="width: 100%">
                            <el-table-column
                                    prop="orderNum"
                                    label="订单编号"
                                    width="300">
                            </el-table-column>
                            <el-table-column
                                    prop="createDate"
                                    label="创建时间"
                                    width="170">
                            </el-table-column>
                            <el-table-column
                                    prop="bookName"
                                    label="书籍名称"
                                    width="150">
                            </el-table-column>

                            <el-table-column
                                    prop="buyNum"
                                    label="购买数量"
                                    width="100">
                            </el-table-column>
                            <el-table-column
                                    prop="totalPrice"
                                    label="总价格"
                                    width="150">
                            </el-table-column>
                            <el-table-column
                                    prop="userName"
                                    label="购买账号"
                                    width="100">
                            </el-table-column>
                            <el-table-column
                                    prop="receiver"
                                    label="收货人"
                                    width="150">
                            </el-table-column>
                            <el-table-column
                                    prop="receiveMobile"
                                    label="手机号"
                                    width="150">
                            </el-table-column>
                            <el-table-column
                                    prop="receiveAddress"
                                    label="收货地址"
                                    width="250">
                            </el-table-column>

                        </el-table>
                    </template>
                </el-main>
            </el-container>
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data() {
            return {
                tableData: [],
            }
        },
        mounted() {
            this.list();
            nav._data.activeIndex = '5-1'
        },
        methods: {
            list() {
                var that = this;
                $.ajax({
                    url:'../order/list',
                    type:'get',
                    success:function(result){
                        if(result.code == 0){
                            console.log(result.data);
                            that.tableData = result.data;
                        }
                    }
                });
            },
            pay(){
                this.$alert('请将订单金额通过银行汇款到兴业银行(上地支行)5555-5555-5555-5555账号上，并且备注订单编号，我们看到付款信息后，将进行发货。谢谢！', '支付', {
                    confirmButtonText: '确定',
                    callback: action => {
                    }
                });
            }

        }
    })
</script>
</html>
