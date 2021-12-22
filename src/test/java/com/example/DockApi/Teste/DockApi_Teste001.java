package com.example.DockApi.Teste;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.DockApi.Repositorio.Objeto.Terminal;
import com.example.DockApi.Service.TerminalService;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URL;
import java.util.Objects;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class DockApi_Teste001 {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TerminalService endPoint;
	
	/**
	 * Teste item 2.a e 2.b
	 */
	@Test
	void SubTeste01() {
		
		System.out.println("End point deve aceitar um texto CSV para cadastro: RESTfull VERBO POST");	
        
		String body = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
		
		Terminal t = endPoint.add(body);
		
		assertTrue("Logic apresenta valor diferente", Objects.equals(t.getLogic(), 44332211));
		assertTrue("Serial apresenta valor diferente", Objects.equals(t.getSerial(), "123"));
		assertTrue("Model apresenta valor diferente", Objects.equals(t.getModel(), "PWWIN"));
		// Implementar demais comparaçoes
		
	}
	
	/**
	 * Teste item 2.d
	 */
	@Test
	void SubTeste02() {
        
		System.out.println("End point não deve aceitar VERBO DELETE");	
		
		try
		{
			
			this.mockMvc.perform(delete("/dockApi/v1/terminal/123"))
					.andExpect(status().is4xxClientError());
			assertTrue("", true);
			
		}
		catch (Exception ex) {
			System.out.println(ex);
			fail(ex.getMessage());
		}
		
	}
	
	/**
	 * Teste item 2.e
	 */
	@Test
	void SubTeste03() {
        
		System.out.println("End point não deve aceitar VERBO POST em JSON");	
		
		String JSON = "{ \"logic\": 777, \"serial\": \"55555-055\", \"model\": \"MPT-0555\", \"sam\": 0}";
		try
		{
			
			this.mockMvc.perform(post("/dockApi/v1/terminal/123")
					.contentType("application/json")
					.characterEncoding("utf-8"))
					.andExpect(status().is4xxClientError());
			assertTrue("", true);
		}
		catch (Exception ex) {
			System.out.println(ex);
			fail(ex.getMessage());
		}
		
	}

}
