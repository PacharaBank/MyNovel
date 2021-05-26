package com.practice.mynovel.respositories;

import com.practice.mynovel.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void should_store_a_tutorial() {
        User user = new User();
        user.setUsername("bank456b5");
        user.setPassword("0899854582");
        user.setLastName("Patcharamongkol");
        user.setFirstName("Pachara");

        User savedUser = repository.save(user);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindByName() {
        List<User> user = repository.findAll();
        assertThat(user.get(0).getUsername()).isEqualTo("bank456b5");
    }
}