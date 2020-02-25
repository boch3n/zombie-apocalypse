import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  welcome: string;

  constructor() {
    this.welcome = "Zombie apocalypse has started...";
  }


}
