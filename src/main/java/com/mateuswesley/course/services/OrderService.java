package com.mateuswesley.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuswesley.course.entities.Order;
import com.mateuswesley.course.repositories.OrderRepository;

// Registra essa classe como um componente (de serviço) que podera // ser usado para injeção de dependencias

@Service
public class OrderService {
    /* POr enquanto a unica coisa que a camada de serviço faz é
     * encaminhar a requisiçãopara a camada de data repositories
     */
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        // chamamos o metodo no servico, que repassa a chamada
        //pro repository
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}

