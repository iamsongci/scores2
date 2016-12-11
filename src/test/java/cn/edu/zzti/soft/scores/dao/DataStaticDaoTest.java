package cn.edu.zzti.soft.scores.dao;


public class DataStaticDaoTest {
//    private DaoFit dao;
//	private StudentService studentService;
//	private TutorService tutorService;
//	private MachineRoomAdminService machineRoomAdminService;
//	private SuperAdminService superAdminService;
//	private SuperAdminDao superAdminDao;
//
//	@Before
//	public void setUp() throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "classpath:conf/spring-sql.xml",
//						"classpath:conf/spring-mvc.xml" });
//		studentService = (StudentService) context.getBean("studentServiceImpl");
//		tutorService = (TutorService) context.getBean("tutorServiceImpl");
//		machineRoomAdminService = (MachineRoomAdminService) context.getBean("machineRoomAdminServiceImpl");
//		superAdminService = (SuperAdminService) context.getBean("superAdminServiceImpl");
//		superAdminDao = (SuperAdminDao) context.getBean("superAdminDao") ;
//	}
//	
//
//	
//	
//	@Test 
//	public void testUpdateTutorInfoA() {
//		Tutor tutor = new Tutor();
//		tutor.setTutorID("123");
//		tutor.setTutorName("送老师");
//		tutor.setTutorEmail("12312test");
//		tutor.setTutorPhone("12345");
//		tutor.setTutorSex(false);
//		
//		System.out.println(superAdminDao.updateTutorInfoA(tutor));
//	}
//	@Test
//	public void testSelectMachRoomInfo1() {
//		ResultDo resultDo = tutorService.selectMachRoomInfo("20150001");
//		if(resultDo.isSuccess()) {
//			System.out.println(resultDo.isSuccess());
//			MachineRoomAdmInfo machRoomAdmInfo = (MachineRoomAdmInfo) resultDo.getResult();
//			System.out.println(machRoomAdmInfo);
//		}
//	}
//	
//	@Test
//	public void testUpdateStuAssignTutorInfo() {
//		List<StudentAssignTutor> assignInfo = new ArrayList<StudentAssignTutor>();
//		assignInfo.add(new StudentAssignTutor("201560140401", "RB7001038", "20150003"));
//		assignInfo.add(new StudentAssignTutor("201560140402", "RB7001039", "20150005"));
//		ResultDo resultDo = tutorService.updateStuAssignTutorInfo(assignInfo);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testSelectStudentAssignInfo() {
//		ResultDo resultDo = tutorService.selectStudentAssignInfo();
//		System.out.println(resultDo.isSuccess());
//		List<StudentAssignInfo> infoList = (List<StudentAssignInfo>) resultDo.getResult();
//		for (StudentAssignInfo info : infoList) {
//			System.out.println(info);
//		}
//	}
//	
//	@Test
//	public void testSelectClassAssignInfo() {
//		ResultDo resultDo = tutorService.selectClassAssignInfo();
//		System.out.println(resultDo.isSuccess());
//		List<ClassAssignInfo> infoList = (List<ClassAssignInfo>) resultDo.getResult();
//		for (ClassAssignInfo info : infoList) {
//			System.out.println(info);
//		}
//	
//	}
//	
//	@Test
//	public void testSelectTutorAssignInfo() {
//		ResultDo resultDo = tutorService.selectTutorAssignInfo();
//		System.out.println(resultDo.isSuccess());
//		List<TutorAssignInfo> infoList = (List<TutorAssignInfo>) resultDo.getResult();
//		for (TutorAssignInfo info : infoList) {
//			System.out.println(info);
//		}
//	}
//	
//	@Test
//	public void testUpdateTutorPsd() {
//		ResultDo resultDo = tutorService.updateTutorPsd("20150001", "123123");
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testUpdateTutorPhoAndEma() {
//		ResultDo resultDo = tutorService.updateTutorPhoAndEma("20150001", "132123", "123132@qq.com");
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testFindAllStu() {
//		ResultDo resultDo = tutorService.findAllStu("20150001");
//		System.out.println(resultDo.isSuccess());
//		List<StudentInfo> infoList =  (List<StudentInfo>) resultDo.getResult();
//		
//		for (StudentInfo stuInfo : infoList) {
//			System.out.println(stuInfo);
//		}
//	}
//	
//	@Test
//	public void testUpdateStuProScore() {
//		List<StudentTutorProject> proList = new ArrayList<StudentTutorProject>();
//		proList.add(new StudentTutorProject("201560140401", null, "RB7001038", 1, 3, 3, 11));
//		proList.add(new StudentTutorProject("201560140402", "20150002", "RB7001039", 1, 4, 4, 11));
//		ResultDo resultDo = tutorService.updateStuProScore(proList);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testInsertStuProScore() {
//		List<StudentTutorProject> proList = new ArrayList<StudentTutorProject>();
//		proList.add(new StudentTutorProject("21", "123", null, null, 1, 1, 1));
//		proList.add(new StudentTutorProject("123", "423", "34", 1, 1, 1, 1));
//		ResultDo resultDo = tutorService.insertStuProScore(proList);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testUpdateTutorPowerInfo() {
//		List<TutorPower> powerList = new ArrayList<TutorPower>();
//		TutorPower t1 = new TutorPower();
//		TutorPower t2 = new TutorPower();
//		t1.setTutorID("20150001");
//		t2.setTutorID("20150002");
//		t1.setTutorPower1("11111");
//		t2.setTutorPower2("22222");
//		powerList.add(t2);
//		powerList.add(t1);
//		ResultDo resultDo = superAdminService.updateTutorPowerInfo(powerList);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	
//	@Test 
//	public void testUpdateTutorInfo() {
//		List<TutorInfo> infoList = new ArrayList<TutorInfo>();
//		TutorInfo t1 = new TutorInfo();
//		t1.setTutorID("20150001");
//		t1.setTutorName("aaaaa");
//		TutorInfo t2 = new TutorInfo();
//		t2.setTutorID("20150002");
//		t2.setTutorName("bbbb");
//		infoList.add(t2);
//		infoList.add(t1);
//		ResultDo resultDo = superAdminService.updateTutorInfo(infoList);
//	}
//	
//	@Test
//	public void testSelectTutorInfo() {
//		ResultDo resultDo = superAdminService.selectTutorInfo();
//		List<TutorInfo> infoList = (List<TutorInfo>) resultDo.getResult();
//		for (TutorInfo tutorInfo : infoList) {
//			System.out.println(tutorInfo);
//		}
//	}
//	
//	@Test
//	public void testInsertMachChoice() {
//		List<MachineChoice> choiceList = new ArrayList<MachineChoice>();
//		choiceList.add(new MachineChoice("20150003", "103", "1-10"));
//		choiceList.add(new MachineChoice("20150003", "104", "1-10"));
//		ResultDo resultDo = machineRoomAdminService.insertMachChoice(choiceList);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testUpdateMachRoomAdmPhoAndEma() {
//		ResultDo resultDo = machineRoomAdminService.updateMachRoomAdmPhoAndEma("20150001", "2", "2");
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testUpdateMachRoomSeatNum() {
//		List<MachineRoom> roomlist = new ArrayList<MachineRoom>();
//		roomlist.add(new MachineRoom("101", 10));
//		roomlist.add(new MachineRoom("102", 5));
//		ResultDo resultDo = machineRoomAdminService.updateMachRoomSeatNum(roomlist);
//		System.out.println(resultDo.isSuccess());
//	}
//	
//	@Test
//	public void testSelectMachRoomInfo() {
//		ResultDo resultDo = machineRoomAdminService.selectMachRoomInfo();
//		List<MachineRoomInfo> list = (List<MachineRoomInfo>) resultDo.getResult();
//		for (MachineRoomInfo info : list) {
//			System.out.println(info);
//		}
//	}
//
//	@Test
//	public void testStuLogin() {
//		String u = "201560140401";
//		ResultDo<Student> resultDo = studentService.stuLogin(u);
//		System.out.println(resultDo.getResult());
//	}
//	
//	@Test
//	public void testUpdateStuPhone() {
//		ResultDo resultDo = studentService.updateStuPhone("201560140401", "1230011");
//		System.out.println(resultDo.getResult());
//	}
//	@Test
//	public void testUpdateStuPsd() {
//		ResultDo resultDo = studentService.updateStuPsd("201560140401", "1230011");
//		System.out.println(resultDo.getResult());
//	}
//
//	@Test
//	public void testSelectStuProjectInfo() {
//		ResultDo resultDo = studentService.selectStuProjectInfo("201560140401", "RB7001038");
//		System.out.println(resultDo.getResult());
//	}
	
	
}
