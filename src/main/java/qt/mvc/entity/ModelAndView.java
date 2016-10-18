package qt.mvc.entity;

/**
 * Created by qiutian on 16-9-2.
 */
public class ModelAndView {


    public  ModelAndView(String page,Object pars){
        this.forwardPage = page;
        this.params = pars;
    }

    public ModelAndView(){

    }

    public String getForwardPage() {
        return forwardPage;
    }

    public void setForwardPage(String forwardPage) {
        this.forwardPage = forwardPage;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public String forwardPage;

    public Object params;

}
