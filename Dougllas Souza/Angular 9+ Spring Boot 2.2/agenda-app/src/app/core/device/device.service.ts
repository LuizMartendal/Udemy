import { Injectable } from '@angular/core';
import { DeviceDetectorService } from 'ngx-device-detector';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(
    private deviceDetector: DeviceDetectorService
  ) { }

  isMobile() {
    return this.deviceDetector.isMobile();
  }
}
