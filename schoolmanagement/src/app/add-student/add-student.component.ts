import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'model/student';
import { Teacher } from 'model/teacher';
import { StudentService } from 'service/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
student:Student;
constructor(private router:Router,private route:ActivatedRoute,private studentService:StudentService){
  this.student = new Student();
}
onSubmit()
{
  this.studentService['saveStudent'](this.student).subscribe((result:any)=>this.student=result);
  this.router.navigate(['students']);
  //this.doctorService['addDoctorRecordUrl'](this.doctor).subscribe((result:any)=>this.doctor=result);
  
}
}
