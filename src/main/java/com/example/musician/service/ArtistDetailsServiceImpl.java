package com.example.musician.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.musician.entity.Artist;
import com.example.musician.repository.ArtistRepository;

@Service
public class ArtistDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ArtistRepository repository;

    protected static Logger log = LoggerFactory.getLogger(ArtistDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String artistname) throws UsernameNotFoundException {

    	log.debug("artistname={}", artistname);
    	
        if (artistname == null || "".equals(artistname)) {
            throw new UsernameNotFoundException("Artistname is empty");
        }
        Artist entity = repository.findByArtistname(artistname);

        return entity;
    }

}