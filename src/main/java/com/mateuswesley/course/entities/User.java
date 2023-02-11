package com.mateuswesley.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Gerencia o mapeamento objeto relacional. Define quem e entidade, table, o tipo de relacao etc
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/*

Colocando anotacoes do JPA para instruir a forma
como essa classe deve ser mapeada para uma entidade na base de dados

user e uma palavra reservada do banco que estamos usando

*/

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    // Incrementa o ID automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    // Criando a associacao entre as entidades
    // precisamos tambem sinalizar qual a variavel do outro lado
    // que mapeia essa relacao

    /* O JsonIgnore evita loopings na hora da requisicao. Esse atributo sera ignorado
     * quando a gente fizer requisicao de usuarios.
     * Pq ai e evitado que qnd a gente fizer a requisicao do usuario, mostre os pedidos,
     * sendo q os pedidos tbm tem usuario
     * e o usuario dentro do pedido tbm tem os pedidos etc etc etc....
     */
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
