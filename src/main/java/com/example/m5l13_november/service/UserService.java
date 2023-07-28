package com.example.m5l13_november.service;

import com.example.m5l13_november.entity.User;
import com.example.m5l13_november.repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final Repo repo;

    public Mono<User> findById(Long id){
      return repo.findById(id);

    }

    public Flux<User> findAll(){
        return repo.findAll();
    }

    @Transactional
    public Mono<User> save(User user){
        return repo.save(user);
    }

    @Transactional
    public Mono<Void> delete(User user){
        return repo.delete(user);
    }

    @Transactional
    public Mono<Void> deleteById(Long id){
       return repo.deleteById(id);
    }


}
