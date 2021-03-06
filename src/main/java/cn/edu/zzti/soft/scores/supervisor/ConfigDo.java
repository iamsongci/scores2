package cn.edu.zzti.soft.scores.supervisor;

public interface ConfigDo {
    public final String AppsName = "实践课题管理系统";

    public final String AdminUser = "zzti";

    public final String AdminPwd = "zzti00";
    
    /*
     * 一级导航栏
     */
    /**
     * 空页面
     */
	public static final String EMPTY="empty";
    /**
     * 首页
     */
	public static final String INDEX="index";
	/**
     * 学生端------课题信息
     */
	public static final String STUSUBJECTINFO="stuSubjectInfo";
	/**
     * 学生端------日报
     */
	public static final String STUREPORT="stuReport";
	/**
     * 学生端------文件模板
     */
	public static final String STUMOULD="stuMould";
	/**
     * 学生端------个人信息
     */
	public static final String STUINFO="stuInfo";
	 /**
     * 超级管理员端------通知管理
     */
	public static final String SUPNOTIFY="supNotify";
    /**
     * 超级管理员端------导师管理
     */
	public static final String SUPTUTOR="supTutor";
	 /**
     * 超级管理员端------系统权限分配
     */
	public static final String SUPPOWER="supPower";
	/**
     * 导师端------个人信息
     */
	public static final String TEAINFO="teaInfo";
	
	/**
	 * 机房管理员端-------个人信息
	 */
	public static final String MRTEAINFO="mrTeaInfo";

	/**
	 * 机房管理员端-------机房信息
	 */
	public static final String MRINFO="mrInfo";
	
	/**
	 * 机房管理员端-------机房分配
	 */
	public static final String MRASSIGN="mrAssign";
	
	
	/*
     * 二级导航栏
     */
	/**
     * 超级管理员端------发布通知
     */
	public static final String SUPNOTIFYPUBLISH="supNotifyPublish";
	
	/**
     * 超级管理员端------通知历史
     */
	public static final String SUPNOTIFYHISTORY="supNotifyHistory";
	/**
     * 超级管理员端------导师信息查看
     */
	public static final String SUPTUTORINFO="supTutorInfo";
	/**
     * 超级管理员端------导师权限分配
     */
	public static final String SUPTUTORPOWER="supTutorPower";
	
	
	
	
}
