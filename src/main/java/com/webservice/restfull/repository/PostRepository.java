package com.webservice.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.restfull.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
