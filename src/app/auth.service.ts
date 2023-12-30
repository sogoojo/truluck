// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Import to make HTTP requests
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://yourbackend.endpoint/api'; // Replace with your actual API endpoint

  constructor(private http: HttpClient) {}

  // Implement the login method
  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, { username, password }).pipe(
      tap(response => {
        // Assuming the response contains a token, save it
        localStorage.setItem('token', response.token);
      })
    );
  }

  // Implement the logout method
  logout() {
    // Remove the token from local storage (or wherever it's stored)
    localStorage.removeItem('token');
  }

  // Helper method to check if the user is logged in
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }
}
