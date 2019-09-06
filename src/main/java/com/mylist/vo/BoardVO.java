package com.mylist.vo;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int boardId;
	private String userId;
	private String userName;
	private int board_cnt;
	private String description;
	private Date board_date;
	private List<MusicVO> music;
	private int like_plag;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public List<MusicVO> getMusic() {
		return music;
	}
	public void setMusic(List<MusicVO> music) {
		this.music = music;
	}
	public int getLike_plag() {
		return like_plag;
	}
	public void setLike_plag(int like_plag) {
		this.like_plag = like_plag;
	}

}
