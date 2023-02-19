import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'service/student.service';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
student:any;
constructor(private studentService:StudentService, private router:Router, ){}
  ngOnInit() {
    this.studentService.getStudentList().subscribe(data=>{
      this.student = data;
      console.log(data)
    })
  }
  deleteStudentRecord(studentId: number) {
    this.studentService.deleteStudent(studentId)
      .subscribe(
        data => {
          alert("data deleted successfully")
          console.log(data);
          this.ngOnInit();
        })
}
studentDetails(studentId: number){
  this.router.navigate(['getStudentById', studentId]);
}
updateStudentRecord(studentId:number)
{
  this.router.navigate(['updateStudentRecords', studentId]);
}
}
