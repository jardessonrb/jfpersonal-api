package labjb.jfpersonalapi.repositoy;

import labjb.jfpersonalapi.domain.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByCpfOrEmail(String cpf, String email);

    Optional<Personal> findByUuid(UUID personalId);
}
