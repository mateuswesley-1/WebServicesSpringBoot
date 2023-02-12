package com.mateuswesley.course.entities.pk;

import java.io.Serializable;

import com.mateuswesley.course.entities.Order;
import com.mateuswesley.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Classe que representa a chave primaria da classe OrderItem
@Embeddable
public class OrderItemPk implements Serializable{
    private static final long serialVersionUID = 1L;

    // Cada Order tera varios OrderItem, um pedido pode
    // ter varios produtos

    // O JoinColumn, indica qual sera o nome da coluna que representa
    // o valor do order. Se um pedido tem varios Items, teremos
    // uma tabela de OrderItem, e uma coluna order_id indicado a que order
    // aquele produto pertence. Podemos ter a mesma order para varios produtos
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // assim como um produto pode ter varios Order de que faz parte
    // sendo assim parte de varios OrderItemPK.
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        OrderItemPk other = (OrderItemPk) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
