package pp_3_1_2_spring_boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_3_1_2_spring_boot.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}