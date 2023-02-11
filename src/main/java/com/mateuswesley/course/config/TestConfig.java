package com.mateuswesley.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mateuswesley.course.entities.Order;
import com.mateuswesley.course.entities.User;
import com.mateuswesley.course.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Mano brown", "mano@gmail.com", "89898989", "154154");
        User u2 = new User("Dr. Auzio", "drauzio@gmail.com", "8888888", "b5854123lk");

        Order o1 = new Order(u1);
        Order o2 = new Order(u2);
        Order o3 = new Order(u1);
        Order o4 = new Order(u2, Instant.parse("2022-12-25T15:58:45Z"));

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
    }
}
