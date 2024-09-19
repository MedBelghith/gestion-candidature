package com.elitech.gcandidate.entities;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class Utilisateur extends Audit{

    private String name;
    private String email;
    private String roles;
    private String password;
}
