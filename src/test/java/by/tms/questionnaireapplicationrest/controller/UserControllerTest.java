package by.tms.questionnaireapplicationrest.controller;

import by.tms.controllers.UserController;
import by.tms.entity.Role;
import by.tms.entity.Status;
import by.tms.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;


@WebMvcTest(UserController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class UserControllerTest {

    private final UserController userController;

    @Autowired
    public UserControllerTest(UserController userController) {
        this.userController = userController;
    }

    @BeforeAll
    public void init(){
        User user1 = User.builder().userName("Vasya6477").firstName("Vasyiliy").lastName("Jackson")
                .email("MasterVasya@mail.ru")
                .password("1111")
                .roles(Set.of((Role.builder().status(Status.ROLE_ADMIN).build())))
                .build();
        User user2 = User.builder().userName("JosepF99").firstName("Josepf").lastName("Karson")
                .email("Fullstack@mail.ru")
                .password("2222")
                .roles(Set.of((Role.builder().status(Status.ROLE_ADMIN).build())))
                .build();
        userController.createUser(user1);
        userController.createUser(user2);
    }

}
