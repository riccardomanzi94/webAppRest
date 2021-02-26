package it.riccardo.app.webapprest.model.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class LoginInputDto implements Serializable {

    private static final long serialVersionUID = 4354876375304812095L;

    private String username;
    @ToString.Exclude
    private String password;
}
