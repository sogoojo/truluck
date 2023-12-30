import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Waybill } from './models/waybill';



@Injectable({
  providedIn: 'root'
})
export class HandshakeService {

  private apiUrl = 'http://localhost:8080/api/waybills';



    constructor(private http: HttpClient) { }


    searchWayBills(criteria: any): Observable<Waybill[]> {
      // Construct the search parameters
      const params = new HttpParams()
        .set('waybillNumber', criteria.waybillNumber || '')
        .set('supervisorName', criteria.supervisorName || '')
        .set('startDate', criteria.startDate || '')
        .set('endDate', criteria.endDate || '');
    
      // Make the HTTP GET request with the search parameters
      return this.http.get<Waybill[]>(`${this.apiUrl}/search`, { params });
    }
    

/*     searchWayBills(criteria: any):Observable<any>{
    let params = new HttpParams();
    if (criteria.waybillNumber) params = params.set('waybillNumber', criteria.waybillNumber);
    if (criteria.supervisorName) params = params.set('supervisorName', criteria.supervisorName);
    if (criteria.startDate) params = params.set('startDate', criteria.startDate);
    if (criteria.endDate) params = params.set('endDate', criteria.endDate);

    return this.http.get<any[]>(`${this.apiUrl}/search`, { params });

    } */

    commissionNewJob(waybill: Waybill): Observable<Waybill> {
      console.log('about to commision a new task')
        return this.http.post<Waybill>(`${this.apiUrl}/commission`, waybill);
      }
    
       getAllWaybills(): Observable<Waybill[]> {
      return this.http.get<Waybill[]>(this.apiUrl+ "/");
  }



}
