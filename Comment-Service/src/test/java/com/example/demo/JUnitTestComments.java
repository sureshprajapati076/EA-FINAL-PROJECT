package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Comments;
import com.example.demo.repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JUnitTestComments extends CommentServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	CommentRepository commentRepo;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void addComment() throws Exception {
		Comments comment = new Comments(101, 2, "mygmail@gmail.com", "nice comment", 4);

		Mockito.when(commentRepo.save(Mockito.any(Comments.class))).thenReturn(comment);

		mockMvc.perform(MockMvcRequestBuilders.post("/add").content(asJsonString(comment))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.emailId").value("mygmail@gmail.com"))
				.andExpect(jsonPath("$.comment").value("nice comment"))
				.andExpect(jsonPath("$.stars").value(4))
				
				
				;
		
		

		
		
	}
	
//	@Test
	public void getComments() throws Exception {
		 mockMvc.perform(get("/find/2"))
		 
         .andExpect(status().isOk())
        
         .andExpect(jsonPath("$[0].emailId", is("mygmail@gmail.com")));
        
	}
	
	
	
	
	

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}






//mockMvc.perform(post("/add")).andExpect(status().isOk())
//.andExpect(content().contentType("application/json;charset=UTF-8"))
//.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
//.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));
