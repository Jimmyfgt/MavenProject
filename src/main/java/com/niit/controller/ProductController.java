package com.niit.controller;

import com.github.pagehelper.PageInfo;
import com.niit.entity.Product;
import com.niit.entity.ProductExample;
import com.niit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping("/list")
    public String list(@RequestParam(required = true, defaultValue = "1") Integer page, Model model, ProductExample productExample) {
        PageInfo<Product> pageInfo = productService.list(productExample, page);
        model.addAttribute("pageInfo", pageInfo);
        return "list";


    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/toadd")
    //注意这里的 MultipartFile img名字不能和实体类的属性名一样，Spring注入的类，类里的名字是String类型，这个是 MultipartFile类型，所以无法装换
    public String toadd(Product product, MultipartFile img) throws Exception {
        // 上传图片
        // 原始名称
        String originalFilename = img.getOriginalFilename();
        if (img != null && originalFilename != null && originalFilename.length() > 0) {
            // 存储图片的物理路径
            String pic_path = "E:\\idea-SSM\\SSM01\\web\\WEB-INF\\img\\";
            // 新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 新的图片(物理路径+图片名)
            File newFile = new File(pic_path + newFileName);
            // 将内存中的数据写到磁盘
            img.transferTo(newFile);
            // 将图片加入到Product中
            product.setProductImg(newFileName);
        }
        // 调用service更新*/
        productService.add(product);
        // 重定向
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String deleteCustom(Integer id) throws Exception {
        productService.delete(id);
        return "redirect:list";
    }

    @RequestMapping("/update")
    public String update(Model model, Integer id) throws Exception {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }


    @RequestMapping(value = "/toupdate", method = RequestMethod.POST)
    public String toupdate(Integer id, Product product, @RequestParam("img") MultipartFile img) throws Exception {
        // 上传图片
        // 原始名称
        String originalFilename = img.getOriginalFilename();
        if (img != null && originalFilename != null && originalFilename.length() > 0) {
            // 存储图片的物理路径
            String pic_path = "E:\\idea-SSM\\SSM01\\web\\WEB-INF\\img\\";
            // 新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 新的图片(物理路径+图片名)
            File newFile = new File(pic_path + newFileName);
            // 将内存中的数据写到磁盘
            img.transferTo(newFile);
            // 将图片加入到Product中
            product.setProductImg(newFileName);
        }
        // 调用service更新*/
        productService.update(id, product);
        return "list";
    }

    /*模糊查找*/
    @RequestMapping("/find")
    public String find(@RequestParam(required = true, defaultValue = "1") Integer page, Product product, Model model) throws Exception {
        PageInfo<Product> list = productService.find(product, page);
        model.addAttribute("pageInfo", list);
        return "list";
    }

}
