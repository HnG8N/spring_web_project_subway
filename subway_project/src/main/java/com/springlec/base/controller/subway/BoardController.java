package com.springlec.base.controller.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.model.BoardDTO;
import com.springlec.base.model.CommentDto;
import com.springlec.base.service.BoardDAOService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAOService service;
	
	//게시판 검색
	@GetMapping("/board/list")
	public String blist(Model model) throws Exception{
		List<BoardDTO> blistDao= service.blistDao();
		model.addAttribute("list",blistDao);
		return "/board/list";
	}
	
	//게시판 입력 화면
	@GetMapping("/board/write_view")
	public String writeview() throws Exception{
		return "/board/write_view";
		}
	
	//게시판 입력 실행
	@PostMapping("/board/write")//jsp에 action에 있는 값. Post를 확인 바람.
	public String write(HttpServletRequest request) throws Exception{ 
		service.writeDao(request.getParameter("bmID"),request.getParameter("boTitle"), request.getParameter("boContent"));
		return "redirect:/board/list"; // 해당 경로로 이동한다.
		}
	
	//게시판 보기 실행	
	@GetMapping("/board/content_view")//jsp에서 받는 값
	public String contentview(HttpServletRequest request, Model model) throws Exception {
	    // 서비스를 통해 데이터를 가져와서 모델에 추가
	    BoardDTO data = service.viewDao(request.getParameter("boardID"));
	    model.addAttribute("content_view", data); // "content_view"라는 이름으로 모델에 데이터 추가. jsp 파일에 ${content_view.bId}로 명명.
	    
	    List<CommentDto> commentData = service.commentList(request.getParameter("boardID"));
	    model.addAttribute("comment_view", commentData);
	    
	    int commentGroup = service.commentGroup(request.getParameter("boardID"));
	    model.addAttribute("comment_group", commentGroup);
	    
	    return "/board/content_view"; //보내줌
	}
	
	// Update_view 화면
	@PostMapping("/board/update_view")// 보여주는 화면
	public String update_view(HttpServletRequest request, Model model) throws Exception {
		BoardDTO data = service.viewDao(request.getParameter("boardID"));
		model.addAttribute("update_view", data);
		
		return "/board/update_view";
	}
	
	//게시판 수정
	@PostMapping("/board/update")//jsp에서 ation으로 보내주는 값.
	public String update(HttpServletRequest request) throws Exception{
		service.updateDao(request.getParameter("boardID"), request.getParameter("boTitle"), request.getParameter("boContent"));
		return "redirect:/board/list"; // 윗쪽 컨트롤러로 올라간다.
	}
	
	// 삭제 
	@GetMapping("/board/delete")
	public String delelte(HttpServletRequest request) throws Exception{
		service.deleteMDao(request.getParameter("boardID"));
		return "redirect:/board/list";
	}
	
	// 주소록 조건 검색, lsit에서 검색 버튼을 눌렀을때
	@PostMapping("/board/listQuery")
	public String listQuery(HttpServletRequest request, Model model) throws Exception {
		List<BoardDTO> listDao = service.listQuery(request.getParameter("query"), request.getParameter("content"));
		//BoardDTO 목록 바꿔줌.
		model.addAttribute("list", listDao); //list의 위의 변수명과 같아야함.
		return "/board/list";// list.jsp로 보냄. 
	}
	
	@PostMapping("/board/reply")
	public String reply(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		
		String boardID = request.getParameter("boardID");
		int commentGroup = Integer.parseInt(request.getParameter("commentGroup"));
		HttpSession session = request.getSession();
		String commentuserid = (String)session.getAttribute("userId");
		int commentLevel = Integer.parseInt(request.getParameter("commentLevel")) + 1;
		
		service.commentInsert(
				request.getParameter("postId"), 
				commentuserid, 
				request.getParameter("commentContent"), 
				request.getParameter("commentId"),
				commentGroup,
				commentLevel);
        
		redirectAttributes.addAttribute("boardID", boardID);
		
		return "redirect:/board/content_view";
	}
	
	@PostMapping("/board/comment")
	public String comment(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		String postId = request.getParameter("postId");
		
		HttpSession session = request.getSession();
		String commentuserid = (String)session.getAttribute("userId");
		
		String commentContent = request.getParameter("commentContent");
		
		String commentParentId = "0";
		
		int commentGroup = Integer.parseInt(request.getParameter("commentGroup")) + 1;

		int commentLevel = 0;
		
		service.commentInsert(postId, commentuserid, commentContent, commentParentId, commentGroup, commentLevel);
		
		redirectAttributes.addAttribute("boardID", postId);
		
		return "redirect:/board/content_view";
	}
	
	@PostMapping("/board/replyUpdate")
	public String replyUpdate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		String postId = request.getParameter("postId");
		
		String commentContent = request.getParameter("commentContent");
		
		String commentId = request.getParameter("commentId");
		
		service.commentUpdate(commentContent, commentId);
		
		redirectAttributes.addAttribute("boardID", postId);
		
		return "redirect:/board/content_view";
	}
	
	@GetMapping("/board/commentdelete")
	public String commentdelete(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		String postId = request.getParameter("postId");
		
		String commentId = request.getParameter("commentId");
		
		service.commentDelete(commentId);
		
		redirectAttributes.addAttribute("boardID", postId);
		
		return "redirect:/board/content_view";
	}
}
