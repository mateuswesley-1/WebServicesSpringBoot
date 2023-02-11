package com.mateuswesley.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateuswesley.course.entities.User;
import com.mateuswesley.course.services.UserService;

/*
    Essa camada é responsável por receber as solicitacoes do aplicativo
   nessse caso o aplicativo é o navegador.
   Quando digitamos /users uma requisicao e feita

   A comunicação com a camada de serviço é feita atraves da variavel service
   a camada recebe a requisicao, e retorna uma lista com todos
   os usuários.

   Porém, antes de retornar, a requisição passa pra camada de serviço,
   através de service.findAll(), que vai enviar a requisição para a camada de acesso de dados.
*/

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    /*O request e /users, esse metodo define oq sera a resposta */
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Cria uma resposta pra uma requisicao /id
    // @PathVariable permite que a gente use o valor da requisicao
    // na nossa funcao

    /* Recebemos a requisicao, aqui na camada mais superior
     * mandamos a requisicao pro servico
     * o servico manda para o data acess layer (na dal o spring faz o resto)
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
