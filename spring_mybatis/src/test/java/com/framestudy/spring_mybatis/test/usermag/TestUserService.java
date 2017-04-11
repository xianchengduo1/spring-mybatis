package com.framestudy.spring_mybatis.test.usermag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.framestudy.spring_mybatis.usermag.beans.UserInfo;
import com.framestudy.spring_mybatis.usermag.service.IUserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestUserService {
	@Resource
	private IUserService userInfoServiceImpl;

	
	@Test
	public void testBatchDeleteUserInfo(){
		List<UserInfo> users = new ArrayList<UserInfo>();
		UserInfo user = new UserInfo();
		//13l这是什么意思
		user.setId(15l);
		UserInfo user2 = new UserInfo();
		user2.setId(16l);
		users.add(user2);
		users.add(user);
		
		int rows = userInfoServiceImpl.batchDeleteUserInfo(users);
		Assert.assertEquals(2, rows);
		
	}
	
	@Ignore
	public void testBatchSaveUserInfo(){
		List<UserInfo> users = new ArrayList<UserInfo>();
		
		UserInfo user = new UserInfo(null, "小马", "h", "123456", 18);
		try {
			UserInfo user2 = (UserInfo) user.clone();
			user2.setLoginName("b");
			UserInfo user3 = (UserInfo) user.clone();
			user3.setLoginName("f");
			UserInfo user4 = (UserInfo) user.clone();
			user4.setLoginName("g");
			
			users.add(user4);
			users.add(user3);
			users.add(user2);
			users.add(user);
			
			int rows = userInfoServiceImpl.batchSaveUserInfo(users);
			Assert.assertEquals(4, rows);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Ignore
	public void testQueryUserListByMap(){
		Map map = new HashMap();
		map.put("userName", "妹");
		map.put("age", 18);
		List<UserInfo> users = userInfoServiceImpl.queryUserListByMap(map);
		Assert.assertNotNull(users);
		System.out.println(users);
		
	}
	
	
	
	@Ignore
	public void testLogin(){
		String name = "a";
		String pwd = "123456";
		UserInfo user = userInfoServiceImpl.getUserByLoginNameAndPwd(name,pwd);
		Assert.assertNotNull(user);
		System.out.println(user);
	}
	
	
	@Ignore
	public void testdeleteUserInfo(){
		//删除与修改之前，都要先查看 
		UserInfo user=userInfoServiceImpl.getUserInfoById(8L);
		//有什么用
		Assert.assertNotNull(user);
		System.out.println(user);
		int rows=userInfoServiceImpl.deleteUserInfo(user.getId());
		Assert.assertEquals(1, rows);
	}
	
	@Ignore
	public void testUpdateUserInfo(){
		UserInfo user= new UserInfo(2l,"大强","344",20);
		userInfoServiceImpl.updateUserInfo(user);
		System.out.println(user);
	}

	@Ignore
	public void testSaveUserInfo(){
		UserInfo user = new UserInfo(null, "小妹", "1236", 18);
		userInfoServiceImpl.saveUserInfo(user);
		System.out.println(user);
	}

}
