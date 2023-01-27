import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ListaOrdini } from '../listaOrdini';
import { product } from '../product';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  username = localStorage.getItem('user')
  ordersByUser : ListaOrdini[] = []
  orders = false

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    this.http.get<ListaOrdini[]>(`http://localhost:8080/${this.username}/orders`,
     {headers}
    ).subscribe(
      result => {
        if(result.length > 0){
          this.ordersByUser = result
          this.orders = true
          console.log(result)
        }
      }
    );
  }
}
