package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.security.AuthenticateUser;

@Service
@Transactional
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {

	@Autowired
	private UserCredentialsDao userCredentialsDao;

	@Autowired
	private AuthenticateUser authUser;

	public void save(UserCredentials userCredentials) {
		userCredentialsDao.save(userCredentials);
	}

	public void update(UserCredentials userCredentials) {
		userCredentialsDao.update(userCredentials);
	}

	public List<UserCredentials> findAll() {
		return (List<UserCredentials>) userCredentialsDao.findAll();
	}

	public UserCredentials findOne(Long id) {
		return userCredentialsDao.findOne(id);
	}

	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

	public Boolean authenticate(String userName, String pass) {
		return authUser.authenticate(userName, pass);
	}
}