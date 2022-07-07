package neo.setup.learn_center.service;

import lombok.RequiredArgsConstructor;
import neo.setup.learn_center.mapper.BaseMapper;
import neo.setup.learn_center.repository.BaseRepository;
import neo.setup.learn_center.validator.BaseValidator;

@RequiredArgsConstructor
public abstract class AbstractService<V extends BaseValidator, M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final V validator;
    protected final M mapper;
    protected final R repository;
}
