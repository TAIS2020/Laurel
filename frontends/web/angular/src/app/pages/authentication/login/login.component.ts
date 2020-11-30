import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { fadeInUpAnimation } from '../../../../@fury/animations/fade-in-up.animation';
import {AuthService} from "../../../services/auth.service";
import * as xml2js from 'xml2js';
import { HttpClient, HttpHeaders } from '@angular/common/http';  


@Component({
  selector: 'fury-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  animations: [fadeInUpAnimation]
})
export class LoginComponent implements OnInit {
  
  public xmlItems: any;  
  form: FormGroup;

  inputType = 'password';
  visible = false;

  constructor(private router: Router,
              private fb: FormBuilder,
              private cd: ChangeDetectorRef,
              private snackbar: MatSnackBar,
              private authService: AuthService,
              private _http: HttpClient
  ) {
    this.loadXML();
  }

  loadXML() {  

    this._http.get('../assets/img/default.xml',  
    {  
      headers: new HttpHeaders()  
        .set('Content-Type', 'text/xml')  
        .append('Access-Control-Allow-Methods', 'GET')  
        .append('Access-Control-Allow-Origin', '*')  
        .append('Access-Control-Allow-Headers', "Access-Control-Allow-Headers, Access-Control-Allow-Origin, Access-Control-Request-Method"),  
      responseType: 'text'  
    })  
    .subscribe((data) => {  
        var parser = new xml2js.Parser();
        var k: string | number,  
        arr = [];

        parser.parseString(data, function (err, result) {
          for (k in result.configuration.feature) {
            var item = result.configuration.feature[k].$;
            var valor = (item.automatic!= undefined && item.automatic!= null )? true : ( (item.manual!= undefined && item.manual!= null)? true :false  );
          
            arr.push({  
              item: item.name,  
              activo: valor 
            });  
          }
          //console.log(JSON.stringify(arr));
          localStorage.setItem("Permisos", JSON.stringify(arr));
         });
    });  


  }  

  ngOnInit() {
    this.form = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  send() {

    this.authService.SignIn(
        this.form.controls["email"].value,
        this.form.controls["password"].value
    ).then(result => {
      console.log("Que es esto: ", result)
      this.router.navigate(['/marketplace'])
    }).catch(error => {
      alert(error.message)
    })
    // this.router.navigate(['/marketplace']);
    //this.snackbar.open('Lucky you! Looks like you didn\'t need a password or email address! For a real application we provide validators to prevent this. ;)', 'LOL THANKS', {
    //  duration: 10000
    //});
  }

  toggleVisibility() {
    if (this.visible) {
      this.inputType = 'password';
      this.visible = false;
      this.cd.markForCheck();
    } else {
      this.inputType = 'text';
      this.visible = true;
      this.cd.markForCheck();
    }
  }
}
