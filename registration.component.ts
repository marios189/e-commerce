import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username?:string;
  password?:string;
  nomeUser?:string
  dataDiNascita?:Date
  cognomeUser?:string
  indirizzo?:string

  constructor(private http: HttpClient, private router:Router,
    private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  nuovoUtente(){
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    this.http.post<User>('http://localhost:8080/register',
    {
      username:this.username,
      password:this.password,
      nome:this.nomeUser,
      cognome:this.cognomeUser,
      dataDiNascita:this.dataDiNascita,
      indirizzo:this.indirizzo
    },{headers}
    ).subscribe(
      result => {
        if(result!=null){
          this.modalService.dismissAll()
          this.router.navigateByUrl('/home')
        }else{
          alert("username già utilizzato")
        }
      }
    );
  }
  
  open(content:any){
    this.modalService.open(content)
  }
}