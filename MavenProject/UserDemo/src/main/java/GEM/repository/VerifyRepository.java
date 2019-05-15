package GEM.repository;

import GEM.model.User;
import GEM.model.VerificationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VerifyRepository extends CrudRepository<VerificationToken,String> {
    VerificationToken findByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "delete from VerificationToken t where t.user = ?1")
    void deleteByUser(User user);
}
