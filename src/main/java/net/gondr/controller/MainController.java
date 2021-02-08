package net.gondr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	// 메인 페이지 라우팅
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainPage(Model model) {
		model.addAttribute("msg", "양영디지털고 도제반");
		return "main";
	}
	
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value="name") String name) {
		System.out.println(name);
		
		model.addAttribute("msg", "안녕하세요. JSP 마스터 " + name + "님");
		return "hello";
	}
	
	// /world를 보면 world.jsp가 서비스 되도록 추가 메서드 명은 자유
	
	// /world/박지호
	@GetMapping("/world/{name}")
	public String world(Model model, @PathVariable String name) {
		model.addAttribute("name", name);
		return "world";
	}
	
	@GetMapping("/all")
	public String all(Model model) {
		return "all";
	}
}
