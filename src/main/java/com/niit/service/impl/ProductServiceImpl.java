package com.niit.service.impl;

import java.util.List;

import com.niit.entity.Product;
import com.niit.entity.ProductExample;
import com.niit.exceptiondemo.MyException;
import com.niit.mapper.ProductMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niit.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Override
	   public Product findById(Integer id) throws Exception {
	      return productMapper.selectByPrimaryKey(id);
	   }
	@Override
		public PageInfo<Product> list(ProductExample productExample,Integer page) {
			PageHelper.startPage(page,3);
			List<Product> list = productMapper.selectByExample(productExample);
			PageInfo<Product> pageInfo = new PageInfo<>(list);
			return pageInfo;
		}
	@Override
	public void add(Product product) throws MyException {
		int i = productMapper.insertSelective(product);
		if (i>0){
			  throw new MyException("添加商品成功！！！！");
		}else{
			throw new MyException("添加商品失败！！！！");
		}
	}
	@Override
	   public void delete(Integer id) throws Exception {
	      int row  =  productMapper.deleteByPrimaryKey(id);
	   }
	@Override
	   public void update(Integer id, Product product) throws Exception {
		product.setId(id);
		int i = productMapper.updateByPrimaryKeySelective(product);
		if (i>0){
					  throw new MyException("修改商品成功！！！！");
				}else{
					throw new MyException("修改商品失败！！！！");
				}
	   }
	@Override
	   public PageInfo<Product> find(Product product,Integer page) throws MyException {
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		if(product.getProductName() != null && !"".equals(product.getProductName()) ){
			criteria.andProductNameLike("%"+product.getProductName()+"%") ;
		} else if(product.getProductName() == ""){
			throw new MyException("请输入要查询的商品名称！！！！！！！");
		}
		PageHelper.startPage(page,3);
		List<Product> list = productMapper.selectByExample(example);
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		if(pageInfo.getList().isEmpty()){
					throw new MyException("没有查到此商品信息！！！！！！！");
				}
				return pageInfo;
	   }
	   

}
