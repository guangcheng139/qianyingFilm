package com.yanglei.trueclass;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable{
	public Film() {
	}
	private Integer fid;
	private String foname;
	private String ftname;
	private String intro;
	private Date show;
	private Date publish;
	private String origin;
	private String langue;
	private String director;
	private String actor;
	private Integer browse;
	private String ftype;
	private String writers;
	private java.sql.Date show_;
	private java.sql.Date publish_;
	private Res res;
	private Picture picture;
	
	
	
	public Film(Integer fid, String foname, String ftname, String intro, Date show, Date publish, String origin,
			String langue, String director, String actor, Integer browse, String ftype, String writers,
			java.sql.Date show_, java.sql.Date publish_, Res res, Picture picture) {
		super();
		this.fid = fid;
		this.foname = foname;
		this.ftname = ftname;
		this.intro = intro;
		this.show = show;
		this.publish = publish;
		this.origin = origin;
		this.langue = langue;
		this.director = director;
		this.actor = actor;
		this.browse = browse;
		this.ftype = ftype;
		this.writers = writers;
		this.show_ = show_;
		this.publish_ = publish_;
		this.res = res;
		this.picture = picture;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFoname() {
		return foname;
	}
	public void setFoname(String foname) {
		this.foname = foname;
	}
	public String getFtname() {
		return ftname;
	}
	public void setFtname(String ftname) {
		this.ftname = ftname;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getShow() {
		return show;
	}
	public void setShow(Date show) {
		this.show = show;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Integer getBrowse() {
		return browse;
	}
	public void setBrowse(Integer browse) {
		this.browse = browse;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getWriters() {
		return writers;
	}
	public void setWriters(String writers) {
		this.writers = writers;
	}
	public java.sql.Date getShow_() {
		return show_;
	}
	public void setShow_(java.sql.Date show_) {
		this.show_ = show_;
	}
	public java.sql.Date getPublish_() {
		return publish_;
	}
	public void setPublish_(java.sql.Date publish_) {
		this.publish_ = publish_;
	}
	public Res getRes() {
		return res;
	}
	public void setRes(Res res) {
		this.res = res;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	
	
	

}
