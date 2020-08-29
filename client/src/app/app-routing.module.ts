import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RenewComponent } from './renew/renew.component';
import { PlansComponent } from './plans/plans.component';
import { BuyInsuranceComponent } from './buy-insurance/buy-insurance.component';
import { EstimateComponent } from './estimate/estimate.component';
import { ClaimComponent } from './claim/claim.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
//import { PlanSelectComponent } from './plan-select/plan-select.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CongratulationsComponent } from './congratulations/congratulations.component';
import { ClaimStatusComponent } from './claim-status/claim-status.component';
import { ContactComponent } from './contact/contact.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { OtpComponent } from './otp/otp.component';
import { AboutComponent } from './about/about.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
const routes: Routes = [
  {path: 'renew', component: RenewComponent},
  {path: 'plans', component: PlansComponent},
  {path: 'buyInsurance', component: BuyInsuranceComponent},
  {path: 'claimInsurance', component: ClaimComponent},
  {path: 'estimate', component: EstimateComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  { path: '', component: HomeComponent },
  { path: 'userDashboard', component: UserDashboardComponent },
  { path: 'adminDashboard', component: AdminDashboardComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'congratulations', component: CongratulationsComponent },
  { path: 'claimStatus', component: ClaimStatusComponent },
  { path: 'contactUs', component: ContactComponent},
  { path: 'otp', component: OtpComponent },
  { path: 'forgetPassword', component: ForgetPasswordComponent },
  { path: 'about', component: AboutComponent },
  { path: 'resetPassword', component: ResetPasswordComponent }
  //{path: 'plan-select', component: PlanSelectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
