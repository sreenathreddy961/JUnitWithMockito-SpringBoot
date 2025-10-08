package com.practice.unit_testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.unit_testing.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{

}
