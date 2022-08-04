package dio.SpringBoot.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends CrudRepository <cliente, Long>{
    
}
