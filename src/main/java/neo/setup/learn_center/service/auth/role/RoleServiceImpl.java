package neo.setup.learn_center.service.auth.role;

import neo.setup.learn_center.criteria.auth.role.RoleCriteria;
import neo.setup.learn_center.dto.auth.role.RoleCreateDTO;
import neo.setup.learn_center.dto.auth.role.RoleDetailDTO;
import neo.setup.learn_center.dto.auth.role.RoleGetDTO;
import neo.setup.learn_center.dto.auth.role.RoleUpdateDTO;
import neo.setup.learn_center.entity.auth.role.Role;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.mapper.auth.role.RoleMapper;
import neo.setup.learn_center.repository.auth.role.RoleRepository;
import neo.setup.learn_center.response.Data;
import neo.setup.learn_center.service.AbstractService;
import neo.setup.learn_center.validator.auth.role.RoleValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl extends AbstractService<RoleValidator, RoleMapper, RoleRepository> implements RoleService {
    public RoleServiceImpl(RoleValidator validator, RoleMapper mapper, RoleRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(RoleCreateDTO DTO) {
        validator.validOnCreate(DTO);
        repository.save(mapper.toCreateDTO(DTO));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Void>> update(RoleUpdateDTO DTO) {
       return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(UUID key) {
        validator.validateKey(key);
        Optional<Role> optional = repository.getByCode(key);
        if (optional.isEmpty()) {
            throw new NotFoundException("Role not found");
        }
        repository.deleteByCode(key);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<RoleGetDTO>> get(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromGetDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Role not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<RoleDetailDTO>> detail(UUID key) {
        validator.validateKey(key);
        return new ResponseEntity<>(new Data<>(mapper.fromDetailDTO(repository.getByCode(key).orElseThrow(() -> new NotFoundException("Role not found")))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<RoleGetDTO>>> list(RoleCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return new ResponseEntity<>(new Data<>(mapper.fromGetListDTO(repository.findAll(request).stream().toList()), repository.count()), HttpStatus.OK);
    }
}
