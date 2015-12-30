package com.example.wyunew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 新闻�?
 * 
 * @author Jayin Ton
 * 
 */
public class SchoolNews implements Serializable {
	/**
	 * 新闻来源
	 */
	public String from = "";
	/**
	 * 发布时间
	 */
	public String time = "";
	/**
	 * 新闻标题
	 */
	public String title = "";
	/**
	 * 对应的新闻链�?
	 */
	public String linkPath = "";
	/**
	 * 新闻内容
	 */
	public String content = "";
	/**
	 * 新闻图片链接
	 */
	public List<String> pic = new ArrayList<String>();

	@Override
	public String toString() {
		return "SchoolNews [content=" + content + ", from=" + from
				+ ", linkPath=" + linkPath + ", pic=" + pic.toString()
				+ ", time=" + time + ", title=" + title + "]";
	}

}
