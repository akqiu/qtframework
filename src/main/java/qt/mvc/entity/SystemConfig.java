package qt.mvc.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qiutian on 16-9-27.
 */
public class SystemConfig {

    public String getScannerPath() {
        return scannerPath;
    }

    public void setScannerPath(String scannerPath) {
        this.scannerPath = scannerPath;
    }

    public String getResourcesFilter() {
        return resourcesFilter;
    }

    public void setResourcesFilter(String resourcesFilter) {
        this.resourcesFilter = resourcesFilter;
    }

    public String getResourcesSourcePath() {
        return resourcesSourcePath;
    }

    public void setResourcesSourcePath(String resourcesPath) {
        this.resourcesSourcePath = resourcesPath;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public String getResourcesViewPath() {
        return resourcesViewPath;
    }

    public void setResourcesViewPath(String resourcesViewPath) {
        this.resourcesViewPath = resourcesViewPath;
    }

    private String scannerPath;

    private String resourcesFilter;

    private String resourcesSourcePath;

    private String resourcesViewPath;

    private String viewPath;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    private int viewType;

    public HashMap<String,String> getContentType() {
        return contentType;
    }

    public void setContentType(HashMap<String,String> contentType) {
        this.contentType = contentType;
    }

    private HashMap<String,String> contentType = new HashMap<String,String>();


}
