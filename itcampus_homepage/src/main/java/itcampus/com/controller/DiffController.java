package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diff")
public class DiffController {

	Logger logger=LoggerFactory.getLogger(DiffController.class);
	
	@GetMapping("")
	public String diff() {
		logger.info("과정차별성");
		return "manage/diff";
	}
}
