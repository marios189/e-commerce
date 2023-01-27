import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Accesso } from '../accesso';
import 'boxicons';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  username?:string
  password?:string
  logged = this.login.getLogged()
  error = this.login.getError()


	constructor(private http: HttpClient,
    private router: Router,
    private modalService: NgbModal,
    private login : LoginserviceService
   ) {}

  ngOnInit(): void {   
  }


  save(){
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    this.http.post<Accesso>('http://localhost:8080/authenticate',
    {
      username:this.username,
      password:this.password
    },
     {headers}
    ).subscribe(
      result => {
        if(result!=null){
          this.error=false
          this.logged=true
          localStorage.setItem('user',this.username!);
          localStorage.setItem('access_token',result.jwtToken)
          this.modalService.dismissAll()
        }else{
          this.error = true
          console.log("Credenziali errate")
        }
      }
    );
  }

  logout(){
    let removeToken = localStorage.removeItem('access_token')
    if (removeToken == null){
      this.logged=false
      this.router.navigate(['/home'])
    }
  }

  getToken(){
    return localStorage.getItem('access_token')
  }

  open(content:any) {
		this.modalService.open(content)
  }

  profilo() {
    this.logged = true
    this.router.navigate(['/profile'])
  }

  openCart(){
    this.router.navigateByUrl('/shoppingcart')
  }
}