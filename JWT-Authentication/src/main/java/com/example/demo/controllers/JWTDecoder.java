package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JWTDecoder {

	
	
	@GetMapping("/getusername")
	public  String testDecodeJWT(HttpServletRequest request) {

		final String requestTokenHeader = request.getHeader("Authorization");

		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);

			String[] split_string = jwtToken.split("\\.");

			String base64EncodedBody = split_string[1];

			Base64 base64Url = new Base64(true);

			String body = new String(base64Url.decode(base64EncodedBody));

			return body.substring(body.indexOf(":") + 2, body.indexOf(",") - 1);

		} else {
			return "Invalid Token";
		}

	}

}
