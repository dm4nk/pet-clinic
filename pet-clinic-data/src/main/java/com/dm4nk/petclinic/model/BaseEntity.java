package com.dm4nk.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity implements Serializable {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
