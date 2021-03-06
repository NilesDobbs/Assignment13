package com.coderscampus.assignment13.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment13.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByUserId(Long userId);
	List<User> findByName (String name);
	List<User> findByUsername(String usernname);
	List<User> findByUsernameAndName(String name, String username);
	List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2);
	@Query("select u from User u where username = :username")
	List<User> findByExactlyOneUserByUsername(String username);
	@Query("select u from User u" + " left join fetch u.accounts" + " left join fetch u.address")
	Set<User> findUsersWithAccountsAndAddresses();
}