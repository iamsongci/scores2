package cn.edu.zzti.soft.scores.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zzti.soft.scores.supervisor.DaoFit;
import cn.edu.zzti.soft.scores.supervisor.ServiceFit;


public class DataStaticServiceTest {
	private ServiceFit serviceFit;
	private DaoFit daofit;
	private SuperAdminDao superAdminDao;
	//@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-sql.xml",
						"classpath:conf/spring-mvc.xml" });
		superAdminDao = (SuperAdminDao) context
				.getBean("SuperAdminDao");

	}

}
