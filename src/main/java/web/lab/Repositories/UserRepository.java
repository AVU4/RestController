package web.lab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lab.Entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}
