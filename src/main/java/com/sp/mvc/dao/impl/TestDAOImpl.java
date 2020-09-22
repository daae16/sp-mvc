package com.sp.mvc.dao.impl;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.mvc.dao.TestDAO;
import com.sp.mvc.vo.TestVO;

@Repository
public class TestDAOImpl implements TestDAO {

	private BasicDataSource bds;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	public int insertTest(TestVO tvo) {
		try(SqlSession ss = ssf.openSession()){
			int result = ss.insert("test.insertTest",tvo);
			ss.commit();
			return result;
		}
	}

	@Override
	public TestVO doLogin(TestVO tvo) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectOne("test.selectTest",tvo);
			
		}
	}

}
