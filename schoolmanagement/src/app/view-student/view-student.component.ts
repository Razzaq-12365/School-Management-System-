import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'model/student';
import { StudentService } from 'service/student.service';

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit {
  studentId!:number;
  student!: Student;
  constructor(private route: ActivatedRoute, private router:Router,private studentService: StudentService) { }
  ngOnInit(): void {
    this.studentId = this.route.snapshot.params['studentId'];
    this.student = new Student();
    this.studentService.getStudent(this.studentId).subscribe( data => {
      this.student = data;
      console.log(data)
  })
  
}
list()
  {
    this.router.navigate(['students']);
  }
}
