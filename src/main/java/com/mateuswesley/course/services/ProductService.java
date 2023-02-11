package com.mateuswesley.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuswesley.course.entities.Product;
import com.mateuswesley.course.repositories.ProductRepository;

// Registra essa classe como um componente (de serviço) que podera // ser usado para injeção de dependencias

@Service
public class ProductService {
    /* POr enquanto a unica coisa que a camada de serviço faz é
     * encaminhar a requisiçãopara a camada de data repositories
     */
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        // chamamos o metodo no servico, que repassa a chamada
        //pro repository
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}

