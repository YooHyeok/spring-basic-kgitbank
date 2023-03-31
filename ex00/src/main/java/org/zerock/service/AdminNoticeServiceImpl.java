package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.AdminNoticeDAO;
import org.zerock.vo.NoticeVO;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {
	@Autowired
	private AdminNoticeDAO adminNoticeDao;

	@Override
	public void insertN(NoticeVO n) {
		this.adminNoticeDao.insertNotice(n);
	}
	
	
}
