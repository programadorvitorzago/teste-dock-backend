
package com.example.DockApi.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.DockApi.Controlador.ControladorTerminal;
import com.example.DockApi.Repositorio.RepositorioDockApi;
import com.example.DockApi.Repositorio.Excecao.TerminalNotFoundException;
import com.example.DockApi.Repositorio.Objeto.Terminal;
import com.example.DockApi.Util.CSVAdapter;

/**
 *
 * @author vitor.zago
 */
@RestController
@RequestMapping("terminal")
public class TerminalService {
	
	@Autowired
	private RepositorioDockApi repositorio;

	
	/**
	 * Funcao que retorna a lista de todos os Terminais
	 * @return
	 */
	@GetMapping
	public List<Terminal> getAll()
	{
		return this.repositorio.findAll();
	}
	
	/**
	 * Funcao que retorna um terminal específico procurando pelo atributo Logic
	 * @return
	 */
	@GetMapping("{logic}")
	public Terminal get(@PathVariable Integer logic)
	{
		return repositorio.findById(logic)
				.orElseThrow(() -> new TerminalNotFoundException(logic));
	}
	
	/**
	 * Cadastro norvo terminal enviado CSV pelo BODY
	 * O Post não pode aceitar JSON 
	 * @return
	 */
	@PostMapping(consumes={"text/html"})
	public Terminal add(@RequestBody String body)
	{
		CSVAdapter csv = new CSVAdapter(body);
		
		ControladorTerminal.ValidarTerminalDeCSV(csv);
		
		Terminal terminal = ControladorTerminal.getTerminalDeCSV(csv);

		return ControladorTerminal.insert(this.repositorio, terminal);
	}
	
	/**
	 * Edição de terminal
	 * O Post não pode aceitar JSON 
	 * @return
	 */
	@PutMapping("{logic}")
	public Terminal edit(@PathVariable Integer logic, @RequestBody Terminal terminalToEdit)
	{
		// Se não existir, este método irá lançar um erro
		Terminal original = get(logic);
		
		return ControladorTerminal.update(this.repositorio, original, terminalToEdit);
	}
	
	/**
	 * Deleção de entidade terminal está proibido
	 *   Item 2.d - não aceitar o verbo delete
	 * O Post não pode aceitar JSON 
	 * @return
	 */
//	@DeleteMapping("{logic}")
//	@ResponseStatus( HttpStatus.NO_CONTENT )
//	public void remove(@PathVariable Integer logic)
//	{
//		// Se não existir, este método irá lançar um erro
//		Terminal terminalToDelete = get(logic);
//		
//		ControladorTerminal.delete(this.repositorio, terminalToDelete);
//	}

}