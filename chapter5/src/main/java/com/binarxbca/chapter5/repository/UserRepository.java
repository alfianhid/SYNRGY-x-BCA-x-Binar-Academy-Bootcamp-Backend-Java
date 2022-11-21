package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select * from users where username = :username", nativeQuery = true)
    public List<User> findUserByUsername(@Param("username") String username);

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    public List<User> findUserByEmail(@Param("email") String email);
}
