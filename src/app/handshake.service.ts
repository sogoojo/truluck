import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HandshakeService {

  private backendUrl = 'http://localhost:8080/greeting'; // Change the port if your Spring Boot runs on a different one

    constructor(private http: HttpClient) { }

    getGreeting(): Observable<string> {
      return this.http.get<string>(this.backendUrl, { responseType: 'text' as 'json' });
    }
}
