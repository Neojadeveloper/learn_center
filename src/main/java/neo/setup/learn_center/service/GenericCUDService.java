package neo.setup.learn_center.service;

import neo.setup.learn_center.dto.BaseDTO;
import neo.setup.learn_center.dto.GenericDTO;
import neo.setup.learn_center.response.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> {
    ResponseEntity<Data<Void>> create(CD DTO);

    ResponseEntity<Data<Void>> update(UD DTO);

    ResponseEntity<Data<Void>> delete(K key);
}
