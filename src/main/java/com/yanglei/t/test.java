package com.yanglei.t;

import com.yanglei.server.Filmser;
import com.yanglei.trueclass.Picture;

public class test {

	public static void main(String[] args) {

		Filmser fs1 = new Filmser();
		Picture p1 = new Picture();
		p1.setFid(5);
		p1.setFname("1");
		p1.setRealUrl("1");
		System.out.println(fs1.addpic(p1));
		
		
	}

}
