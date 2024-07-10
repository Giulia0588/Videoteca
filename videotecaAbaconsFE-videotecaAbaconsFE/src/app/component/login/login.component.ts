import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Importa Router da @angular/router
import { AuthorizationService } from '../../services/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit { 
  userId = ""; 
  password = ""; 
  autenticato = false; 
  errMsg: string = "Spiacente, la userid o la password non sono corrette"; 
  titolo: string = "Accesso & Autenticazione"; 
  sottotitolo: string = "Procedi inserendo la userid e la password"; 
  errorInput: boolean = false;

  //Si esegue la dependency injection del Servizio sul costruttore

  constructor(private route: Router, private BasicAuth: AuthorizationService ) { 

  }

  ngOnInit(): void { 
 } 

 gestAut() {
  if (this.BasicAuth.autentica(this.userId, this.password)) {
    console.log(this.userId);
    this.autenticato = true;
    this.errorInput = false;
    this.route.navigate(['welcome', this.userId]);
    // Reindirizzamento alla pagina dei film dopo il login con successo
    //this.route.navigate(['/film']);
  } else {
    this.autenticato = false;
    this.errorInput = true;
  }
 }
}


 
