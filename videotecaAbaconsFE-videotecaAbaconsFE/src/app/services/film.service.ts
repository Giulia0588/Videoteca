import { Injectable } from '@angular/core';
import { Film } from '../models/film';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


export class FilmService {

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Film[]> { 
    return this.http.get<Film[]>("http://localhost:8080/api/films/films");
   }

   public findRicerca(ricerca: string): Observable<Film[]> { 
    return this.http.get<Film[]>(`http://localhost:8080/api/films/ricercaGenerica?ricerca=${ricerca}`);
   }



}


