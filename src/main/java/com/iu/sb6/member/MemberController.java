package com.iu.sb6.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberDelete")
	public String setMemberDelete(HttpSession session) throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberService.memberDelete(memberVO);
		session.invalidate();
		
		return "redirect:../";
		
	}
	
	@GetMapping("memberJoin")
	public void setInsert(MemberVO memberVO) throws Exception{
		System.out.println("Join");
			
	}
	
	@PostMapping("memberJoin")
	public void setMemberJoin(MemberVO memberVO, MultipartFile file) throws Exception{
		memberService.save(memberVO);
	}
	
	
	
	@GetMapping("memberLogOut")
	public String getMemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
		
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{

	}
	
	@PostMapping("memberLogin")
	public String getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.getMemberLogin(memberVO);
		
		if (memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		
		return "redirect:../";
		
	}
	
	
	
	@GetMapping("memberPage")
	public void getMemberPage() throws Exception{
		
		
	}
	

}
