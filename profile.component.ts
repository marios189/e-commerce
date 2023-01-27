import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import 'boxicons';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Profile } from '../profile';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private http: HttpClient,
    private router: Router,
    private login: LoginserviceService) { }

  username = localStorage.getItem('user')!.toUpperCase();

  orders? : boolean;
  wishes? : boolean;

  nome?:string
  cognome?: string 
  dataDiNascita?: Date
  indirizzo? : string
  user?:string



  ngOnInit(): void {
    let headers : HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    this.http.get<Profile[]>(`http://localhost:8080/profile/${this.username}`,
    {headers}
    ).subscribe(
      result =>{
        this.user=result[0].username,
        this.nome = result[0].nome,
        this.cognome = result[0].cognome,
        this.dataDiNascita = result[0].dataDiNascita
        this.indirizzo = result[0].indirizzo
      }
    ) 
  }

  openCart(){
    this.router.navigateByUrl('/shoppingcart')
  }

  logout(){
    let removeToken = localStorage.removeItem('access_token')
    if (removeToken == null){
      this.router.navigate(['/home'])
    }
  }

  home(){
    if(!localStorage.getItem('access_token')){
      this.router.navigate(['/home'])
      this.login.setFalse()
    }
    else{
      this.router.navigate(['/home'])
      this.login.setTrue()
    }
  }
}
