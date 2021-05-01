package com.yanqin.bookdeal.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yanqin.bookdeal.domain.BookCategory;
import com.yanqin.bookdeal.service.BookCategoryService;
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
@RequestMapping("/bookCategory")
public class BookCategoryController {

	@Resource
	private BookCategoryService bookCategoryService;

	@RequestMapping("/add")
	public R<String> add(@RequestBody @Valid BookCategory category){
		category.setCategoryName(category.getName());
		Date date = new Date();
		category.setCreateDate(date);
		category.setUpdateDate(date);
		bookCategoryService.save(category);
		return R.ok("保存成功");
	}

	@RequestMapping("/list")
	public R<List<BookCategory>> list(){
		List<BookCategory> list = bookCategoryService.list();
		return R.ok(list);
	}

}
