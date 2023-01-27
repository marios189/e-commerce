import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { ExpiredSessionComponent } from './expired-session/expired-session.component';
import { HeaderComponent } from './header/header.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductComponent } from './product/product.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistrationComponent } from './registration/registration.component';
import { ShoppingcartComponent } from './shoppingcart/shoppingcart.component';

const routes: Routes = [
  {path:'registration',component : RegistrationComponent},
  {path:'home', component : HeaderComponent},
  {path:'profile', component : ProfileComponent, canActivate : [AuthGuard]},
  {path:'expiredSession', component : ExpiredSessionComponent},
  {path:'products', component : ProductComponent},
  {path:'shoppingcart', component: ShoppingcartComponent, canActivate:[AuthGuard]},
  {path:'orders', component:OrdersComponent, canActivate:[AuthGuard]},
  {path:'', redirectTo:'home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
