import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-end';

  form: FormGroup = new FormGroup({
    description : new FormControl('')
  })

  submit(){
    console.log(this.form.value)
  }
}