package qt.mvc.listener;
import com.fasterxml.jackson.databind.ObjectMapper;
//import qt.mvc.Constant.ConstantClass;
import qt.mvc.constant.ConstantClass;
import qt.mvc.entity.SystemConfig;
//import qt.mvc.properties.QTProperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

/**
 * Created by qiutian on 16-9-8.
 */
public class QTDefaultListener implements ServletContextListener{

    private static Properties props;


    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        try {
            InitProperties(event);
            InitConfiguration();
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
        System.out.println("Event:"+event.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        //构造初始化参数等
        System.out.println(arg0.toString());

    }
    //配置初始化
    private void InitProperties(ServletContextEvent event) throws IOException {
        //配置文件已初始化
        if (ConstantClass.CONFIG != null)
            return;

        ObjectMapper mapper = new ObjectMapper();

        InputStream in=event.getServletContext().getResourceAsStream("WEB-INF/classes/config.json");

        ConstantClass.CONFIG = mapper.readValue(IOUtils.toString(in, "UTF-8"), SystemConfig.class);

        //System.out.print(ConstantClass.CONFIG.getContentType().size());

    }

    //配置项初始化
    private void InitConfiguration() {

    }
}
