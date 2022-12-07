package sof306.ph18485.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Account;
import sof306.ph18485.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

	@Query("SELECT DISTINCT au FROM Authority au WHERE au.account IN :accounts")
	List<Authority> authoritiesOf(@Param("accounts") List<Account> accounts);

}
