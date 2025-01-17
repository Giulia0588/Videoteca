import { Component } from '@angular/core';
import { AuthorizationService } from '../../services/authorization.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {
  constructor(private BasicAuth: AuthorizationService) { } 
  ngOnInit(): void { 
  this.BasicAuth.clearAll(); 
  } 
}
