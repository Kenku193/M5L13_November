package com.example.m5l13_november.repository;


import com.example.m5l13_november.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface Repo extends ReactiveCrudRepository<User, Long> {

}
