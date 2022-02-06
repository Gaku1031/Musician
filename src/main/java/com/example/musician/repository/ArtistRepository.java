package com.example.musician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musician.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {

    Artist findByArtistname(String artistname);
}
