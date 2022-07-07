package neo.setup.learn_center.repository.auth.language;

import neo.setup.learn_center.entity.auth.language.Language;
import neo.setup.learn_center.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>, BaseRepository {

    @Transactional
    void deleteByCode(UUID code);

    Optional<Language> getByCode(UUID code);
}
