import { Component} from '@angular/core'; 

@Component({ 
 selector: 'app-root', 
 templateUrl: './app.component.html', 
 styleUrl: './app.component.css' 
}) 

export class AppComponent { 
 title = 'Alfa Videoteca'; 
 saluti: string = "Benvenuti sul portale Alfa Videoteca"; 
 titolo2 = "Scegli un film da scaricare"; 

}