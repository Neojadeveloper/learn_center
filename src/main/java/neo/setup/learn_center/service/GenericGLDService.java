package neo.setup.learn_center.service;

import neo.setup.learn_center.criteria.BaseCriteria;
import neo.setup.learn_center.dto.GenericDTO;
import neo.setup.learn_center.response.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericGLDService<GD extends GenericDTO, DD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    ResponseEntity<Data<GD>> get(K key);

    ResponseEntity<Data<DD>> detail(K key);

    ResponseEntity<Data<List<GD>>> list(CR criteria);
}
