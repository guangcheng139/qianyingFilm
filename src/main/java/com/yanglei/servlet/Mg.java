package com.yanglei.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yanglei.dao.UploadDirMgr;
import com.yanglei.server.Filmser;
import com.yanglei.trueclass.Film;
import com.yanglei.trueclass.Page;
import com.yanglei.trueclass.Picture;
import com.yanglei.trueclass.Res;
import com.yanglei.trueclass.Search;
import com.yanglei.trueclass.User;

/**
 * Servlet implementation class Mg
 */
@WebServlet("/Mg")
@MultipartConfig
public class Mg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Filmser fs = new Filmser();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mg() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		System.out.println(type);
		if("query".equals(type)) {
			String currentPage = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			int currentPage_ = 1;
			int pageSize_ = 20;
			if (currentPage != null) {
				try {
					currentPage_ = Integer.parseInt(currentPage);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			if (pageSize != null) {
				try {
					//pageSize_ = Integer.parseInt(pageSize);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			Search s1 = new Search();
			s1.setStart(currentPage_);
			s1.setPageSize(pageSize_);
			Page p1 = new Page();
			List<Film> f1 = fs.query(s1);
			int i =fs.querytt();
			p1.setTotalRecord(i);
			p1.setData(f1);
			p1.setCurrentPage(currentPage_);
			p1.setPageSize(pageSize_);
			p1.setTotalPage();
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			pw.print(gson.toJson(p1));
			System.out.println(gson.toJson(p1));
		}else if("del".equals(type)) {
			String fid = request.getParameter("fid");
			Integer fid_ =Integer.parseInt(fid);
			int i = fs.del(fid_);
			pw.print(i);
		}else if("add".equals(type)) {
			Film film = getf(request);
			int i = fs.add(film);
			Gson gson=new GsonBuilder().create();
			System.out.println(i);
			if(i>1) {
				pw.print(gson.toJson(i));
			}
		}else if("update".equals(type)) {
			Film film =getf(request);
			int i =fs.update(film);
			Gson gson=new GsonBuilder().create();
			System.out.println(i);
			if(i>0) {
				pw.print(gson.toJson(i));
			}
		}else if("addpic".equals(type)){
			
			
			Part p = request.getPart("photo");
			String iid =request.getParameter("picid");
			Integer iid_ = null;
			if (iid != null) {
				try {
					iid_ = Integer.parseInt(iid);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}  
			// 获得上传文件名 
			String submittedFileName = p.getSubmittedFileName();
			System.out.println("submittedFileName:"+submittedFileName);
	
			
			// 获得文件扩展名
			String extName = StringUtils.substringAfter(submittedFileName, ".");
			System.out.println("extName:"+extName);
			
			// 保存至服务器的文件名
			String filename = UUID.randomUUID().toString() + "." + extName;
			System.out.println("filename:"+filename);
			
			
			File target = UploadDirMgr.getFile(filename);
			System.out.println("进行中");

			// 上传文件
			try (InputStream in = p.getInputStream(); OutputStream out = new FileOutputStream(target);

			) {

				IOUtils.copyLarge(in, out);

			}
			System.out.println("图片上传完毕");
			String real = "/p/"+filename;
			Picture picture = new Picture(iid_, submittedFileName, real);
			
			
			int c = fs.addpic(picture);
			pw.print(c);
			System.out.println(c==1?"添加成功":"添加失败");
			
		
		}else if("querybyid".equals(type)) {
			String fid =request.getParameter("fid");
			Integer fid_ =null;
			if (fid != null) {
				try { 
					fid_ = Integer.parseInt(fid);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			Film f1 =fs.queryById(fid_);
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			pw.print(gson.toJson(f1));
		}else if("queryplus".equals(type)) {
			String ftype = request.getParameter("ftype");
			String currentPage = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			int currentPage_ = 1;
			int pageSize_ = 10;
			if (currentPage != null) {
				try {
					currentPage_ = Integer.parseInt(currentPage);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			if (pageSize != null) {
				try {
					//pageSize_ = Integer.parseInt(pageSize);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			Search s1 = new Search();
			s1.setStart(currentPage_);
			s1.setPageSize(pageSize_);
			s1.setSearch(ftype);
			Page p1 = new Page();
			List<Film> f1 =fs.queryplus(s1);
			int i=fs.queryty(s1);
			p1.setTotalRecord(i);
			p1.setData(f1);
			p1.setCurrentPage(currentPage_);
			p1.setPageSize(pageSize_);
			p1.setTotalPage();
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			pw.print(gson.toJson(p1));
			System.out.println("queryplus"+gson.toJson(p1));
		}else if("register".equals(type)) {
			String uname =request.getParameter("uname");
			String password =request.getParameter("password");
			Date d1 = new Date();
			User u1 = new User();
			u1.setU_name(uname);
			u1.setRegdate(d1);
			u1.setPassword(password);
			int i =fs.addu(u1);
			if(i>0) { 
				pw.print(i);
			}
			
		}else if("login".equals(type)) {
			String uname =request.getParameter("uname");
			String password =request.getParameter("password");
			List<User> users = fs.queryuser();
			for (User u : users) {
				if(u.getPassword().equals(password)&&u.getU_name().equals(uname)) {
//					登录成功封装session
					User user = new User();
					user.setU_name(uname);
					user.setPassword(password);
					session.setAttribute("user", user);
					pw.print(1);
				}else {
					pw.print(0);
				} 
			} 
		}else if("querymore".equals(type)) {
			String search =request.getParameter("search");
			String currentPage = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			System.out.println(search);
			int currentPage_ = 1;
			int pageSize_ = 10;
			if (currentPage != null) {
				try {
					currentPage_ = Integer.parseInt(currentPage);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			if (pageSize != null) {
				try {
					//pageSize_ = Integer.parseInt(pageSize);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			Search s1 = new Search();
			s1.setPageSize(pageSize_);
			s1.setStart(currentPage_);
			s1.setSearch(search);
			Page p1 = new Page();
			List<Film> l1 =fs.querymore(s1);
			p1.setData(l1);
			p1.setCurrentPage(currentPage_);
			p1.setPageSize(pageSize_);
			int i = fs.querymorett(s1);
			p1.setTotalRecord(i);
			p1.setTotalPage();
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			pw.print(gson.toJson(p1));
			System.out.println(gson.toJson(p1));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public Film getf(HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fid =request.getParameter("fid");
		String foname = request.getParameter("foname");
		String ftname = request.getParameter("ftname");
		String ftype = request.getParameter("type_value");
		String langue = request.getParameter("langue");
		String origin = request.getParameter("origin");
		String director = request.getParameter("director");
		String browse = request.getParameter("browse");
		String writers = request.getParameter("writers");
		String show = request.getParameter("show");
		String publish = request.getParameter("publish");
		String actor = request.getParameter("actor");
		String intro = request.getParameter("intro");
		String picid = request.getParameter("picid");
		String fres = request.getParameter("fres");
		Integer browse_ =Integer.parseInt(browse);
		Integer fid_ =null;
		Integer picid_=null;
		if (fid != null) {
			try {
				fid_ = Integer.parseInt(fid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		if (picid != null) {
			try {
				picid_ = Integer.parseInt(picid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Date show_ =format.parse(show);
			Date publish_ =format.parse(publish);
			java.sql.Date sqlshow = new java.sql.Date(show_.getTime());
			java.sql.Date sqlpub = new java.sql.Date(publish_.getTime());
			Film f1 = new Film();
			Picture p1 = new Picture();
			Res r1 =new Res();
			f1.setFid(fid_);
			f1.setFoname(foname);
			f1.setActor(actor);
			f1.setBrowse(browse_);
			f1.setFtname(ftname);
			f1.setFtype(ftype);
			f1.setLangue(langue);
			f1.setPublish(publish_);
			f1.setPublish_(sqlpub);
			f1.setWriters(writers);
			f1.setDirector(director);
			f1.setOrigin(origin);
			f1.setIntro(intro);
			f1.setShow(show_);
			f1.setShow_(sqlshow);
			p1.setFid(picid_);
			r1.setRid(picid_);
			r1.setLink(fres);
			f1.setPicture(p1);
			f1.setRes(r1);
			return f1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}

}
