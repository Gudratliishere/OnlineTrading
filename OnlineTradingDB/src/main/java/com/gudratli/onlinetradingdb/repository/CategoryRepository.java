package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
