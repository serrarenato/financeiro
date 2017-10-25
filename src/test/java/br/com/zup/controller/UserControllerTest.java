package br.com.zup.controller;

import static br.com.zup.security.TokenAuthenticationService.getAuthentication;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.zup.entity.ApplicationUser;
import br.com.zup.repository.ApplicationUserRepository;
import br.com.zup.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class UserControllerTest {
	private static String TOKEN;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApplicationUserRepository repository;

	@InjectMocks
	private UserServiceImpl service;

	@Before
	public void init() {
		TOKEN = getAuthenticationTest();
	}
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		MockitoAnnotations.initMocks(this);
		List<ApplicationUser> respApplicationUser = new ArrayList<ApplicationUser>() {
			{
				add(generateUserTest());
			}
		};

		when(repository.findAll()).thenReturn(respApplicationUser);

		this.mockMvc.perform(get("/users/list").header("Authorization", TOKEN)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("Renato"))).andDo(document("User"));
	}

	@Test
	public void shouldReturnErrorUnauthorized() throws Exception {
		MockitoAnnotations.initMocks(this);
		List<ApplicationUser> respApplicationUser = new ArrayList<ApplicationUser>() {
			{
				add(generateUserTest());
			}
		};
		when(repository.findAll()).thenReturn(respApplicationUser);

		this.mockMvc.perform(get("/users/list")).andDo(print()).andExpect(status().is4xxClientError());
	}

	private ApplicationUser generateUserTest() {
		return new ApplicationUser(1, "Renato", "teste", true);
	}

	private String getAuthenticationTest() {
		return getAuthentication("Renato", "Admin");
	}

}
