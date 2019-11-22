package com.yanglei.dao;

import java.util.List;

import com.yanglei.trueclass.Film;
import com.yanglei.trueclass.Picture;
import com.yanglei.trueclass.Search;
import com.yanglei.trueclass.User;


public interface IFilmDao {
    public List<Film> query(Search search);
	
	public Film queryById(Integer fid);
	
	public List<Film> queryplus(Search search);
	
	public List<User> queryuser();
	
	public int add(Film film);
	
	public int update(Film film);
	
	public int del(Integer fid);
	
	public int querytt();
	
	public int addpic(Picture picture);
	
	public int addres(Film film);
	
	public int queryty(Search search);
	
	public int addu(User user);
	
	public List<Film> querymore(Search search);
	
	public int querymorett(Search search);

}
