import { Component, OnInit } from '@angular/core'; 
import { ActivatedRoute } from '@angular/router'; // Importa ActivatedRoute da @angular/router

export class FilmClass {
 constructor ( 
 public id: number, 
 public titolo: string, 
 public anno: string, 
 public genere: string 
 ) {} 
} 

@Component({ 
 selector: 'app-film', 
 templateUrl: './film.component.html', 
 styleUrls: ['./film.component.css'] 
}) 
export class FilmComponent implements OnInit { 

  titolo: string = "Film in catalogo";
  sottotitolo: string = "Scopri i film disponibili";
  utente: string = "";
  film = [ 
  new FilmClass(1, "L'accademia del bene e del male", "2019", "Fantastico"), 
  new FilmClass(2, "Blonde", "2018", "Drammatico"), 
  new FilmClass(3, "Midsommar", "2020", "Horror"), 
  new FilmClass(4, "Cena con delitto", "2019", "Giallo"), 
  new FilmClass(5, "Il mostro dei mari", "2021", "Animazione"), 
  new FilmClass(6, "Persuasione", "2017", "Commedia"), 
  new FilmClass(7, "Non succede, ma se succede...", "2018", "Commedia"), 
  new FilmClass(8, "E' stata la mano di dio", "2020", "Drammatico"), 
  new FilmClass(9, "Bubble", "2021", "Fantascenza") 
  ];

  
  

  constructor(private route: ActivatedRoute) { } 

  ngOnInit(): void { 
    this.utente = this.route.snapshot.params ["userId"]; 
   }
  }


 
 









