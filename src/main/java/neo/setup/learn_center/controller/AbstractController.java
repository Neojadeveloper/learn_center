package neo.setup.learn_center.controller;

import lombok.RequiredArgsConstructor;
import neo.setup.learn_center.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {
    protected final S service;
}
