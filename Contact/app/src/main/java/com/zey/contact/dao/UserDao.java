package com.zey.contact.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.zey.contact.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Update
    int updateUser(User user);

    @Query("DELETE FROM users WHERE id = :userId")
    int deleteUsers(int userId);

}
