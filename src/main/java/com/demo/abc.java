package com.demo;

import com.demo.service.UserService;
import qt.mvc.annotation.Inject;
import qt.mvc.entity.Model;
import qt.mvc.entity.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiutian on 16-9-2.
 */
public class abc {

    @Inject(name = "personService")
    private ProductService productService;
    @Inject
    private UserService userService;



    private int Iy= 0;

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

    public ModelAndView test2(MemberInfo info){
        //object params
        System.out.println("=================================");
        System.out.println("Value:"+info.getName());
        Map<String,String> map = new HashMap<String,String>();
        map.put("Name","刘圆");
        map.put("Status","讲解员");
        return new ModelAndView("test",map);
    }

    //默认只有一个参数,特殊情况下可以使用model变量输出
    public String test3(Model model,MemberInfo info){
        //object params

        System.out.println("=================================");
        System.out.println("Value:"+info.getName());

        model.add("Name","李先生");
        model.add("Status","保安");

        return "test";
    }

    //Json 格式的输出,支持PostJson 输入
    public MemberInfo json(MemberInfo info){

        info.setName("仇恬"+userService.getUserName(123));
        info.setAge(info.getAge());
        String name = productService.getNewProduct().getProductName();
        info.setAddress("南京东路2006弄"+name);
        return info;
    }

    public JsonData getdata(getdataInfo info){

        JsonData data = new JsonData();
        data.setHas_more(true);
        data.setQuota_max(300);
        data.setQuota_remaining(270);

        for(int i=1;i<20;i++) {
            JsonDataItem item = new JsonDataItem();
            item.setIs_answered(true);
            item.setAnswer_count(0);
            item.setCreation_date(1474732774);
            item.setLast_activity_date(1474774938);
            item.setLast_edit_date(1474774938);
            item.setLink("http://www.baidu.com");
            item.setQuestion_id(39678266);
            item.setView_count(14);
            item.setTitle("Jqgrid"+ i +" - how to reloa");
            item.getTags().put(new Integer(0), "javascript");
            item.getTags().put(new Integer(1), "jquery");
            item.getTags().put(new Integer(2), "jqgrid");
            data.getItems().add(item);
        }
        return data;
    }
}
