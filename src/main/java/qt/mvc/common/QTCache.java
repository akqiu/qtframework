package qt.mvc.common;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;



/**
 * Created by qiutian on 16-8-30.
 */
public class QTCache {

    private static CacheManager _cacheManager;
    private static final String cacheName = "Test";

    public static void doInit(){

        //CacheManager manager = new CacheManager("/ehcache.xml");//实例模式
        CacheManager.create();//单例模式，默认读取类路径下的ehcache.xml作为配置文件
        //Cache cache = manager.getCache("staticResourceCache");
        Cache cache = CacheManager.getInstance().getCache("staticResourceCache");
        /*
        InputStream in = QTCache.class.getClassLoader().getResourceAsStream("/ehcache.xml");
        _cacheManager = CacheManager.create(in);
        _cacheManager.addCache(cacheName);
        */
        //QTCache cache = cm.getCache("data-cache");
    }

    public static Object Get(String key){
        Cache cache = _cacheManager.getCache(cacheName);
        return cache.get(key);
    }

    public static void Put(String key, String value){
        //private static void writeSomeData(QTCache cache, String key, String value) {
            //cache.put(new Element(key, value));
        //}
        Cache cache = _cacheManager.getCache(cacheName);
        cache.put(new Element(key, value));
    }

}
