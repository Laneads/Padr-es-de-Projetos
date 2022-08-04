package dio.SpringBoot.servico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dio.SpringBoot.modelo.endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface viaCepServico {

	@GetMapping("/{cep}/json/")
	static
	endereco consultarCep(@PathVariable("cep") String cep) {
		return null;
	}
}
