import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculatorComponent } from './calculator/calculator.component';
import { CalendarComponent } from './calendar/calendar.component';
import { NotesComponent } from './notes/notes.component';
import { ToDoListComponent } from './to-do-list/to-do-list.component';

const routes: Routes = [
  {path: '', component : NotesComponent},
  {path: 'notes', component : NotesComponent},
  {path: 'calendar', component : CalendarComponent},
  {path : 'to-do-list', component : ToDoListComponent},
  {path : 'calculator', component : CalculatorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [NotesComponent, CalendarComponent, ToDoListComponent, CalculatorComponent]