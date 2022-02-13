import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NoteService } from './note.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public notes: Note[] = [];
  public title : string  = "";
  constructor(private noteService : NoteService){}

  ngOnInit(){
    this.getEmployees();
  }

  public getEmployees() : void{
    this.noteService.getNotes().subscribe(
      (response : Note[]) =>{
        this.notes = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }
}
