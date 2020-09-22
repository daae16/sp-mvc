package com.sp.mvc.dao;

import com.sp.mvc.vo.TestVO;

public interface TestDAO {

	int insertTest(TestVO tvo);
	TestVO doLogin (TestVO tvo);
}
