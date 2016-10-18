package qt.mvc.translator;

import qt.mvc.entity.PageInfo;
import qt.mvc.exception.CanNotResolveException;

/**
 * Created by qiutian on 16-9-2.
 * Used to translator http request to class Model
 */
public interface HttpParamsTranslator {

    Object createModel(PageInfo pageInfo) throws CanNotResolveException;
}
