import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { product } from '../product';
import 'boxicons'
import { CartService } from '../cart.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

    products: product[] = [];
    filtri = false
    size? :string
    prodottiFiltrati? : product[]
    quantity?:number
  
    sizes = ["S","M","L"]

  constructor(private http: HttpClient,
    private cart : CartService,
    private modalService : NgbModal,
    private router: Router,
    private login: LoginserviceService) { }

  ngOnInit(): void {
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type':'application/json',
    });
    this.http.get<product[]>('http://localhost:8080/product/all',
    {headers}
    ).subscribe(
      result => {
      this.products = result;
     },
    );
  }

  addToCart(p : product){
    this.cart.addToCart(p);
  }

  cerca(){
    this.filtri = true
    let headers: HttpHeaders = new HttpHeaders({
      'Content-type': 'application/json'
    });
    this.http.get<product[]>(`http://localhost:8080/product/${this.size}`,
    {headers}
    ).subscribe(
      result => {
        this.prodottiFiltrati = result
        console.log(result)
      } 
    )
  }

  open(content:any) {
		this.modalService.open(content)
  }

  resetFilter(){
    this.size="";
    this.filtri=false
  }
}