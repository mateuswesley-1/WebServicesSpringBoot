package com.mateuswesley.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mateuswesley.course.entities.User;
import com.mateuswesley.course.repositories.UserRepository;
import com.mateuswesley.course.services.exceptions.DataBaseException;
import com.mateuswesley.course.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        
        try{

            repository.deleteById(id);

        } catch(EmptyResultDataAccessException e) {

            throw new ResourceNotFoundException(id);

        } catch( DataIntegrityViolationException e){

            throw new DataBaseException(e.getMessage());

        }

    }

    public User update(Long id, User user){
        // Objeto monitorado ue ainda nao vai no bd
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    public void updateData(User entity, User user){
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
    }
}
