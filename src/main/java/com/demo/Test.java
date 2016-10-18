package com.demo;

//import com.demo.data.UserRepository;
//import com.demo.data.UserRepositoryImpl;
import com.demo.data.accountinfo;
import com.demo.service.accountinfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import qt.mvc.entity.Model;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Test
{
    public void print(String string)
    {
        System.out.println("print(String string)");
        System.out.println(string);
    }

    public void print(String ... strings)
    {
        System.out.println("print(String ... string)");

        for(String string: strings)
            System.out.println(string);
    }

    public void print(MemberInfo info,Model model){
        System.out.println("print(info ... model)");
    }

    public static void main(String[] args) throws Exception
    {
        /*
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        //EntityManager entityManager = (EntityManager) ctx.("jpa");
        //EntityManager entityManager = //ctx.getBean("entityManagerFactory",EntityManager.class);
        UserRepository userRepository = ctx.getBean("userRepository",UserRepository.class);
        EntityManagerFactory entityManagerFactory = ctx.getBean("entityManagerFactory",EntityManagerFactory.class);
        EntityManager manager= entityManagerFactory.createEntityManager();
        //manager.q
        accountinfo dt = new accountinfo(100);
        //dt.setAccountId(101);
        //dt.setBalance(2000);
        //userRepository.save(dt);
        //dt = userRepository.findOne(1);

        //List<accountinfo> lst = userRepository.findByBalance(2000);
        //List<accountinfo> lst = userRepository.findAll();
        //userRepository.
        //System.out.println("Id :"+dt.getAccountId()+" Balance:"+dt.getAccountId());
        List<accountinfo> lst  = userRepository.findByBalance(new Integer(2000));//findByAccountId(2);
        //System.out.println("Id :"+dt.getAccountId()+" Balance:"+dt.getAccountId());
        System.out.println("list :"+lst.size());
        */
        /*
        accountinfo account = new accountinfo();
        //account.setAccountId(101);
        account.setBalance(2000);
        userRepository.save(account);
*/
        /*
        JdbcTemplate jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
        String sql = "select * from t_accountinfo ";
        List<accountinfoDto> lst = (List<accountinfoDto>) jt.query(sql, new BeanPropertyRowMapper(accountinfoDto.class));
        System.out.println(lst.size());
*/

        //sql = "insert t_accountinfo values(?,?)";
        //jt.update(sql,1,2);
        /*
        Map<String, String> para = new HashMap<String, String>();
        para.put("name",   "testtest ");
        para.put("id",   "testtest2 ");
        String as = getTemplateStr("../../web/view/a.vm", para);
        System.out.println(as);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");

        String json=mapper.writeValueAsString(map);
                //JSON.toJSONString(map);
        System.out.println(json);
*/
/*
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
        System.out.println(ctx); // 输出Spring容器
        ProductService p = ctx.getBean("personService", ProductService.class);
        Product product = p.getNewProduct();
        System.out.println(product.getProductName()); // 输出Spring容器
*/

        /*
        String sourceStr = "com.demo|com.newdemo.service";
        String[] sourceStrArray = sourceStr.split("\\|");
        int i=0;
        for (String sourceName : sourceStrArray) {
            System.out.println("["+i+++"]"+sourceName);
        }
*/


        /*
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
        String sql = "select * from t_accountinfo ";
        List<accountinfoDto> lst = (List<accountinfoDto>) jt.query(sql, new BeanPropertyRowMapper(accountinfoDto.class));
        sql = "insert t_accountinfo values(?,?)";
        jt.update(sql,1,2);
````````*/

        //accountinfoDto
        //System.out.println("B:"+lst.size());
        /*
        Test test = new Test();




        // 调用 print(String string)
        Method method1 = test.getClass().getMethod("print", String.class);
        method1.invoke(test, "a");

        // 调用 print(String ... strings)
        Method method2 = test.getClass().getMethod("print", Array.newInstance(String.class, 0).getClass());
        method2.invoke(test, new String[][]{new String[]{"a", "b"}});

        Method[] methods = test.getClass().getDeclaredMethods();
        Method TestMethods = methods[2];
        TestMethods.invoke(test, new MemberInfo(),new Model());
        */
    }

    public static String getTemplateStr(String template, Map<String, String> para) {
        VelocityEngine ve = new VelocityEngine();
        StringWriter writer = new StringWriter();
        //try {

            String fileDir = Test.class.getResource("/").getPath();
                    //.getResource("/").getPath();
            System.out.println("fileDir:"+fileDir);

            Properties properties = new Properties();

            //将当前路径设置到VelocityEngine 中
            properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, fileDir);
            properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
            properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
            properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");	                  ve.init(properties);


            Template t = ve.getTemplate(template);
            VelocityContext context = new VelocityContext();
            if (para.size() > 0) {
                for (String key : para.keySet()) {
                    context.put(key, para.get(key));
                }
            }
            t.merge(context, writer);
        //} catch (Exception e) {
            //logger.warn("", e);
        //    throw new RuntimeException("Error commiting transaction! cause:"
                    //+ e.getMessage());
        //}
        return writer.toString();
    }
}