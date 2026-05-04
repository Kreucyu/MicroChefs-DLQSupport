package com.dlqSupport.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "mensagens")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoMensagem;

    @Column(nullable = false)
    private String filaDeOrigem;

    @Column(nullable = false)
    private String tipoErro;

    @Column(nullable = false)
    private String mensagemDeErro;

    @Column(nullable = false)
    private String mensagemOriginal;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column
    private String mensagemCorrigida;

    @Column
    private String correcaoDocumentada;


}
