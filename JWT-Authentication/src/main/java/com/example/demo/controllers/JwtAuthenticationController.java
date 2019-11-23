package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.ResBody;
import com.example.demo.model.User;
import com.example.demo.service.impl.JwtUserDetailsService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {
	@Value("${jwt.secret}")
	private String secret;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
//	@GetMapping("/user")
//    @ResponseBody
//    public Principal getUser(Principal user) {
//        return user;
//    }
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception { 
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@GetMapping("/viewauthorizedpage")
	public ResBody view(HttpServletRequest request) {
		
		return new ResBody("This is only available for authenticated users");
	}
	
	
	@GetMapping("/public")
	public ResBody view1(HttpServletRequest request) {
		
		return new ResBody("This is for public");
	}
//	@GetMapping("/")
//	public PrincipalUser view2(HttpServletRequest request,Principal user) {
//		
//		
//		if(user!=null) {
//		
//		Gson gson = new GsonBuilder().create();
//        String data= gson.toJson(user);
//        
//       
//        
//        
//		String obj="{"+data.substring(data.indexOf("email")-1, data.indexOf("locale")-2)+"}";
//		
//		//obj=obj.replace("true", "\"true\"");
//	
//		PrincipalUser puser=gson.fromJson(obj, PrincipalUser.class);
//		//System.out.println(puser);
//		//System.out.println(obj);
//		
//		//return new ResBody(data.substring(data.indexOf("email")+8, data.indexOf("verified_email")-3));
//		//System.out.println(puser.getPicture());
//		
//		return puser;
//		}
//		return new PrincipalUser("loginfirst",false,"loginfirst","loginfirst","loginfirst","loginfirst"); // return null;
//		
//		
//		
//	}
	
	
	
	
	
	
	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
