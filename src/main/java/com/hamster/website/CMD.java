package com.hamster.website;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CMD implements CommandLineRunner {

    private UserRepository userRepository;
    @Autowired
    public CMD(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String...args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(new User("0","cptvladski","1234","cptvladski@gmail.com","vlad","leica",21,"RO","clung","fb.com/vlad","vlad"));
        System.out.println(userRepository.findAll());
    }
}