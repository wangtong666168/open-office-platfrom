package com.open.gather.core.log.service.impl;

import com.open.gather.core.annotation.datasource.DataSource;
import com.open.gather.core.log.mapper.LogMapper;
import com.open.gather.core.log.service.LogService;
import com.open.gather.core.model.log.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logDao;

	@Async
	@Override
	@DataSource(name="log")
	public void save(SysLog log) {
		if (log.getCreateTime() == null) {
			log.setCreateTime(new Date());
		}
		if (log.getFlag() == null) {
			log.setFlag(Boolean.TRUE);
		}

		logDao.save(log);
	}

	 
}
