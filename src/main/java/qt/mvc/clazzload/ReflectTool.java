package qt.mvc.clazzload;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiutian on 16-9-7.
 */
public class ReflectTool {

    public static Object Fill(Class<?> clazz, Object instance, Map params) throws IllegalAccessException {
        Field fs = null;

        Iterator entries = params.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            try {
                fs = clazz.getDeclaredField(key);
                fs.setAccessible(true); //设置些属性是可以访问的
                String type = fs.getType().toString();//得到此属性的类型
                if (type.endsWith("String")) {
                    System.out.println(fs.getType() + "\t是String");
                    fs.set(instance,entry.getValue());        //给属性设值
                } else if (type.endsWith("int") || type.endsWith("Integer")) {
                    System.out.println(fs.getType() + "\t是int");
                    fs.set(instance, entry.getValue());       //给属性设值
                } else {
                    System.out.println(fs.getType() + "\t");
                }

            } catch (NoSuchFieldException e) {
                fs = null;
                //e.printStackTrace();
            }


        }

        return instance;
    }
}
