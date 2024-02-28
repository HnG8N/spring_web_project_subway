package com.springlec.base.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.springlec.base.dao.BoardDAO;
import com.springlec.base.model.BoardDTO;
import com.springlec.base.model.CommentDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardDAOServiceImpl implements BoardDAOService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> blistDao() throws Exception {
		return dao.blistDao();
	}

	@Override
	public void writeDao(String bmID, String boTitle, String boContent) throws Exception {
		// TODO Auto-generated method stub
		dao.writeDao(bmID, boTitle, boContent);
		
	}

	@Override
	public BoardDTO viewDao(String boardID) throws Exception {
		dao.boardHitUpdate(boardID);
		return dao.viewDao(boardID);
	}

	@Override
	public void updateDao(String boardID, String boTitle, String boContent) throws Exception {
		// TODO Auto-generated method stub
		dao.updateDao(boardID, boTitle, boContent);
		
	}

	@Override
	public void deleteMDao(String boardID) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteMDao(boardID);
	}

	@Override
	public List<BoardDTO> listQuery(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		// 쿼리문에 like를 사용하기 위해서. 위의 ADto 바꿔줌.
		content ='%'+content+'%';	
		return dao.listQuery(query, content);
	}

	@Override
	public List<CommentDto> commentList(String boardID) throws Exception {
		
		List<Integer> integer = Arrays.asList(1, 2, 3, 4, 5);
		
		List<CommentDto> list = dao.commentList(boardID);
		
		// 게시판 댓글 순서 정렬 기능
		for (int i = 0; i < list.size(); i++) {
		    int commentId = list.get(i).getCommentid();

		    for (int j = list.size()-1; j >= i + 1; j--) {
		        if (list.get(j).getCommentparentid() == commentId) {
		            // 같은 parentId를 가진 댓글 발견
		            list.add(i+1, list.remove(j));
		        }
		    }
		}

		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).getCommentid() + "\t");
			System.out.print(list.get(i).getCommentparentid() + "\t");
			System.out.print(list.get(i).getCommentlevel() + "\t");
			System.out.println(list.get(i).getCommentgroup());
		}
		System.out.println("**********************************");
		
		
		
		
		
		return dao.commentList(boardID);
	}

	@Override
	public void commentInsert(
			String postId, String commentuserid, String commentcontent, 
			String commentId, int commentGroup, int commentLevel)
			throws Exception {
		dao.commentInsert(postId, commentuserid, commentcontent, commentId, commentGroup, commentLevel);
		
	}

	@Override
	public Integer commentGroup(String boardID) throws Exception {
		
		Integer commentGroupDao = dao.commentGroup(boardID); // Integer로 선언하여 null 값을 받을 수 있도록 함
		int commentGroup = commentGroupDao != null ? commentGroupDao : 0; // null일 경우 기본값 설정

		return commentGroup;
	}

	@Override
	public void commentUpdate(String commentContent, String commentId) throws Exception {
		dao.commentUpdate(commentContent, commentId);
	}

	@Override
	public void commentDelete(String commentId) throws Exception {
		dao.commentDelete(commentId);
	}

}
