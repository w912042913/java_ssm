

import com.neusoft.dao.IEmpDao;
import com.neusoft.domain.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest2 {
    private  InputStream in;
    private SqlSession sqlSession;

    private IEmpDao empDao;
    // 在测试方法之前执行
    @Before
    public void init() throws IOException {
        // 1. 读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用 工厂生产的 SqlSession对象
        sqlSession = factory.openSession();
        // 4. 使用SqlSession 创建Dao 接口 的代理对象
        empDao = sqlSession.getMapper(IEmpDao.class);
    }
    @After
    public void destroy() throws IOException {
        // 提交事物
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<Emp> emps = empDao.findAll();
        for (Emp emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void testFindOne(){
        Emp emp = empDao.findBySal(800);

         System.out.println(emp);

    }
    @Test
    public void testSave(){
        // 注意要提交事物
        Emp emp = new Emp();
        emp.setDept_no(100);
        emp.setComm(10);
        emp.setMgr(200);
        emp.setE_job("保安");

        System.out.println("保存之前"+ emp);
        int i = empDao.savaEmp(emp);
        System.out.println("影响的行数" + i);
        System.out.println("保存之后"+emp);

    }
//
////
//    @Test
//    public void testUpdate(){
//        // 注意要提交事物
//        User user = new User();
//        user.setUserId(51);
//        user.setUserName("李白");
//        user.setUserBirthday(new Date());
//        user.setUserSex("男");
//        user.setUserAddress("王者峡谷打野区");
//
//        System.out.println("更新之前"+ user);
//        int i = userDao.updateUser(user);
//        System.out.println("影响的行数" + i);
//
//    }
//
////
//    @Test
//    public void testDelete(){
//        int res = userDao.deleteUser(63);
//        System.out.println("res"+ res);
//    }
//
//    @Test
//    public void testLikeName(){
//        List<User> users = userDao.findByName("%李%");
//        for(User user: users){
//            System.out.println(user);
//        }
//    }
////
//    @Test
//    public void testCount(){
//        int total = userDao.findTotal();
//        System.out.println(total);
//    }

}
