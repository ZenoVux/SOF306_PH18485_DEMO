package sof306.ph18485.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Optional<Account> findByUsername(String username);

	@Query("SELECT DISTINCT au.account FROM Authority au WHERE au.role.id IN ('DIRE', 'STAF')")
	List<Account> getAdministrators();
}
