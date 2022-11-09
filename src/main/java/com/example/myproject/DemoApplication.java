package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class StartSessionController {

	@GetMapping("/")
	public String greeting(){
		return "Welcome to spring boot";
	}

	@PostMapping("/startSession")
    	public String signIn(@RequestBody String username,
                                           HttpSession session) {
        	session.setAttribute("username", username);
		System.out.println("Session: " + session.getAttribute( "username" ) );
        	return "Session started";
    	}

	@PostMapping("/checkSession")
	public String checkSession(HttpSession session){
		return "\nsession.getAttribute( username ) " + session.getAttribute( "username" ) + "\n";
	}
}
