package neo.setup.learn_center.service.auth.token;

import neo.setup.learn_center.criteria.auth.token.AuthTokenCriteria;
import neo.setup.learn_center.dto.auth.token.AuthTokenCreateDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenDetailDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenGetDTO;
import neo.setup.learn_center.dto.auth.token.AuthTokenUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public interface AuthTokenService extends GenericCUDService<AuthTokenCreateDTO, AuthTokenUpdateDTO, UUID>, GenericGLDService<AuthTokenGetDTO, AuthTokenDetailDTO, AuthTokenCriteria, UUID> {
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
