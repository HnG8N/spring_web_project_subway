package com.springlec.base.dao;

import java.util.List;


import com.springlec.base.model.BoardDTO;
import com.springlec.base.model.CommentDto;

public interface BoardDAO {

	public List<BoardDTO> blistDao() throws Exception;

	public void writeDao(String bmID, String boTitle, String boContent) throws Exception; 

	public BoardDTO viewDao(String boardID) throws Exception;
	
	public void boardHitUpdate(String boardID) throws Exception;
	
	public void updateDao(String boardID, String boTitle, String boContent) throws Exception;
	
	public void deleteMDao(String boardID) throws Exception;
	
	public List<BoardDTO> listQuery(String query, String content) throws Exception;
	
	public List<CommentDto> commentList(String boardID) throws Exception;
	
	public Integer commentGroup(String boardID) throws Exception;
	
	public void commentInsert(String postId, String commentuserid,
			String commentcontent, String commentId, int commentGroup, int commentLevel) throws Exception;

	public void commentUpdate(
			String commentContent, String commentId)throws Exception;

	public void commentDelete(String commentId)throws Exception;
}
