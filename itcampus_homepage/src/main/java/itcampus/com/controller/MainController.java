package itcampus.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "main"; 
	}
	
	@GetMapping("/maintest")
	public String maintest() {
		return "maintest"; 
	}
}
