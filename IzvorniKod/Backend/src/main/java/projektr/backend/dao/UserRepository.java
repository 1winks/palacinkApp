package projektr.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projektr.backend.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameOrEmail(String username, String email);

    User findByUserName(String username);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);
}
