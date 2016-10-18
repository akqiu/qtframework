package qt.mvc.constant;

import qt.mvc.entity.SystemConfig;

/**
 * Created by qiutian on 16-9-2.
 */
public class ConstantClass {

    public static SystemConfig CONFIG;

    public static final String CanNotFoundPage = "error.jsp";

    public static final String ModelAndView = "qt.mvc.entity.ModelAndView";

    public static final String STRING = "java.lang.String";

    public static final String POST_JSON = "Post_Json_2016_001";

    static {
        /*
        ObjectMapper mapper = new ObjectMapper();

        InputStream in=ConstantClass.class.getResourceAsStream("WEB-INF/classes/config.json");

        try {
            CONFIG = mapper.readValue(IOUtils.toString(in, "UTF-8"), SystemConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
