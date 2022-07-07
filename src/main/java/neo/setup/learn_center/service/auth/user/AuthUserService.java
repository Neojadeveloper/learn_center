package neo.setup.learn_center.service.auth.user;

import neo.setup.learn_center.criteria.auth.user.AuthUserCriteria;
import neo.setup.learn_center.dto.auth.user.AuthUserCreateDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserDetailDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserGetDTO;
import neo.setup.learn_center.dto.auth.user.AuthUserUpdateDTO;
import neo.setup.learn_center.service.GenericCUDService;
import neo.setup.learn_center.service.GenericGLDService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, UUID>, GenericGLDService<AuthUserGetDTO, AuthUserDetailDTO, AuthUserCriteria, UUID>, UserDetailsService {
}
