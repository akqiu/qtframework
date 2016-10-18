package com.demo;

import qt.mvc.annotation.Inject;
import qt.mvc.entity.ModelAndView;

import java.util.HashMap;

public class demo {
    //自动注入 可用name做映射名
    @Inject(name = "prdsrv")
    private ProductService productService;

    private int Iy= 0;


    //常规调用模式controller/action?name=yy
    public ModelAndView getuser(MemberInfo info){

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Name","刘圆");
        map.put("Status","讲解员");
        return new ModelAndView("test",map);
    }

    //Json 格式的输出
    public MemberInfo json(MemberInfo info){

        info.setName("仇恬");
        info.setAddress("南京东路2006弄");
        return info;
    }
}
