package br.com.b2w.starwars.api.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.b2w.starwars.api.dto.PlanetDto;
import br.com.b2w.starwars.api.service.PlanetService;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetController.class)
@AutoConfigureJsonTesters
public class PlanetControllerTest {
	
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets/index/v1");
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private JacksonTester<PlanetDto> json;
	
	@MockBean
	private PlanetService planetService;
	
	@Autowired
	private PlanetController planetController;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			  MediaType.APPLICATION_JSON.getSubtype(),
			  Charset.forName("utf8"));
	
	private RestDocumentationResultHandler document;
	
	@Before
	public void setup() throws Exception {
		
		// Prepare Spring Restdocs with default directory and preprocessors
		this.document = document("{class-name}/{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
						.apply(documentationConfiguration(this.restDocumentation))
						.alwaysDo(MockMvcResultHandlers.print())
						.build();		
	}
	
	@Test
	public void shouldCreateNewPlanet() throws IOException, Exception {
		//Arrange
		PlanetDto planetDto = new PlanetDto("Alderaan", Sets.newSet("temperate"), Sets.newSet("grasslands"));
		
		//when(this.planetService.newPlanet(anyObject())).thenReturn(planetDto);
		
		//Act
		System.out.println(json.write(planetDto).getJson());
		ResultActions result = mvc.perform(post("/planets").contentType(contentType).content(json.write(planetDto).getJson()));
		
		
	}
	
		

}
