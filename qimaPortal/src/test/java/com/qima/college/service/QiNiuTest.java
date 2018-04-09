package com.qima.college.service;


import java.io.File;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.qima.college.common.storage.QiniuStorage;
import com.qima.college.common.storage.ThumbModel;
import com.qima.college.common.util.CommonUtil;

public class QiNiuTest extends TestCase {
	//Logger log = Logger.getLogger(AppTest.class);
	
	public void testImages() {
		//测试上传图片
		byte[] buff = CommonUtil.getFileBytes(new File("F:/workspaces/arongdaeduworkspace/qimaO/WebContent/static/images/hehaibo.jpg"));
		String key = QiniuStorage.uploadImage(buff);
		System.out.println("key = " + key);
		
		//String key = "/default/all/0/82e354da0a784540835f7663ab98cfa3.jpeg";
		//测试下载图片
		String url = QiniuStorage.getUrl(key);
		System.out.println("url = " + url);
		
		//测试下载不同大小的图片
		url = QiniuStorage.getUrl(key,ThumbModel.THUMB_256);
		System.out.println("url = " + url);
		
	}
}

