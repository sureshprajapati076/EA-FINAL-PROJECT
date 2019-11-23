package com.example.booking;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.booking.model.Bookings;
import com.example.booking.repository.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.is;
public class JUnitTestComments extends CommentServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	BookingRepository commentRepo;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void addComment() throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdS5wcmFqYXBhdGlAbXVtLmVkdSIsImV4cCI6MTU3NDMwNjg2MCwiaWF0IjoxNTc0Mjg4ODYwfQ.F0oW0-h2DTIe4XV_I8DQ2SX8bCJKUbzXbotj2nXb8Vuwi2hUGl0NvuRVprG-CyqDDQphh7RihYjl_iRlR0fNSQ");
		
		
		Bookings comment = new Bookings(1,"suresh@gmail.com",1,"C20",33.22,LocalDate.of(2019, 9, 9),LocalDate.of(2019, 9, 12));

		Mockito.when(commentRepo.save(Mockito.any(Bookings.class))).thenReturn(comment);

		mockMvc.perform(MockMvcRequestBuilders.post("/addbooking")
				.content(asJsonString(comment))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		//.andExpect(status().isOk())
			//	.andExpect(content().contentType("application/json;charset=UTF-8"))
			//	.andExpect(jsonPath("$.id").value(1))
//				.andExpect(jsonPath("$.comment").value("nice comment"))
//				.andExpect(jsonPath("$.stars").value(4))
				
				
				;
		
		

		
		
	}
	
	@Test
	public void getComments() throws Exception {
		 mockMvc.perform(get("/allbookings"))
		 
         .andExpect(status().isOk())
        
         .andExpect(jsonPath("$[0].user_id", is("su.prajapati@mum.edu")));
        
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
