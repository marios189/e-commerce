import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor() { }

  logged? : boolean
  error?: boolean

  setFalse(){
    this.logged = false
  }

  setTrue(){
    this.logged=true
  }

  getLogged(){
    return this.logged
  }

  credenzialiErrate(){
    this.error = true
  }

  getError(){
    return this.error
  }
}
