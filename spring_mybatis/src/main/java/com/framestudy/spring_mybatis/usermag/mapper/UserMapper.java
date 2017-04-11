package com.framestudy.spring_mybatis.usermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framestudy.spring_mybatis.usermag.beans.UserInfo;

public interface UserMapper {

	/**
	 * 批量删除用户
	 * @param user
	 * @return
	 */
	public int batchDeleteUserInfo(@Param("users")List<UserInfo> user);
	/**
	 * 批量新增用户
	 * @param user
	 * @return
	 */
	public int batchSaveUserInfo(@Param("users")List<UserInfo> user);
	
	
	/**
	 * 多参数传递的方式：map
	 * @param map
	 * @return
	 */
	
	public List<UserInfo>queryUserListByMap(@Param("map")Map map);
	
	/**
	 * 多参数传递的解决方案 1.对象;2.用MAP集合  都取别名
	 * 通过登录名和密码查看用户
	 * @param loginName
	 * @param pwd
	 * @return
	 */
	public UserInfo getUserByLoginNameAndPwd(@Param("loginName")String loginName,@Param("pwd")String pwd);
	
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int saveUserInfo(UserInfo user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUserInfo(@Param("u")UserInfo user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserInfo(Long id);
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	public UserInfo getUserInfoById(Long id);
}
