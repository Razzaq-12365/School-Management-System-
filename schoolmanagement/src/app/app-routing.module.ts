import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { ListStudentComponent } from './list-student/list-student.component';
import { ListTeacherComponent } from './list-teacher/list-teacher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { UpdateTeacherComponent } from './update-teacher/update-teacher.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { ViewTeacherComponent } from './view-teacher/view-teacher.component';

const routes: Routes = [
  {path:'addStudent',component:AddStudentComponent}, 
  {path:'getStudentById/:studentId',component:ViewStudentComponent},
  {path:'students',component:ListStudentComponent},
  {path:'updateStudentRecords/:studentId',component:UpdateStudentComponent},
  {path:'addTeacherRecord',component:AddTeacherComponent},
  {path:'getTeacherById/:teacherId',component:ViewTeacherComponent},
  {path:'teachers',component:ListTeacherComponent},
  {path:'updateTeacherRecords/teacherId',component:UpdateTeacherComponent},
  // {path:'',component:},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
