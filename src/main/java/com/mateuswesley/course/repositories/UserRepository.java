package com.mateuswesley.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateuswesley.course.entities.User;

// nao precisamos implementasr essa interface, pq a jpa ja implementa

/* Não precisa de indicação @Repository pq herda do JpaResitory */
public interface UserRepository extends JpaRepository<User, Long> {
    /*A camada pega a requisição e pega os dados usando o Jpa */
}
