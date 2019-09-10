package com.mylist.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mylist.dao.BoardDAO;

@Service
public class TagService {
	@Inject
	BoardDAO boardDAO;
	
	String regExp = "\\#([0-9a-zA-Z가-힣]*)";
	Pattern compiledPattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
	
	public void inserTag(String str, int boardId) throws Exception {
		Map<String,Object> map;
		Matcher matcher = compiledPattern.matcher(str);
		while (matcher.find()) {
			map = new HashMap<String,Object>();
			map.put("boardId", boardId);
			map.put("tag_name", matcher.group());
			boardDAO.tagInsert(map);
		}
	}
	
	public String toTag(String str) {
		Matcher matcher = compiledPattern.matcher(str);
		String tag;
		String keyword;
		while (matcher.find()) {
			tag = matcher.group();
			keyword = tag.replace("#","%23");
			str = str.replaceFirst(tag, "<a href=\"/mylist/?keyword="+keyword+ "\" class=\"tagSearch\">"+tag+"</a>");
		}
		return str;
	}
}
