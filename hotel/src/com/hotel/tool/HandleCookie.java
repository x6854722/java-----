package com.hotel.tool;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class HandleCookie{
	//添加cookie； | UnsupportedEncodingException，转码异常
	public void addCookie(String name,String value) throws UnsupportedEncodingException{
		value = URLEncoder.encode(value,"UTF-8");
	    Cookie cookie = new Cookie(name, value);
	    cookie.setMaxAge(5);//保存2分钟；
	    cookie.setPath("/");
	    ServletActionContext.getResponse().addCookie(cookie);
    }
    // 得到指定的cookie;  
    public String getCookie(String cookieName) throws UnsupportedEncodingException { 
    	HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();  
        String value = ""; 
        if (cookies != null) {  
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {  //获取具体的cookie；
                	value = URLDecoder.decode(cookie.getValue(),"UTF-8");
                	return value;  
                }  
            }  
        }  
        return null;  
	}
	 
	// 删除指定的cookie  
    public Cookie delCookie(String cookieName) {
    	HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();  
        if (cookies != null) {  
            for (Cookie cookie : cookies) {  
                if (cookieName.equals(cookie.getName())) {  
                    cookie.setValue("");  
                    cookie.setMaxAge(0);  
                    cookie.setPath("/");  //添加，清除时需要加路径才能清除掉；
                    ServletActionContext.getResponse().addCookie(cookie); 
                }  
            }  
        }  
        return null;  
    }
}
