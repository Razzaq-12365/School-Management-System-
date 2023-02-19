import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from 'model/teacher';
import { TeacherService } from 'service/teacher.service';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent {
  teacher:Teacher;
  constructor(private router:Router,private route:ActivatedRoute,private teacherService:TeacherService)
  {
    this.teacher = new Teacher();
  }
  onSubmit()
  {
    this.teacherService['saveTeacher'](this.teacher).subscribe((result:any)=>this.teacher=result);
    this.router.navigate(['teachers']);
    
  }
}
