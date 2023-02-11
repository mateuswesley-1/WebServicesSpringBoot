package com.mateuswesley.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateuswesley.course.entities.Order;
import com.mateuswesley.course.services.OrderService;

/*
    Essa camada é responsável por receber as solicitacoes do aplicativo
   nessse caso o aplicativo é o navegador.
   Quando digitamos /Orders uma requisicao e feita

   A comunicação com a camada de serviço é feita atraves da variavel service
   a camada recebe a requisicao, e retorna uma lista com todos
   os usuários.

   Porém, antes de retornar, a requisição passa pra camada de serviço,
   através de service.findAll(), que vai enviar a requisição para a camada de acesso de dados.
*/

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    /*O request e /Orders, esse metodo define oq sera a resposta */
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
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
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
