package com.framestudy.spring_mybatis.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.framestudy.spring_mybatis.usermag.beans.UserInfo;
import com.framestudy.spring_mybatis.usermag.dao.IUserDao;
import com.framestudy.spring_mybatis.usermag.mapper.UserMapper;
import com.framestudy.spring_mybatis.utils.SessionUtils;

@Repository
public class UserDaoImpl implements IUserDao {
	private UserMapper um;

	public int saveUserInfo(UserInfo user) {
		/* System.out.println(user); */
		// TODO Auto-generated method stub

		SqlSession session = SessionUtils.getSession();// 获取会话连接对象
		um = session.getMapper(UserMapper.class);// 获取接口实例
		int rows = 0;
		try {
			rows = um.saveUserInfo(user);
			/* Integer.valueOf("sde");//看它是否回滚 */
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public int updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获取到会话连接对象
		um = session.getMapper(UserMapper.class);// 获取接口实例
		int rows = 0;
		try {
			rows = um.updateUserInfo(user);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return rows;
	}

	public int deleteUserInfo(Long id) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获取到会话连接对象
		um = session.getMapper(UserMapper.class);// 获取接口实例
		int rows = 0;
		try {
			rows = um.deleteUserInfo(id);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public UserInfo getUserInfoById(Long id) {
		// TODO Auto-generated method stub
		// 查询可以提交或者回滚，可以不提交，对数据库没关系
		SqlSession session = SessionUtils.getSession();// 获取到会话连接对象
		um = session.getMapper(UserMapper.class);
		UserInfo user = null;

		try {
			user = um.getUserInfoById(id);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();

		}

		return user;
	}

	public UserInfo getUserByLoginNameAndPwd(String loginName, String pwd) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获得会话连接对象
		um = session.getMapper(UserMapper.class);// 取得接口的实例
		UserInfo user = null;
		try {
			user = um.getUserByLoginNameAndPwd(loginName, pwd);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return user;

	}

	public List<UserInfo> queryUserListByMap(Map map) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获得会话连接对象
		um = session.getMapper(UserMapper.class);// 取得接口的实例
		List<UserInfo> users = null;
		try {
			users = um.queryUserListByMap(map);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return users;
	}

	public int batchDeleteUserInfo(List<UserInfo> user) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获取到会话连接对象
		um = session.getMapper(UserMapper.class);// 获取接口实例
		int rows = 0;
		try {
			rows = um.batchDeleteUserInfo(user);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public int batchSaveUserInfo(List<UserInfo> user) {
		// TODO Auto-generated method stub
		SqlSession session = SessionUtils.getSession();// 获取到会话连接对象
		um = session.getMapper(UserMapper.class);// 获取接口实例
		int rows = 0;
		try {
			rows = um.batchSaveUserInfo(user);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

}
