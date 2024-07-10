package com.televideocom.videoteca.controller;

import com.televideocom.videoteca.business.AccessoBusiness;
import com.televideocom.videoteca.errors.ForbiddenException;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.pojos.PojoGreet;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/accesso")
public class GreetingsController {


    @Autowired
    private AccessoBusiness ab;

    @PostMapping(value = "/security", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>controlloAccesso(@RequestParam (name = "utente") String utente, @RequestParam (name = "password") String password) throws NotFoundException, BadRequestException, ForbiddenException {
        try {
            PojoGreet pojo = ab.controlloAccesso(utente, password);
            return new ResponseEntity<>(pojo, HttpStatus.NO_CONTENT);
        }catch (BadRequestException e){
            throw new BadRequestException(e);
        } catch (ForbiddenException e) {
            throw new ForbiddenException(e.getMessage());
        }
    }

    /*
    @GetMapping(value="/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> greetings(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
*/
    @GetMapping(value="/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
    public PojoGreet greetings(){
        return new PojoGreet("Hello World");
    }
}
