import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from 'model/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private addStudentUrl:string;
  private getStudentByIdUrl:string;
  private getAllStudentsUrl:string;
  private updateStudentUrl:string;
  private deleteStudentUrl:string;
  getStudentRecordUrl: any;
  constructor(private http:HttpClient) { 
    this.addStudentUrl="http://localhost:8080//addStudent";
    this.getStudentByIdUrl="http://localhost:8080//getStudentById";
    this.getAllStudentsUrl="http://localhost:8080//students";
   this.updateStudentUrl="http://localhost:8080//updateStudentRecords";
   this.deleteStudentUrl="http://localhost:8080//deleteRecordById";
  }
  public saveStudent(student:Student)
  {
    return this.http.post<Student>(this.addStudentUrl,student);
  }
  public getStudentList():Observable<Student[]>
  {
    return this.http.get<Student[]>(this.getAllStudentsUrl);
  }
  updateStudent(studentId:number, student:Student):Observable<Object>{
    return this.http.put<Student>(`${this.updateStudentUrl}/${studentId}`, student)
  }
  getStudent(studentId:number):Observable<Student>
  {
    return this.http.get<Student>(`${this.getStudentByIdUrl}/${studentId}`)
  }
  deleteStudent(studentId: number): Observable<any> {
    return this.http.delete(`${this.deleteStudentUrl}/${studentId}`, { responseType: 'text' });
  }
}
