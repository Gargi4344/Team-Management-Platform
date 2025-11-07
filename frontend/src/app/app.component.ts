import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  tasks: any[] = [];
  newTask = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks() {
    this.http.get<any[]>('http://localhost:8080/api/tasks').subscribe(data => {
      this.tasks = data;
    });
  }

  addTask() {
    const task = { title: this.newTask, status: 'Pending', assignedTo: 'Admin' };
    this.http.post('http://localhost:8080/api/tasks', task).subscribe(() => {
      this.getTasks();
      this.newTask = '';
    });
  }
}
