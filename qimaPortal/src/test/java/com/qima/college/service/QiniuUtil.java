package com.qima.college.service;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {

	// 设置好账号的ACCESS_KEY和SECRET_KEY
//	String ACCESS_KEY = "kEUR-PJ-onSZZfmXGQcwQ2brvIdXM9y_vjyr18qH"; // 这两个登录七牛 账号里面可以找到
	
//String SECRET_KEY = "PGD8UWHFruc1zMBCybPvVhtnbZXl5rg3V4xThmAM";
	String ACCESS_KEY = "bji1qXorG8LFtLmuy4UID5T5TrxEUyyYHKV_JTGM"; // 这两个登录七牛
	String SECRET_KEY = "n92OhE_CAGUc0KH1jLxYv42gGDSEWVxZBrJ-JcAO";

	// 要上传的空间
	String bucketname = "oc-bucket"; // 对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
	// 上传到七牛后保存的文件名
	String key = "daimo6.png";
	// 上传文件的路径
	String FilePath = "h:/c4.jpg"; // 本地要上传文件路径

	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	Configuration cfg = new Configuration(Zone.zone0());// 设置空间上传域名
	// uploadManager = new UploadManager(cfg);
	// 创建上传对象
	UploadManager uploadManager = new UploadManager(cfg);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	// 普通上传
	public void upload() throws IOException {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(FilePath, key, getUpToken());
			// 打印返回的信息
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}

	public static void main(String args[]) throws IOException {
		new QiniuUtil().upload();
	}

}
