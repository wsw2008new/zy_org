package com.zy.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.org.dao.UserDao;
import com.zy.org.entity.User;


@Service
public class UserService extends CommonService<User,String>{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		super.setCommonDao(userDao);
	}
	
	public User findUserByName(String userName){
		User user = null;
		List<User> userList = this.userDao.findUserByName(userName);
		if(userList != null && userList.size() > 0){
			user = userList.get(0);
		}
		return user;
	}
	
	public PageModel<User> queryForPage(Integer currentPage,Integer pageSize){
		return this.userDao.queryForPage(currentPage, pageSize);
	}

	public List<User> findUsers() {
		return userDao.findUsers();
	}
	
}
