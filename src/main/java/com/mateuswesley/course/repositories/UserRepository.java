package com.mateuswesley.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateuswesley.course.entities.User;

// nao precisamos implementasr essa interface, pq a jpa ja implementa
public interface UserRepository extends JpaRepository<User, Long> {

}
