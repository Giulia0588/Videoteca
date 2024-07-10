import { Injectable } from '@angular/core';
import { Interprete } from '../models/interprete';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class InterpreteService {

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Interprete[]> { 
    return this.http.get<Interprete[]>( "http://localhost:8080/api/interpreti/interpreti");
   }
}





   
 
 

