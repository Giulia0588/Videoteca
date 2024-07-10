import { NgModule } from '@angular/core'; 
import { RouterModule, Routes } from '@angular/router'; 
import { LoginComponent } from './component/login/login.component'; 
import { WelcomeComponent } from './component/welcome/welcome.component'; 
import { HomeComponent } from './component/home/home.component';
import { ErrorComponent } from './component/error/error.component'; // Importa ErrorComponent
import { RouteGuardService } from './services/route-guard.service';
import { LogoutComponent } from './component/logout/logout.component';
import { GenereListComponent } from './component/genere-list/genere-list.component';
import { InterpreteListComponent } from './component/interprete-list/interprete-list.component';
import { FilmListComponent } from './component/film-list/film-list.component';
 
const routes: Routes = [ 
  {path:"", component: LoginComponent }, 
  {path:"login", component: LoginComponent }, 
  {path: 'welcome/:userid', component: WelcomeComponent, canActivate:[RouteGuardService]},
  {path: 'index', component: HomeComponent },
  {path:'film', component : FilmListComponent, canActivate:[RouteGuardService]},
  {path:'film/:ricerca', component : FilmListComponent, canActivate:[RouteGuardService]},
  {path:'generi', component : GenereListComponent, canActivate:[RouteGuardService]},
  {path:'interpreti', component : InterpreteListComponent, canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent},
  {path: '**', component: ErrorComponent }
  
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }








 




