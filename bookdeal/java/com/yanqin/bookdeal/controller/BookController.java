package com.yanqin.bookdeal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.yanqin.bookdeal.domain.Book;
import com.yanqin.bookdeal.domain.BookCategory;
import com.yanqin.bookdeal.service.BookCategoryService;
import com.yanqin.bookdeal.service.BookService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@RestController
@RequestMapping("/book")
public class BookController {

	@Resource
	private BookService bookService;
	@Resource
	private BookCategoryService bookCategoryService;

	@RequestMapping("/add")
	public R<String> add(@RequestBody @Valid Book book){
		Date date = new Date();
		book.setCreateDate(date);
		book.setUpdateDate(date);
		bookService.save(book);
		return R.ok("保存成功");
	}

	@RequestMapping({"/list","/getbook"})
	public R<List<Book>> list(Integer cateid,String like,Integer id){
		LambdaQueryWrapper<Book> qw = Wrappers.<Book>query().lambda();
		if(cateid!=null){
			qw.eq(Book::getCategoryId,cateid);
		}
		if(id!=null){
			qw.eq(Book::getId,id);
		}
		if(!StringUtils.isEmpty(like)){
			qw.and(w -> w.like(Book::getBookName,like).or().like(Book::getAuthor,like).or().like(Book::getBookNumber,like));
		}
		List<Book> list = bookService.list(qw);
		for (Book book : list) {
			BookCategory one = bookCategoryService.getOne(Wrappers.<BookCategory>query().lambda()
					.eq(BookCategory::getId, book.getCategoryId()));
			book.setCategoryName(one.getCategoryName());
		}
		return R.ok(list);
	}


}
