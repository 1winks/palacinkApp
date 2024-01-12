package projektr.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projektr.backend.domain.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
