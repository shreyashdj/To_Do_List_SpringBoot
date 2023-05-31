package com.bridgelabz.todolist.repository;

import com.bridgelabz.todolist.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author - Shreyash Jadhav
 */

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer>{
    @Query(value = "select * from user_data where login_id = :loginID", nativeQuery = true)
   UserData findByLoginId(String loginID);
}