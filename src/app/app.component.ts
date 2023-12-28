import { Component, OnInit } from '@angular/core';
import { HandshakeService } from './handshake.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {
  title = 'truluck';
  greeting = ''; // New property for the greeting message
  isNewJobModalOpen = false;

   // Define the search criteria model
    searchCriteria = {
      waybillNumber: '',
      supervisorName: '',
      startDate: '',
      endDate: ''
    };

  // Add more mock waybills as needed
  mockWaybills = [
    { number: 'WB001', client: 'Client A', truck: 'TX1234', date: new Date(), status: 'Delivered', trip: 4000, invoice: "", supervisor: "Segun" },
    { number: 'WB002', client: 'Client B', truck: 'TX1235', date: new Date(), status: 'In Transit', trip: 2000, invoice: "", supervisor: "Kola" },
    // ... more mock waybills ...
  ];

  // Inject the ExampleService
  constructor(private handshake: HandshakeService) {}

  // Implement the ngOnInit method
  ngOnInit() {
    // Fetch the greeting from the backend and assign it to the greeting property
    this.handshake.getGreeting().subscribe(data => {
      this.greeting = data;
    });
  }

  openNewJobModal() {
    this.isNewJobModalOpen = true;
  }

  closeNewJobModal() {
    this.isNewJobModalOpen = false;
  }
  // Method to perform the search
    performSearch() {
      console.log('Searching with criteria:', this.searchCriteria);
      // Here you will call the service method that performs the search
      // For example:
      // this.handshakeService.searchWaybills(this.searchCriteria).subscribe(results => {
      //   this.mockWaybills = results;
      // });
      }
}
