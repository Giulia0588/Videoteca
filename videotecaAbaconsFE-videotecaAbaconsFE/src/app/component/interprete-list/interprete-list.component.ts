import { Component } from '@angular/core';
import { InterpreteService } from '../../services/interprete.service';
import { Interprete } from '../../models/interprete';

@Component({
  selector: 'app-interprete-list',
  templateUrl: './interprete-list.component.html',
  styleUrl: './interprete-list.component.css'
})
export class InterpreteListComponent {

  titolo: string = "Interpreti";
  sottotitolo: string = "Scegli l'interprete di cui ti interessa un film";
  descrizione: string = "";
  interprete: string = "";
  interpreti: Interprete[] = [];

  constructor(private interpreteService: InterpreteService){

  }

  ngOnInit(){
    this.interpreteService.findAll().subscribe({
      next: (data) => {
        this.interpreti = data;
        console.log(data);
      },
      error: (e) => {
        console.error("errore ", e.message);
      }
    });
  }
}