package com.mateuswesley.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateuswesley.course.entities.Product;

// nao precisamos implementasr essa interface, pq a jpa ja implementa

/* Não precisa de indicação @Repository pq herda do JpaResitory */
public interface ProductRepository extends JpaRepository<Product, Long> {}

