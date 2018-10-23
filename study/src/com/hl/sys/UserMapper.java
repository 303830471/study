package com.hl.sys;

public interface UserMapper {
	
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	/**保存**/
	public void save(User user);
	/**修改**/
	public void update(User user);
	/**查找**/
	public User find(String username);
	/**删除**/
	public void delete(String username);
	   
	public User getByLoginName(User user);
	
	public User selectUser(String username);

}
