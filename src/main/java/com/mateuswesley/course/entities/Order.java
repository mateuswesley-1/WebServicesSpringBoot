package com.mateuswesley.course.entities;

import java.io.Serializable;
import java.time.Instant;

import com.mateuswesley.course.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    private Integer orderStatus;
    /* Implementndo associacoes */


    /* Um cliente pode fazer varios pedidos, essa anotacao sinaliza
     * para o jpa que essa variavel sera uma chave estrangeira muitos para um
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(){

    }
    public Order(User client) {
        this.moment = Instant.now();
        this.orderStatus = OrderStatus.WAITING_PAYMENT.getCode();
        this.client = client;
    }

    public Order(User client, OrderStatus orderStatus) {
        this(client);
        setOrderStatus(orderStatus);
    }

    public Order(User client, Instant moment){
        this(client);
        this.moment = moment;
    }



    public Order(User client, Instant moment, OrderStatus orderStatus) {
        this(client, moment);
        this.orderStatus = orderStatus.getCode();;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    // Usamos numero inteiro para inicializar o OrderStatus
    // E o get retorna o valor enum la
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    //
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }

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
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
