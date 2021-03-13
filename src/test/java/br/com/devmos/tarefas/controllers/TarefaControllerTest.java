package br.com.devmos.tarefas.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.devmos.tarefas.models.Tarefa;
import br.com.devmos.tarefas.models.TarefaRequest;
import br.com.devmos.tarefas.services.TarefaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TarefaControllerTest {
	
	private static final Long ID = 1L;
	private static final String DESCRICAO = "teste";
	private static final Boolean FINALIZADA = false;
	private static final LocalDateTime DATA_FINALIZACAO = LocalDateTime.now();
	private static final String URL = "/api/tarefas";
	
	@MockBean
	private TarefaService tarefaService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetTarefaById() throws Exception {
		BDDMockito.given(tarefaService.buscaPorId(Mockito.anyLong())).willReturn(getMockTarefa());
		
		mvc.perform(MockMvcRequestBuilders.get(URL + "/1")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value(DESCRICAO))
			.andExpect(MockMvcResultMatchers.jsonPath("$.finalizada").value(FINALIZADA));

	}
	
	@Test
	public void testSaveTarefa() throws Exception {
		BDDMockito.given(tarefaService.salvar(Mockito.any(Tarefa.class))).willReturn(getMockTarefa());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(DESCRICAO, FINALIZADA, DATA_FINALIZACAO))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private String getJsonPayLoad(String descricao, Boolean finalizada, LocalDateTime dataFinalizacao) throws JsonProcessingException {
		TarefaRequest request = new TarefaRequest(descricao, finalizada, dataFinalizacao);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(request);
	}

	private Tarefa getMockTarefa() {
		return new Tarefa(DESCRICAO, FINALIZADA, DATA_FINALIZACAO);
	}

}
