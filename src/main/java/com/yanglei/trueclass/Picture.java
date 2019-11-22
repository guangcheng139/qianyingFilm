package com.yanglei.trueclass;

import java.io.Serializable;

public class Picture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Integer fid;
		private String fname;
		
		private String realUrl;
		
		
		public Picture() {
			
		}
		
		
		public Picture(Integer fid, String fname, String realUrl) {
			this.fid = fid;
			this.fname = fname;
			
			this.realUrl = realUrl;
		}



		public Integer getFid() {
			return fid;
		}
		public void setFid(Integer fid) {
			this.fid = fid;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		
		public String getRealUrl() {
			return realUrl;
		}
		public void setRealUrl(String realUrl) {
			this.realUrl = realUrl;
		}


		@Override
		public String toString() {
			return "Picture [fid=" + fid + ", fname=" + fname + ", realUrl=" + realUrl + "]";
		}
		
		
}
