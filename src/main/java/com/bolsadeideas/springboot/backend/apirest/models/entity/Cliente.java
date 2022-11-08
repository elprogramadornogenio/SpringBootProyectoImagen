package com.bolsadeideas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede ser vacio")
    @Size(min = 3, max = 15, message = "el tamaño tiene que estar entre 3 y 15 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede ser vacio")
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty(message = "no puede ser vacio")
    @Email(message = "no es una direccion de correo bien formada")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotNull(message = "no puede estar vacio")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    //@PrePersist
    public void prePersist(){
        createAt = new Date();
    }
}
