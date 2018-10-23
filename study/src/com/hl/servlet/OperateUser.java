package com.hl.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONObject;

import com.hl.sys.MybatisUtil;
import com.hl.sys.User;
import com.hl.sys.UserMapper;

/**
 * Servlet implementation class OperateUser
 */
@WebServlet("/OperateUser")
public class OperateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSessionFactory sessionFactory= MybatisUtil.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperateUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("type=---------------- "+request.getServletContext().getEffectiveMajorVersion() );
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		Map map = request.getParameterMap();
		System.out.println(map.toString());
		String username = request.getParameter("user");
		String password = request.getParameter("pssd");
		System.out.println("username= " + username + "password=" +password);
		
		String resource = "/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		System.out.println("====inputStream" + inputStream.toString());
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		JSONObject jsonObj = new JSONObject();
		SqlSession session = sessionFactory.openSession();
	    try {
           UserMapper userMapper = session.getMapper(UserMapper.class);
           User user = userMapper.find(username);
           if(user==null) {
        	   user = new User();
               user.setId(username);
               user.setUsername(username);
               user.setPassword(password);
               userMapper.save(user);
               session.commit();//提交事务 
               jsonObj.append("result", "ok");
        	   jsonObj.append("info", "用户【"+ username + "】已注册成功！");
           }else {
        	   jsonObj.append("result", "error");
        	   jsonObj.append("info", "用户【"+ username + "】已存在！");
           }
           response.setHeader("location", "/study/index.jsp");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    out.println(jsonObj.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
