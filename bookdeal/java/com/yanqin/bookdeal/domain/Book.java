package com.yanqin.bookdeal.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 图书表
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
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
     * 图书分类id
     */
    @NotNull
    private Integer categoryId;

    /**
     * 图书名称
     */
    @NotBlank
    private String bookName;

    /**
     * 图书描述
     */
    @NotBlank
    private String bookDesc;

    /**
     * 作者
     */
    @NotBlank
    private String author;

    /**
     * 出版社
     */
    @NotBlank
    private String publishHouse;

    /**
     * 出版时间
     */
    @NotBlank
    private String publishDate;

    /**
     * 价格
     */
    @NotNull
    private BigDecimal price;

    /**
     * 书号
     */
    @NotBlank
    private String bookNumber;

    /**
     * 内容简介
     */
    @NotBlank
    private String contentDesc;

    /**
     * 作者简介
     */
    @NotBlank
    private String authorDesc;

    @TableField(exist = false)
    private String categoryName;

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
        Book other = (Book) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getBookDesc() == null ? other.getBookDesc() == null : this.getBookDesc().equals(other.getBookDesc()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getPublishHouse() == null ? other.getPublishHouse() == null : this.getPublishHouse().equals(other.getPublishHouse()))
            && (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getBookNumber() == null ? other.getBookNumber() == null : this.getBookNumber().equals(other.getBookNumber()))
            && (this.getContentDesc() == null ? other.getContentDesc() == null : this.getContentDesc().equals(other.getContentDesc()))
            && (this.getAuthorDesc() == null ? other.getAuthorDesc() == null : this.getAuthorDesc().equals(other.getAuthorDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getBookDesc() == null) ? 0 : getBookDesc().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getPublishHouse() == null) ? 0 : getPublishHouse().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getBookNumber() == null) ? 0 : getBookNumber().hashCode());
        result = prime * result + ((getContentDesc() == null) ? 0 : getContentDesc().hashCode());
        result = prime * result + ((getAuthorDesc() == null) ? 0 : getAuthorDesc().hashCode());
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookDesc=").append(bookDesc);
        sb.append(", author=").append(author);
        sb.append(", publishHouse=").append(publishHouse);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", price=").append(price);
        sb.append(", bookNumber=").append(bookNumber);
        sb.append(", contentDesc=").append(contentDesc);
        sb.append(", authorDesc=").append(authorDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}