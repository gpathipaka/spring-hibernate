package com.java.other;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SpringABC implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public void destroy() throws Exception {
		
	}

}
