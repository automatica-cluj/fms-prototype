package ro.nttdata.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.nttdata.fms.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
