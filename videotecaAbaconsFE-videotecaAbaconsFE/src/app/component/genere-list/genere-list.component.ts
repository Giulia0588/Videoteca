import { Component } from '@angular/core';
import { GenereService } from '../../services/genere.service';
import { Genere } from '../../models/genere';

@Component({
  selector: 'app-genere-list',
  templateUrl: './genere-list.component.html',
  styleUrl: './genere-list.component.css'
})
export class GenereListComponent {
  titolo: string = "Generi";
  sottotitolo: string = "Scegli il genere che vuoi vedere";
  generi: Genere[] = [];

  constructor(private genereService: GenereService) {
    
  } 

  ngOnInit() { 
    this.genereService.findAll().subscribe({
      next: (data) => { 
        this.generi = data; 
        console.log(data); 
      }, 
      error: (e) => { 
        console.error("errore ", e.message); 
      } 
    });
  }
}



