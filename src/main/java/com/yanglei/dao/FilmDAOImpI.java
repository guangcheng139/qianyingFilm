package com.yanglei.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yanglei.dbutil.SqlSessionFactoryUtil;
import com.yanglei.trueclass.Film;
import com.yanglei.trueclass.Picture;
import com.yanglei.trueclass.Search;
import com.yanglei.trueclass.User;

public class FilmDAOImpI implements IFilmDao {
	private SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();

	@Override
	public List<Film> query(Search search) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int start = (search.getStart() - 1) * search.getPageSize();
		search.setStart(start);
		List<Film> films = dao.query(search);
		// ¹Ø±ÕSqlSession
		sqlSession.close();
		return films;
	}

	@Override
	public Film queryById(Integer fid) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		Film film = dao.queryById(fid);
		// ¹Ø±ÕSqlSession
		sqlSession.close();
		return film;
	}

	@Override
	public int add(Film film) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.add(film);
		int j =addres(film);
		sqlSession.close();
		return i+j;
	}

	@Override
	public int update(Film film) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.update(film);
		sqlSession.close();
		return i;
	}

	@Override
	public int del(Integer fid) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.del(fid);
		sqlSession.close();
		return i;
	}

	@Override
	public int querytt() {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.querytt();
		sqlSession.close();
		return i;
	}

	@Override
	public int addpic(Picture picture) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.addpic(picture);
		sqlSession.close();
		return i;
	}

	@Override
	public int addres(Film film) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.addres(film);
		sqlSession.close();
		return i;
	}

	@Override
	public List<Film> queryplus(Search search) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int start = (search.getStart() - 1) * search.getPageSize();
		search.setStart(start);
		List<Film> f=dao.queryplus(search);
		sqlSession.close();
		return f;
	}

	@Override
	public int queryty(Search search) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.queryty(search);
		sqlSession.close();
		return i;
	}

	@Override
	public int addu(User user) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int i =dao.addu(user);
		sqlSession.close();
		return i;
	}

	@Override
	public List<User> queryuser() {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		List<User> u1 = dao.queryuser();
		return u1;
	}

	@Override
	public List<Film> querymore(Search search) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int start = (search.getStart() - 1) * search.getPageSize();
		search.setStart(start);
		List<Film> f=dao.querymore(search);
		sqlSession.close();
		return f;
	}

	@Override
	public int querymorett(Search search) {
		SqlSession sqlSession = sf.openSession(true);
		IFilmDao dao = sqlSession.getMapper(IFilmDao.class);
		int start = (search.getStart() - 1) * search.getPageSize();
		int i =dao.querymorett(search);
		sqlSession.close();
		return i;
	}
	

}
