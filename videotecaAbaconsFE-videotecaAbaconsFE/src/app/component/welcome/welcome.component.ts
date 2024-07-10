import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{
  utente: string = "";
  titolo: string = "Benvenuti in Alpha Videoteca"; 
  sottotitolo: string = "Tantissimi film da vedere e scaricare";

  
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void { 
    this.utente = this.route.snapshot.params["userid"];
  }

  onNavigate(event: Event): void {
    const target = event.target as HTMLSelectElement;
    const selectedValue = target.value;
    if (selectedValue) {
      this.router.navigate([selectedValue]);
    }
  }
}





