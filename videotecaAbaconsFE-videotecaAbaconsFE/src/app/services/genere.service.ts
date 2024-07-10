import { Injectable } from '@angular/core';
import { Genere } from '../models/genere';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GenereService {

   
  constructor(private http: HttpClient) { 
    
  } 
  public findAll(): Observable<Genere[]> { 
   return this.http.get<Genere[]>( "http://localhost:8080/api/generi/generi");
  }
}
