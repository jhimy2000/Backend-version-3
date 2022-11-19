package com.tambos.inventory.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private int price;

    @Column(name = "account")
    private int account;

    @Column(name = "id_categoria")
    private int idCategoria;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name ="imagen")
    private byte[] picture;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;


}
