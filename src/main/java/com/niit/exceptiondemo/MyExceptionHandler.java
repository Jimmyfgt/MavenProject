package com.niit.exceptiondemo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理 处理所有controller的错误,但是不能自定义
 */
@Component //写上这个注解就不用了dispather-servlet.xml中配置了
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        String result = "系统异常，请联系管理员解决！！！！"; /*默认情况下，只要项目运行出现错误，都执行这句话*/
        if (ex instanceof MyException) {/*绑定到自定义异常*/ /*父类转换子类，向下强制装换，先判断*/
            result = ((MyException) ex).getMessage();/*获取自定义跑出的异常信息，在controller层*/
        }                            /*以后若想获取其他错误改这个名字就OK.getMessage();（在Myexception李多写几个变量的事情）*/
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");//设置错误页面
        mav.addObject("message", result);//绑定错误信息
        return mav; /*人家自定义好的一个类似页面*/
    }

}
