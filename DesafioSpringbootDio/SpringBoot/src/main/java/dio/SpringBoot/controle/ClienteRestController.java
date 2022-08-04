package dio.SpringBoot.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.SpringBoot.modelo.cliente;
import dio.SpringBoot.servico.clienteServico;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    @Autowired
	private clienteServico clienteServico;

	@GetMapping
	public ResponseEntity<Iterable<cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteServico.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteServico.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<cliente> inserir(@RequestBody cliente cliente) {
		clienteServico.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<cliente> atualizar(@PathVariable Long id, @RequestBody cliente cliente) {
		clienteServico.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteServico.deletar(id);
		return ResponseEntity.ok().build();
	}
}