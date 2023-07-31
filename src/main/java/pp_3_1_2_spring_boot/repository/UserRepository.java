package pp_3_1_2_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_3_1_2_spring_boot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}