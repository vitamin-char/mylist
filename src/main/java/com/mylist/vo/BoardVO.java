package com.mylist.vo;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int boardId;
	private String userId;
	private int board_cnt;
	private String description;
	private Date board_date;
	private String[] music_title;
	private String[] music_singer;
	private List<MusicVO> music;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String[] getMusic_title() {
		return music_title;
	}
	public void setMusic_title(String[] music_title) {
		this.music_title = music_title;
	}
	public String[] getMusic_singer() {
		return music_singer;
	}
	public void setMusic_singer(String[] music_singer) {
		this.music_singer = music_singer;
	}
	public List<MusicVO> getMusic() {
		return music;
	}
	public void setMusic(List<MusicVO> music) {
		this.music = music;
	}


}
