package com.yanglei.server;

import java.util.List;

import com.yanglei.dao.FilmDAOImpI;
import com.yanglei.trueclass.Film;
import com.yanglei.trueclass.Picture;
import com.yanglei.trueclass.Search;
import com.yanglei.trueclass.User;

public class Filmser {
	private FilmDAOImpI dao;
	public Filmser() {
		this.dao=new FilmDAOImpI();
	}
	public List<Film> query(Search search) {
		return dao.query(search);
	}

	public Film queryById(Integer fid) {
		return dao.queryById(fid);
	}

	public int add(Film film) {
		return dao.add(film);
	}

	public int update(Film film) {
		return dao.update(film);
	}

	public int del(Integer fid) {
		return dao.del(fid);
	}
	
	public int querytt() {
		return dao.querytt();
	}
	
	public int addpic(Picture picture) {
		return dao.addpic(picture);
	}
	
	public List<Film> queryplus(Search search){
		return dao.queryplus(search);
	}
	
	public int queryty(Search search) {
		return dao.queryty(search);
	}
	
	public int addu(User user) {
		return dao.addu(user);
	}
	
	public List<User> queryuser(){
		return dao.queryuser();
	}
	
	public List<Film> querymore(Search search){
		return dao.querymore(search);
	}
	
	public int querymorett(Search search) {
		return dao.querymorett(search);
	}

}
