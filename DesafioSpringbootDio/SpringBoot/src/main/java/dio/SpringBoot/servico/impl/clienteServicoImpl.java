package dio.SpringBoot.servico.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.SpringBoot.modelo.cliente;
import dio.SpringBoot.modelo.clienteRepository;
import dio.SpringBoot.modelo.endereco;
import dio.SpringBoot.modelo.enderecoRepository;
import dio.SpringBoot.servico.clienteServico;
import dio.SpringBoot.servico.viaCepServico;

@Service
public class clienteServicoImpl implements clienteServico {

	@Autowired
	private clienteRepository clienteRepository;
	@Autowired
	private enderecoRepository enderecoRepository;
	@Autowired
	private viaCepServico viaCepService;
	

	public viaCepServico getViaCepService() {
		return viaCepService;
	}

	public void setViaCepService(viaCepServico viaCepService) {
		this.viaCepService = viaCepService;
	}

	@Override
	public Iterable<cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public cliente buscarPorId(Long id) {
		Optional<cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, cliente cliente) {
		Optional<cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			endereco novoEndereco = viaCepServico.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
