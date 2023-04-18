import { Component, DoCheck } from '@angular/core';
import { TaskList } from '../../model/task-list';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements DoCheck {

  public taskList: Array<TaskList> = [];

  constructor() { }

  ngDoCheck(): void {
    this.getListFromLocalStorage();
    this.setListToLocalStorage();
  }

  setItemTaskList(event: any) {
    this.taskList.push({
      task: event,
      checked: false
    });
  }

  deleteItemTaskList(event: number) {
    this.taskList.splice(event, 1);
  }

  deleteAllTasks() {
    const confirm = window.confirm("Você realmente deseja deletar tudo?");

    if (confirm) {
      this.taskList = [];
    }
  }

  getListFromLocalStorage() {
    this.taskList = JSON.parse(localStorage.getItem('list') || '[]');
  }

  setListToLocalStorage() {
    if (this.taskList) {
      this.taskList.sort((first, last) => Number(first.checked) - Number(last.checked));
      localStorage.setItem('list', JSON.stringify(this.taskList));
    }
  }
}
