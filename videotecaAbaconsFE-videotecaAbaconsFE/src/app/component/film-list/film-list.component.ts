import { Component } from '@angular/core';
import { FilmService } from '../../services/film.service';
import { Film } from '../../models/film';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrl: './film-list.component.css'
})
export class FilmListComponent {
  titolo: string = "Film in catalogo";
  sottotitolo: string = "Scegli il film"; 
  ricerca: string = "";
  films: Film[] = [];

  constructor(private filmService: FilmService, private route: ActivatedRoute) {
    
  } 

  ngOnInit() { 
    // this.ricerca = this.route.snapshot.params ["ricerca"];
    if(this.ricerca){
      this.filmService.findRicerca(this.ricerca).subscribe({
        next: (data) => { 
          this.films = data; 
          console.log(data); 
        }, 
        error: (e) => { 
          console.error("errore ", e.message); 
        } 
      });
    }else{
      this.filmService.findAll().subscribe({
        next: (data) => { 
          this.films = data; 
          console.log(data); 
        }, 
        error: (e) => { 
          console.error("errore ", e.message); 
        } 
      });
    }
  
  }
}





