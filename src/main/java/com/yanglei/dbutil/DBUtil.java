package com.yanglei.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * �������ݿ�����ӣ�ͬʱ�ṩ�ر���Դ�ķ���
 * 
 * @author �¹�������
 *
 */
public class DBUtil {
	private static ResourceBundle rb = ResourceBundle.getBundle("com/yanglei/dbutil/jdbc");
	//Ĭ�ϵ������ַ���
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	//Ĭ�ϵ������ַ���
	private static String URL ="jdbc:mysql://127.0.0.1:3306/yanglei?useSSl=false&serverTimezone=UTC";
	//Ĭ�ϵ��û���
	private static String USER = "root";
	//Ĭ�ϵ�����
	private static String PASSWORD = "148149";
	static {
		DRIVER = rb.getString("jdbc.driver");
		URL=rb.getString("jdbc.url");
		USER=rb.getString("jdbc.user");
		PASSWORD=rb.getString("jdbc.password");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private DBUtil(){
		
	}
	/**
	 * ���ڵõ����ݿ������
	 */
	public static Connection getConnection(String url,String user,String password){
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * ʹ��Ĭ�ϵĲ���������ݿ������
	 */
	public static Connection getConnection(){
		return getConnection(URL, USER, PASSWORD);
	}
	/**
	 * �ر���Դ
	 */
	public static void close(ResultSet rs,Statement stmt,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(1);
	}
}
