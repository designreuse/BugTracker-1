package com.bugtracker.repository;

import com.bugtracker.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vlados on 14.03.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

     @Query("select u from User u where u.email = :email")
     User findByEmail(@Param("email") String email);


     @Query("select u from User u where u.username = :username")
     User findByUsername(@Param("username") String username);

     @Query("select u from User u where u.secretCode = :secretCode")
     User findBySecretCode(@Param("secretCode") String secretCode);

}
