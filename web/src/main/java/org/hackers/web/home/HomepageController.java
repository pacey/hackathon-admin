package org.hackers.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

	@RequestMapping("/")
	public String showHomepage(){
		return "homepage";
	}

}
