package com.yanglei.trueclass;

import java.util.List;

public class Page {
	public Page() {
	}
	private static final long serialVersionUID = 1L;

	// 当前的页码
	private int currentPage;
	// 每页显示的记录数
	private int pageSize;
	// 总页数
	private int totalPage;
	// 总记录数
	private int totalRecord;

	private List<?> data;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		
		return totalPage;
	}

	public void setTotalPage() {
		calc();
	}

	public int getTotalRecord() {
		calc();
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	/**
	 * 用于计算总页数
	 */
	private void calc() {
		int total = this.totalRecord / this.pageSize;
		if (this.totalRecord % this.pageSize == 0) {
			
			this.totalPage = total;
		} else {
			this.totalPage = total + 1;
		}

	}
	

}
