import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PremiumEstimateComponent } from './premium-estimate/premium-estimate.component';
import { RenewInsuranceComponent } from './renew-insurance/renew-insurance.component';
import { BuyInsuranceComponent } from './buy-insurance/buy-insurance.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent},
  { path: 'userDashboard', component: UserDashboardComponent},
  { path: 'adminDashboard', component: AdminDashboardComponent},
  { path: 'login', component: LoginComponent },
  { path: 'claimInsurance', component: ClaimInsuranceComponent },
  { path: 'buyInsurance', component: BuyInsuranceComponent },
  { path: 'renewInsurace', component: RenewInsuranceComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'premiumEstimate', component: PremiumEstimateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
