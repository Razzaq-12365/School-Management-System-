import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherService } from 'service/teacher.service';

@Component({
  selector: 'app-list-teacher',
  templateUrl: './list-teacher.component.html',
  styleUrls: ['./list-teacher.component.css']
})
export class ListTeacherComponent implements OnInit {
  teacher:any;
  constructor(private teacherService:TeacherService, private router:Router, ){}
  ngOnInit(){
   this.teacherService.getTeacherList().subscribe(data=>{
    this.teacher=data;
   });
  }
  deleteTeacherRecord(teacherId: number) {
    this.teacherService.deleteTeacher(teacherId)
      .subscribe(
        data => {
          alert("data deleted successfully")
          console.log(data);
          this.ngOnInit();
        })
}
teachersDetails(teacherId: number){
  this.router.navigate(['getTeacherById', teacherId]);
}
updateTeacherRecord(teacherId:number)
{
  this.router.navigate(['updateTeacherRecords', teacherId]);
}
}
