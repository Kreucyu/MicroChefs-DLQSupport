package com.dlqSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.PrimaryKey;
import org.jspecify.annotations.Nullable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mensagens")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String mensagemOriginal;

    @Column
    private String mensagemCorrigida;

    @Column
    private String correcaoDocumentada;
}
