package com.hl.sys;

public interface UserMapper {
	
	/**
	 * ���ݵ�¼���Ʋ�ѯ�û�
	 * @param loginName
	 * @return
	 */
	/**����**/
	public void save(User user);
	/**�޸�**/
	public void update(User user);
	/**����**/
	public User find(String username);
	/**ɾ��**/
	public void delete(String username);
	   
	public User getByLoginName(User user);
	
	public User selectUser(String username);

}
