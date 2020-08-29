import { Component} from '@angular/core';
import { Policy } from './policy';
import { Customer } from './customer';
import { RenewService } from './renew.service';
import { InsurancePlan } from './insurance_plan';
import { Router } from '@angular/router';
//import { NavigationExtras } from '@angular/router';
//import { Router, ActivatedRoute, ParamMap, RouterModule } from '@angular/router';
@Component({
  selector: 'app-renew',
  templateUrl: './renew.component.html',
  styleUrls: ['./renew.component.css']
})
export class RenewComponent{

policy: Policy = new Policy();
customer: Customer = new Customer();
insurance_plan: InsurancePlan = new InsurancePlan();

  constructor(private renewService: RenewService, private router: Router) { }

  renewPlan(){
    
    //alert(JSON.stringify(this.policy));
    this.renewService.renew(this.policy).subscribe(data => {
    alert(JSON.stringify(data));
    })
    alert("Thank you ! Please proceed for payment");
    
   this.router.navigate(['payment']);
  }


}