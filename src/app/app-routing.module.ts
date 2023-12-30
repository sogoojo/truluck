import { NgModule } from '@angular/core';
import { RouterModule, Routes, RoutesRecognized } from '@angular/router';
//import { LoginComponent } from './login.component'; // Import your login component

const routes: Routes =[]
 
/* const routes: Routes = [
  { path: 'login', component: LoginComponent },
  // Remove or comment out the line about DashboardComponent
  { path: '', redirectTo: '/login', pathMatch: 'full' }
]; */

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
