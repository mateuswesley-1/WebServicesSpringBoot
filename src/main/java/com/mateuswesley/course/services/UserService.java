package com.mateuswesley.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuswesley.course.entities.User;
import com.mateuswesley.course.repositories.UserRepository;

// Registra essa classe como um componente (de serviço) que podera // ser usado para injeção de dependencias

@Service
public class UserService {
    /* POr enquanto a unica coisa que a camada de serviço faz é
     * encaminhar a requisiçãopara a camada de data repositories
     */
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        // chamamos o metodo no servico, que repassa a chamada
        //pro repository
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }
}
