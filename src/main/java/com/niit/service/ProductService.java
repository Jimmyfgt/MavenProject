package com.niit.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.niit.entity.Product;
import com.niit.entity.ProductExample;
import com.niit.exceptiondemo.MyException;

public interface ProductService {
	public Product findById(Integer id) throws Exception;
	public PageInfo<Product> list(ProductExample productExample, Integer page);
	public void add(Product product) throws MyException;
	public void delete(Integer id) throws Exception;
	public void update(Integer id, Product product) throws Exception;
	public PageInfo<Product> find(Product product, Integer page) throws MyException ;
}
