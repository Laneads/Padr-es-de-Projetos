package dio.SpringBoot.servico;

import dio.SpringBoot.modelo.cliente;

public interface clienteServico {

    Iterable<cliente> buscarTodos();

	cliente buscarPorId(Long id);

	void inserir(cliente cliente);

	void atualizar(Long id, cliente cliente);

	void deletar(Long id);
    
}
