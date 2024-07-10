package com.televideocom.videoteca.business;

import com.televideocom.videoteca.errors.ForbiddenException;
import com.televideocom.videoteca.pojos.PojoGreet;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class AccessoBusiness {

    private final String UTENTE = "utente";
    private final String PASSWORD = "password";



    public PojoGreet controlloAccesso(String UTENTE, String PASSWORD) throws BadRequestException, ForbiddenException {
        if(UTENTE.isEmpty() || PASSWORD.isEmpty()){
            throw new BadRequestException();
        }else if(!this.UTENTE.equals(UTENTE) || !this.PASSWORD.equals(PASSWORD)){
            throw new ForbiddenException();
        }
            PojoGreet pojo = new PojoGreet();
        return pojo;
    }
}
