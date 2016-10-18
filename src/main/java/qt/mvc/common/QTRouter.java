package qt.mvc.common;

import qt.mvc.entity.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiutian on 16-9-13.
 */
public abstract class QTRouter {

    private Map<String,RouterType> map = new HashMap<String,RouterType>();

    //路由规则
    public void addRule(String exp,RouterType type){
        //exp = urlpath/{controller}.{action}

    }

    //获取Controller and Action Info
    public PageInfo GetPageInfo(String url){

        return new PageInfo();
    }

}
