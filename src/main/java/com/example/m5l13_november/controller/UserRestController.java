package com.example.m5l13_november.controller;

import com.example.m5l13_november.entity.User;
import com.example.m5l13_november.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("restapi/v1/users")
public class UserRestController {

    private final UserService userService;

    // READ

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> findAll(){
        return userService.findAll();
    }

    // CREATE

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> update(@PathVariable Long id, @RequestBody User user){

        if (id.equals(user.getId())) {
            return userService.save(user);
        }
        else {
            log.error("update with incorrect id = {}", id);
            return Mono.error(new IllegalStateException("incorect id"));
        }
    }

    // DELETE

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id){
        return userService.deleteById(id);
    }



}
