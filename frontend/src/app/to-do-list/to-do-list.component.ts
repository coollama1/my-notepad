import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-to-do-list',
  template: `
    <p>
      to-do-list works!
    </p>
  `,
  styles: [
  ]
})
export class ToDoListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
