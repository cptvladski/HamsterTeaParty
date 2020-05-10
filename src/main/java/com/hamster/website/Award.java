package com.hamster.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;

@RestController
public class Award {
    // static Integer lastId = 0;
    private JokeRepository jokeRepository;
    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;
    @Autowired
    public Award(JokeRepository jokeRepository, JwtTokenUtil jwtTokenUtil, UserRepository userRepository) {
        this.jokeRepository = jokeRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/award")  /// AICI MAI JOS MAI TREBUIE LUCRAT PUTIN
    public ResponseEntity<?> upvote(RequestEntity<Joke> requestEntity) {
        String token = requestEntity.getHeaders().getFirst("Authorization");
        if (token == null)
            return ResponseEntity.status(403).body("No auth token");
        String userId = userRepository.findByUserName(jwtTokenUtil.getUsernameFromToken(token)).get(0)._id;
        User user = userRepository.findByUserName(jwtTokenUtil.getUsernameFromToken(token)).get(0);
        Joke joke = requestEntity.getBody();

        String newAwarderID = userId;
        List <String> awardersIDs = joke.getAwardersIDs();
        awardersIDs.add(newAwarderID);
        joke.setUpvotersIDs(awardersIDs);
        jokeRepository.save(joke);  // gen update joke

        int upvotedCounter = user.getUpvotedCounter();
        upvotedCounter++;
        user.setUpvotedCounter(upvotedCounter);
        userRepository.save(user);  /// NU SUNT SIGUR DACA E BINE

        return ResponseEntity.ok().body("OK");
    }
}
