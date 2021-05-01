package com.yanqin.bookdeal.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单管理表
 * @TableName order_management
 */
@TableName(value ="order_management")
@Data
public class OrderManagement implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 关联的会员id
     */
    private Integer userId;

    /**
     * 关联的图书id
     */
    private Integer bookId;


    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String bookName;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收货电话
     */
    private String receiveMobile;

    /**
     * 收货地址
     */
    private String receiveAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderManagement other = (OrderManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getBuyNum() == null ? other.getBuyNum() == null : this.getBuyNum().equals(other.getBuyNum()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getReceiveMobile() == null ? other.getReceiveMobile() == null : this.getReceiveMobile().equals(other.getReceiveMobile()))
            && (this.getReceiveAddress() == null ? other.getReceiveAddress() == null : this.getReceiveAddress().equals(other.getReceiveAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBuyNum() == null) ? 0 : getBuyNum().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getReceiveMobile() == null) ? 0 : getReceiveMobile().hashCode());
        result = prime * result + ((getReceiveAddress() == null) ? 0 : getReceiveAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", userId=").append(userId);
        sb.append(", bookId=").append(bookId);
        sb.append(", buyNum=").append(buyNum);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiveMobile=").append(receiveMobile);
        sb.append(", receiveAddress=").append(receiveAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}