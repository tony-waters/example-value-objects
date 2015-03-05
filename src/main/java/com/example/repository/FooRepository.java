package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Foo;

@Repository
public interface FooRepository extends PagingAndSortingRepository<Foo, Long> {

}
