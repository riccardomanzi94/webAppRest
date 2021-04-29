package it.riccardo.app.webapprest.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorOutput implements Serializable {

    private static final long serialVersionUID = -6116431688680804607L;

    private String code;
    private String message;

}
