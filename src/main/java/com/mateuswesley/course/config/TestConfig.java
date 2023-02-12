package com.mateuswesley.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mateuswesley.course.entities.Category;
import com.mateuswesley.course.entities.Order;
import com.mateuswesley.course.entities.OrderItem;
import com.mateuswesley.course.entities.Product;
import com.mateuswesley.course.entities.User;
import com.mateuswesley.course.entities.enums.OrderStatus;
import com.mateuswesley.course.repositories.CategoryRepository;
import com.mateuswesley.course.repositories.OrderItemRepository;
import com.mateuswesley.course.repositories.OrderRepository;
import com.mateuswesley.course.repositories.ProductRepository;
import com.mateuswesley.course.repositories.UserRepository;


// classe de configuracao especifica para o perfil de teste
@Configuration
@Profile("test")
// implementa uma interface que faz a classe rodara assim
// que o programa for iniciado
public class TestConfig implements CommandLineRunner{
    // uma classe repende da outra
    // queremos fazer uma injecao de dependencia fraca
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Mano brown", "mano@gmail.com", "89898989", "154154");
        User u2 = new User("Dr. Auzio", "drauzio@gmail.com", "8888888", "b5854123lk");

        Order o1 = new Order(u1);
        Order o2 = new Order(u1, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(u1, OrderStatus.PAID);
        Order o4 = new Order(u2, Instant.parse("2022-12-25T15:58:45Z"));

        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers");

        Product prod1 = new Product("notebook asus", "notebook irado ate dms", 2500.0, "http://google.com");
        Product prod2 = new Product("ifome", "celular massa", 4500.0, "http://google.com");

        prod1.getCategories().add(cat1);
        prod1.getCategories().add(cat2);
        prod2.getCategories().add(cat3);

        OrderItem oi1 = new OrderItem(o1, prod1, 2, prod1.getPrice());
        OrderItem oi2 = new OrderItem(o1, prod2, 1, prod2.getPrice());
        OrderItem oi3 = new OrderItem(o2, prod1, 2, prod1.getPrice());
        OrderItem oi4 = new OrderItem(o3, prod1, 2, prod1.getPrice());



        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(prod1, prod2));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
