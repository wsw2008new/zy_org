package com.zy.org.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.org.entity.User;

public class UserRoleRelDaoImpl extends CustomBaseSqlDaoImpl implements UserRoleRelCustomDao{

	/**
	 * 根据角色ID和用户名查找用户
	 * @param roleId
	 * @param name
	 * @return
	 */
	public List<User> findUserListByRoleCondition(String roleId,String name){
		String hql="select urr.user from UserRoleRel urr where 1=1 ";
		if(StringUtils.isNotBlank(roleId)){
			hql+=" and urr.role.id = '"+roleId+"' ";
		}
		if(StringUtils.isNotBlank(name)){
			hql+=" and urr.user.realName like '%"+name+"%' ";
		}
		return this.queryForList(hql);
	}

	@Override
	public void deleteRoleByUserId(String userId) {
		String sql = "delete from org_user_role_rel where user_id='"+userId+"'";
		this.executeSql(sql, null);
	}
}
