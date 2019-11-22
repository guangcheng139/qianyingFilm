package com.yanglei.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 用于数据库的连接，同时提供关闭资源的方法
 * 
 * @author 月光照铁衣
 *
 */
public class DBUtil {
	private static ResourceBundle rb = ResourceBundle.getBundle("com/yanglei/dbutil/jdbc");
	//默认的驱动字符串
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	//默认的连接字符串
	private static String URL ="jdbc:mysql://127.0.0.1:3306/yanglei?useSSl=false&serverTimezone=UTC";
	//默认的用户名
	private static String USER = "root";
	//默认的密码
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
	 * 用于得到数据库的连接
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
	 * 使用默认的参数获得数据库的连接
	 */
	public static Connection getConnection(){
		return getConnection(URL, USER, PASSWORD);
	}
	/**
	 * 关闭资源
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
