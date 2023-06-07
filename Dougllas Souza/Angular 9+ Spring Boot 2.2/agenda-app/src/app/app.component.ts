import { Component, OnInit } from '@angular/core';
import { DeviceService } from './core/device/device.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  isMobile: boolean = false;

  constructor(
    private deviceService: DeviceService
  ) {}

  ngOnInit(): void {
      this.isMobile = this.deviceService.isMobile();
  }
}
