package com.demo;

import qt.mvc.annotation.Alias;
import qt.mvc.entity.Model;
import qt.mvc.entity.ModelAndView;

import java.util.HashMap;

/**
 * Created by qiutian on 16-9-25.
 */
@Alias(value="comp")
public class component {


    //标准输出,支持PostJson 输入
    public ModelAndView test(MemberInfo info){
        //object params
        System.out.println("=================================");
        System.out.println("Value:"+info.getName());
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Name","张三");
        map.put("Status","参观人员");
        return new ModelAndView("test",map);
    }

    //默认只有一个参数,特殊情况下可以使用model变量输出
    public String datagrid( MemberInfo info,Model model){
        //object params


        //model.add("Name","李先生");
        //model.add("Status","保安");

        return "datagrid";
    }
}
