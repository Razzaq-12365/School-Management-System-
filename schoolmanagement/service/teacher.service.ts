import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Teacher } from 'model/teacher';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private addUrl:string;
  private getAllUrl:string;
  private updateUrl:string;
  private getByIdUrl:string; 
  private deleteByIdUrl:string; 

  constructor(private http:HttpClient) {
    this.addUrl ="http://localhost:8080/addTeacherRecord";
    this.getAllUrl="http://localhost:8080/teachers";
    this.updateUrl="http://localhost:8080/updateTeacherRecords";
    this.getByIdUrl="http://localhost:8080/getTeacherById";
    this.deleteByIdUrl="http://localhost:8080/deleteRecordById";
   }
   public saveTeacher(teacher:Teacher)
   {
     return this.http.post<Teacher>(this.addUrl,teacher);
   }
   public getTeacherList():Observable<Teacher[]>
   {
     return this.http.get<Teacher[]>(this.getAllUrl);
   }
   updateTeacher(teacherId:number, teacher:Teacher):Observable<Object>{
     return this.http.put<Teacher>(`${this.updateUrl}/${teacherId}`, teacher)
   }
   getTeacher(teacherId:number):Observable<Teacher>
   {
     return this.http.get<Teacher>(`${this.getByIdUrl}/${teacherId}`)
   }
   deleteTeacher(teacherId: number): Observable<any> {
     return this.http.delete(`${this.deleteByIdUrl}/${teacherId}`, { responseType: 'text' });
   }
}
