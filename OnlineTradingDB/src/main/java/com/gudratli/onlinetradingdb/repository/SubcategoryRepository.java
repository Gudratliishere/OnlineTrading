package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long>
{
}
