package com.dojo.chucknorris.repository;

import com.dojo.chucknorris.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<Joke, Long> {

}
