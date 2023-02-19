import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { ListTeacherComponent } from './list-teacher/list-teacher.component';
import { ListStudentComponent } from './list-student/list-student.component';
import { UpdateTeacherComponent } from './update-teacher/update-teacher.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { ViewTeacherComponent } from './view-teacher/view-teacher.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTeacherComponent,
    AddStudentComponent,
    ListTeacherComponent,
    ListStudentComponent,
    UpdateTeacherComponent,
    UpdateStudentComponent,
    ViewStudentComponent,
    ViewTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
