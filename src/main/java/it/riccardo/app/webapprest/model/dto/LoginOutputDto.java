package it.riccardo.app.webapprest.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginOutputDto implements Serializable {

    private static final long serialVersionUID = -6585525116492401757L;

    private String token;
}
