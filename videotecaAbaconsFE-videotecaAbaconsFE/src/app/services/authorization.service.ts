import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor() { }

  autentica (userid: string, password: string) { 
    if (userid === 'pippo' && password === '1234') { 
      sessionStorage.setItem('Utente', userid);
      return true;
    } else { 
    return false; 
    } 
  } 

  loggedUser() { 
    let utente = sessionStorage.getItem("Utente"); 
    return (utente != null) ? utente : ""; 
   } 
   isLogged() { 
    return (sessionStorage.getItem("Utente") != null) ? true : false;
   } 

   clearUser() { 
    sessionStorage.removeItem("Utente"); 
   } 
   
   clearAll(){
    sessionStorage.clear();
   }
}
