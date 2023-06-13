import { Component, Inject } from '@angular/core';

import { NgIf } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss'],
  standalone: true,
  imports: [MatDialogModule, NgIf],
})

export class DialogComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}
}

export interface DialogData {
  title: string;
  message: string;
}
