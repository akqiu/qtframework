package qt.mvc.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiutian on 16-9-2.
 */
public class PageInfo {


    private String controllerName;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    private String actionName;

    private Map<String,String> params;

    private String contentType;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ViewTypeEnum getViewType() {
        return viewType;
    }

    public void setViewType(ViewTypeEnum viewType) {
        this.viewType = viewType;
    }

    private ViewTypeEnum viewType;

    public Map<String,String> getparams() {
        if(this.params == null) {
            params = new HashMap<String,String>();
        }

        return this.params;
    }
}
