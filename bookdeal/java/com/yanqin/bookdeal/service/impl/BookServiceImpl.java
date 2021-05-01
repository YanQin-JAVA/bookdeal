package com.yanqin.bookdeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanqin.bookdeal.domain.Book;
import com.yanqin.bookdeal.service.BookService;
import com.yanqin.bookdeal.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
implements BookService{

}




