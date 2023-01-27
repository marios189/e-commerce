import { Injectable } from '@angular/core';
import { product } from './product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  totale = 0
  productsToBuy? : product[] = []
  

  constructor() { }

  addToCart(p : product){
    this.productsToBuy?.push(p)
    this.totale += p.price
  }

  removeFromCart(p: product){
    for(let i=0;i<this.productsToBuy!.length;i++){
      if(this.productsToBuy![i]=== p){
        this.productsToBuy!.splice(i,1)
      }
    }
    this.totale = this.totale! - p.price
   }


  getCart(){
    return this.productsToBuy
  }

  getTotale(){
    return this.totale
  }

  clearCart(){
    this.productsToBuy = []
    this.totale = 0
  }
}