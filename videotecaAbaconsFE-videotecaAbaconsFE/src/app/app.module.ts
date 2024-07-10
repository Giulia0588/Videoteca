import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './component/welcome/welcome.component';
import { LoginComponent } from './component/login/login.component';
import { ErrorComponent } from './component/error/error.component';
import { FilmComponent } from './component/film/film.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FooterComponent } from './component/footer/footer.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';
import { LogoutComponent } from './component/logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { GenereListComponent } from './component/genere-list/genere-list.component';
import { InterpreteListComponent } from './component/interprete-list/interprete-list.component';
import { HomeComponent } from './component/home/home.component';
import { FilmListComponent } from './component/film-list/film-list.component';



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    FilmComponent,
    NavbarComponent,
    FooterComponent,
    JumbotronComponent,
    LogoutComponent,
    GenereListComponent,
    InterpreteListComponent,
    HomeComponent,
    FilmListComponent,
 ], 
 imports: [ 
 BrowserModule, 
 AppRoutingModule, 
 FormsModule,
 HttpClientModule 
 ], 
 providers: [provideClientHydration()],
  bootstrap: [AppComponent]
})
export class AppModule { }

