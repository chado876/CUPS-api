package com.cups.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cups.api.entities.AuthToken;

public interface IAuthTokenRepository 
extends JpaRepository<AuthToken,Integer>{

}
