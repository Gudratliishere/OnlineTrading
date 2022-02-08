package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findByNameContaining (String name);
}
