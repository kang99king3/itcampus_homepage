package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	Logger logger=LoggerFactory.getLogger(ContactController.class);

	@GetMapping("/contact")
	public String contact() {
		return "manage/contact";
	}
}
