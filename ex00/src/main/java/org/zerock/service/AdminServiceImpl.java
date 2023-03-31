package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.AdminDAO;
import org.zerock.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;

	@Override
	public AdminVO admin_Login(String admin_id) {
		return this.adminDao.admin_Login(admin_id);
	}
}
