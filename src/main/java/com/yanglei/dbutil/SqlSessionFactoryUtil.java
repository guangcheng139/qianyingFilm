package com.yanglei.dbutil;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	private static final String CONFIG_XML = "configuration.xml";
	private static SqlSessionFactory sqlSessionFactory=createSessionFactory();
	private static SqlSessionFactory createSessionFactory() {
		try {
			
			// ����mybatis�����ļ�
			Reader reader = Resources.getResourceAsReader(CONFIG_XML);
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			return sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �õ�SqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory  getSqlSessionFactory(){
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		System.out.println(sqlSessionFactory.openSession().getConnection());
	}

}