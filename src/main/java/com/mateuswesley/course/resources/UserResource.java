package com.mateuswesley.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateuswesley.course.entities.User;

/* Aqui definimos o que sera feito quando for feito o request /users*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /*O request e /users, esse metodo define oq sera a resposta */
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("mateus", "mateus@gmail.com", "98 9985 8552", "15471");
        return ResponseEntity.ok().body(u);
    }
}
