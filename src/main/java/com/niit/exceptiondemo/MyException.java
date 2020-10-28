package com.niit.exceptiondemo;

/*自定义异常处理,要先定义好全局异常处理，来绑定这个自我异常,最后还是交给全局处理异常来处理的*/
public class MyException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyException(String message) {
        this.message = message;
        System.out.println("第一次提交");

    }
}
