package com.employeeTry.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeTry.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
