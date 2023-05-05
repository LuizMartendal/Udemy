import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  public icon = 'Sun.png'

  constructor() {}

  changeTheme() {
    const theme = document.body.classList.toggle('darkTheme');

    if (theme) {
      return this.icon = 'Moon.png'
    }
    return this.icon = 'Sun.png'
  }
}
