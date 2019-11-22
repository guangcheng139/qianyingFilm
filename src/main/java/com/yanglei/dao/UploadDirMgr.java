package com.yanglei.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class UploadDirMgr {
	static ResourceBundle rb = ResourceBundle.getBundle("upload");
	// �ļ��ϴ��ĸ�Ŀ¼
	static File folder = null;
	
	static {
		String path = rb.getString("upload.dir");
		folder = new File(path);
	}
	
	private UploadDirMgr() {

	}

	/**
	 * ��ȡ�ļ��ϴ���Ŀ¼
	 * 
	 * @return
	 */
	public static File getUploadDir() {
		return folder;
	}

	/**
	 * ��ȡͼƬ�������File����
	 * 
	 * @param imgname
	 *            e.g: aad929ae-530d-4941-a345-b08126d4fb40.jpg
	 * @return
	 */
	public static File getFile(String imgname) {
		File file = new File(folder, imgname);
		return file;
	}
	/**
	 * ��ȡͼƬ�������InputStream
	 * @param imgname
	 * @return
	 */
	public static InputStream getInputStream(String imgname) {
		InputStream in=null;
		try {
			in = new FileInputStream(getFile(imgname));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
}
