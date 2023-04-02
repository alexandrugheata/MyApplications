import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from '../models/employee.model';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.css']
})
export class EmployeComponent implements OnInit{
  @Input() employee: Employee;
  @Output() onRemoveEmployee = new EventEmitter<number>();
  @Output() onEditEmployee = new EventEmitter<number>();

  constructor() {
    this.employee =  {
      firstname: '',
      lastname: '',
      birthday: '',
      gender: '',
      education: '',
      company: '',
      jobExperience: 0,
      salary: 0,
      profile: '',
    };
  }

  ngOnInit(): void {
      console.log(this.employee);
  }

  deleteEmployeeClicked() {
    this.onRemoveEmployee.emit(this.employee.id);
  }

  editEmployeeClicked() {
    this.onEditEmployee.emit(this.employee.id);
  }


}
