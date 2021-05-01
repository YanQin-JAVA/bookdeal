package com.yanqin.bookdeal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.yanqin.bookdeal.domain.Book;
import com.yanqin.bookdeal.domain.BookCategory;
import com.yanqin.bookdeal.domain.OrderManagement;
import com.yanqin.bookdeal.domain.User;
import com.yanqin.bookdeal.service.BookCategoryService;
import com.yanqin.bookdeal.service.BookService;
import com.yanqin.bookdeal.service.OrderManagementService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderManagementService orderManagementService;
	@Resource
	private BookService bookService;

	@RequestMapping("/add")
	public R<String> add(@RequestBody @Valid OrderManagement order, HttpSession session){
		User user = (User) session.getAttribute("user");

		order.setCreateDate(new Date());
		order.setUpdateDate(new Date());
		order.setUserId(user.getId());
		order.setBuyNum(1);
		order.setOrderNum(UUID.randomUUID().toString().replace("-",""));
		order.setReceiver(user.getUsername());
		order.setReceiveAddress(user.getAddress());
		order.setReceiveMobile(user.getMobile());
		orderManagementService.save(order);
		return R.ok("保存成功");
	}

	@RequestMapping("/list")
	public R<List<OrderManagement>> list(HttpSession session){
		User user = (User) session.getAttribute("user");
		LambdaQueryWrapper<OrderManagement> vwq = Wrappers.<OrderManagement>query().lambda();
		if(!user.getUserid().equals("admin")){
			vwq.eq(OrderManagement::getUserId, user.getId());
		}
		List<OrderManagement> list = orderManagementService.list(vwq);
		for (OrderManagement o : list) {
			Book one = bookService.getOne(Wrappers.<Book>query().lambda().eq(Book::getId, o.getBookId()));
			o.setBookName(one.getBookName());
			o.setUserName(user.getUsername());
		}
		return R.ok(list);
	}

}
