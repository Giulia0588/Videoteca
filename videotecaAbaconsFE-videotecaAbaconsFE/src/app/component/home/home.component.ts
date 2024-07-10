import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorizationService } from '../../services/authorization.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  titolo: string = "Benvenuti in Alfa Videoteca";
  sottotitolo: string = "Tantissimi film da vedere";

  constructor(private route: Router, private BasicAuth: AuthorizationService) { }

  ngOnInit(): void {
    if(this.BasicAuth.isLogged()){
      this.route.navigate(['welcome', this.BasicAuth.loggedUser()]);
    }
  }
}






  