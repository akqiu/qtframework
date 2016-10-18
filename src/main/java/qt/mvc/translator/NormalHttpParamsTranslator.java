package qt.mvc.translator;

import qt.mvc.constant.ConstantClass;
import qt.mvc.entity.PageInfo;
import qt.mvc.exception.CanNotResolveException;
import org.apache.log4j.Logger;

/**
 * Created by qiutian on 16-9-2.
 * Get Type Params translator
 */
public class NormalHttpParamsTranslator implements HttpParamsTranslator{

    //private static final long serialVersionUID
    private static Logger logger = Logger.getLogger(NormalHttpParamsTranslator.class);

    @Override
    public Object createModel(PageInfo pageInfo) throws CanNotResolveException {
        //解析URL,获取类名与参数
        Object controller = null;
        //T entity = T..newInstance();
        try {
            controller = Class.forName(ConstantClass.CONFIG.getScannerPath()+"."+pageInfo.getControllerName());
        } catch (ClassNotFoundException e) {
            logger.error(e);
            //e.printStackTrace();
        }
        return controller;
    }


}
