package net.gondr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;
import net.gondr.domain.yySampleVO;
import net.gondr.domain.yySampleVO2;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserDAO dao;
	
	@RequestMapping(value="regist", method=RequestMethod.GET)
	public String viewRegistPage() {
		return "user/regist";
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registProcess(yySampleVO user) {
		return "redirect:/world/" + user.getUserid();
	}
	
	@RequestMapping(value="regist2", method=RequestMethod.GET)
	public String RegistPage() {
		return "user/regist2";
	}
	
	@RequestMapping(value="regist2", method=RequestMethod.POST)
	public String registPro(yySampleVO2 user, Model model) {
		model.addAttribute("user", user);
		if(user.getId() == "" || user.getEmail() == "" || user.getName() == "" || user.getPass() == "" || user.getPassCheck() == "") {
			return "redirect:/user/regist2";
		}
		if(!user.getPass().equals(user.getPassCheck())) {
			return "redirect:/user/regist2";
		}
		return "all";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String viewLoginPage() {
		return "user/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginProcess(UserVO user, HttpSession session) {
		if(dao.selectUser(user.getUserid()) == null) {
			session.setAttribute("text", "아이디와 비밀번호가 일치하지 않습니다.");
			return "redirect:/user/login";
		} else if(!dao.selectUser(user.getUserid()).getPassword().equals(user.getPassword())) {
			session.setAttribute("text", "아이디와 비밀번호가 일치하지 않습니다.");
			return "redirect:/user/login";
		} else {
			session.setAttribute("user", user);
			return "redirect:/"; // 메인페이지로 이동
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logoutPage(HttpSession session) {
		session.removeAttribute("user");
		session.setAttribute("text", "로그아웃 되었습니다.");
		return "redirect:/";
	}
	
	@RequestMapping(value="info", method=RequestMethod.GET)
	public String viewInfoPage(HttpSession session) {
		return "user/info";
	}
	
	@RequestMapping(value="data/{userid}", method=RequestMethod.GET)
	public @ResponseBody UserVO getUserData(@PathVariable String userid) {
		UserVO vo = dao.selectUser(userid);
		if(vo != null) {
			return vo;
		}
		return null;
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerPage() {
		return "user/register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(UserVO vo, HttpSession session) {
		if(vo.getUserid() == "" || vo.getUsername() == "" || vo.getPassword() == "" || vo.getPassword2() == "") {
			session.setAttribute("text",  "빈값이 존재합니다.");
			System.out.println("없음");
			return "redirect:/user/register";
		} else if(!vo.getPassword().equals(vo.getPassword2())) {
			session.setAttribute("text",  "비밀번호와 비밀번호 확인이 다릅니다.");
			return "redirect:/user/register";
		} else if(dao.selectUser(vo.getUserid()) != null) {
			session.setAttribute("text",  "아이디가 중복입니다.");
			return "redirect:/user/register";
		}
		UserVO user = new UserVO(); 
		user.setUserid(vo.getUserid());
		user.setPassword(vo.getPassword());
		user.setUsername(vo.getUsername()); 
		dao.insertUser(user);
		return "redirect:/user/register";
//		return "user/info/" + vo.getUserid();
	}
}


// 주소는 user/regist2이고
// 접근시 아이디, 비번, 비번확인, 이름, 이메일을 입력하는 폼이 나오고
// 전송을 누르면
// 처리해서 공백이 있는지 확인하여 공백이 있을 경우 다시 user/regist2로 보내고
// 비번과 비번확인이 다르면 user/regist2로 보낸다
// 모두 옭게 했다면 어떤페이지든 특정페이지로 넘어가서 입력한 값을 모두 출력해서 보여준다.
// 입력하신 아이디 : ?
// 입력하신 비번 : ?
// 입력하신 이름 : ?
// 입력하신 이메일 : ?