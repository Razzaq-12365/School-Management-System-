import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'model/student';
import { StudentService } from 'service/student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  studentId!: number;
  student!: Student;
  constructor(private router:Router,private route:ActivatedRoute,private studentService:StudentService){}
  ngOnInit(){
    this.student = new Student();
    this.studentId = this.route.snapshot.params['studentId'];
    this.studentService.getStudent(this.studentId).subscribe(data=>{
      this.student = data;
      console.log(data)
    });
  }
  onSubmit()
  {
    this.studentService.updateStudent(this.studentId, this.student).subscribe( data =>{
      // this.goToEmployeeList();
      this.router.navigate(['students']);
    })
  }
}
