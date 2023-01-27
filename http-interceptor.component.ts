import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-http-interceptor',
  templateUrl: './http-interceptor.component.html',
  styleUrls: ['./http-interceptor.component.css']
})
export class HttpInterceptorComponent implements HttpInterceptor {

  constructor(private auth : HeaderComponent, private router: Router) { }

  ngOnInit(): void {
  }

  intercept(req: HttpRequest<any> , next : HttpHandler) : Observable<HttpEvent<any>> {
    let url = req.url.includes('profile') || req.url.includes('orders') || req.url.includes('shoppingcart')
    const authToken = this.auth.getToken()
    if(authToken && url){
      const cloned = req.clone({
        headers : req.headers.set('Authentication', authToken!)
      })
      return next.handle(cloned).pipe(catchError((a:HttpErrorResponse) => {
        if(a.status === 401){
          this.router.navigateByUrl('/expiredSession')
        }
        return throwError(() =>a)
      }))
    }else{
      return next.handle(req)
    }
  }

}
