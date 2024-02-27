package com.springlec.base.model;

public class CommentDto {
	
	int commentid;
	int commentpostid;
	String commentuserid;
	String commentcontent;
	String commentdate;
	int commentparentid;
	int commentgroup;
	int commentlevel;
	int commentdelete;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getCommentpostid() {
		return commentpostid;
	}

	public void setCommentpostid(int commentpostid) {
		this.commentpostid = commentpostid;
	}

	public String getCommentuserid() {
		return commentuserid;
	}

	public void setCommentuserid(String commentuserid) {
		this.commentuserid = commentuserid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public String getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}

	public int getCommentparentid() {
		return commentparentid;
	}

	public void setCommentparentid(int commentparentid) {
		this.commentparentid = commentparentid;
	}

	public int getCommentgroup() {
		return commentgroup;
	}

	public void setCommentgroup(int commentgroup) {
		this.commentgroup = commentgroup;
	}

	public int getCommentlevel() {
		return commentlevel;
	}

	public void setCommentlevel(int commentlevel) {
		this.commentlevel = commentlevel;
	}

	public int getCommentdelete() {
		return commentdelete;
	}

	public void setCommentdelete(int commentdelete) {
		this.commentdelete = commentdelete;
	}
	
}
