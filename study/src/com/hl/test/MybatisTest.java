package com.hl.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import com.hl.sys.User;
import com.hl.sys.UserMapper;
import com.hl.sys.MybatisUtil;
public class MybatisTest {
    private SqlSessionFactory sessionFactory= MybatisUtil.getInstance();

    @Test
    public void save() {
       SqlSession session = sessionFactory.openSession();
       try {
           UserMapper userMapper = session.getMapper(UserMapper.class);

           User user = new User();
           user.setId("1");
           user.setUsername("����");
           user.setPassword("123456");
           userMapper.save(user);
           session.commit();//�ύ����
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          session.close();
      }
  }

  @Test
  public void update() {
       SqlSession session = sessionFactory.openSession();
       try {
           UserMapper userMapper = session.getMapper(UserMapper.class);

           User user = userMapper.find("1");
           System.out.println(user);
           if(user!=null) {
               user.setUsername("����1");

               userMapper.update(user);
               session.commit();//�ύ����
           }else {
        	   System.out.println("�û������ڣ�");
           }

       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
  }

 @Test
 public void find() {
       SqlSession session = sessionFactory.openSession();
       try {
           UserMapper userMapper = session.getMapper(UserMapper.class);

           User user = userMapper.find("1");

           System.out.println("id : " + user.getId() + ", username : " + user.getUsername() + ", password : " + user.getPassword());
       } catch (Exception e) {
          e.printStackTrace();
       } finally {
         session.close();
       }
 }

 @Test
 public void delete() {
       SqlSession session = sessionFactory.openSession();
       try {
           UserMapper userMapper = session.getMapper(UserMapper.class);

           userMapper.delete("1");
           session.commit();//�ύ����
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
 }

}