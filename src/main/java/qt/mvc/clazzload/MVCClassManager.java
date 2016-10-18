package qt.mvc.clazzload;

import qt.mvc.constant.ConstantClass;
import qt.mvc.annotation.Alias;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qiutian on 16-9-7.
 */
public class MVCClassManager {

    private HashMap<String,Class<?>> classList;

    public synchronized HashMap<String, Class<?>> getClassList() {
        return classList;
    }

    public MVCClassManager(){
        if (ConstantClass.CONFIG != null)
            Init();
    }

    public void Init(){

        classList = new HashMap<String,Class<?>>();
        ClasspathPackageScanner scan = new ClasspathPackageScanner(ConstantClass.CONFIG.getScannerPath());

        try {

            List<String> list = scan.getFullyQualifiedClassNameList();
            for(String m_class:list) {
                Class<?> clazz = Class.forName(m_class);
                Alias myAnnotation = clazz.getAnnotation(Alias.class);
                String clazzName = m_class;
                if (myAnnotation != null){
                    if (myAnnotation.value().length()>0) {
                        clazzName = ConstantClass.CONFIG.getScannerPath() + "." + myAnnotation.value();
                    }
                }
                classList.put(clazzName,clazz);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
