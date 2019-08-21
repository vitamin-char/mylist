package com.vitaminchar.mylist.vo;

public class MusicVO {
	private int IDX;
	private String boardId;
	private String music_title;
	private String music_singer;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getMusic_title() {
		return music_title;
	}
	public void setMusic_title(String music_title) {
		this.music_title = music_title;
	}
	public String getMusic_singer() {
		return music_singer;
	}
	public void setMusic_singer(String music_singer) {
		this.music_singer = music_singer;
	}

}
