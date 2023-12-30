import { Component, OnInit } from '@angular/core';
import { HandshakeService } from './handshake.service';
import { Waybill } from './models/waybill'; // Assuming you have a Waybill model

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  // A flag to indicate if the user is logged in or not
  isLoggedIn = false;
  title = 'truluck';
  isNewJobModalOpen = false;
  mockWaybills: Waybill[] = []; // Define mockWaybills as an array of Waybill


  // Define the search criteria model
  searchCriteria = {
    waybillNumber: '',
    supervisorName: '',
    startDate: '',
    endDate: ''
  };

  // Inject the HandshakeService with consistent naming
  constructor(private handshakeService: HandshakeService) {}

  // Implement the ngOnInit method
  ngOnInit() {
    this.loadAllWaybills();
  }

  openNewJobModal() {
    this.isNewJobModalOpen = true;
  }

  closeNewJobModal() {
    this.isNewJobModalOpen = false;
  }

  updateLoginStatus(status: boolean){
    this.isLoggedIn = status;
  }

  clients: { id: number; name: string }[] = [
    { id: 1, name: 'Client A' },
    { id: 2, name: 'Client B' },
    { id: 3, name: 'Client C' },
    // ... more clients
  ];

    // Object to capture form data for new job commission
    newWaybill: Waybill = {
      number: '',
      clientName: '',
      truckNumber: '',
      dateIssued: new Date(), // Initialize with a default value or make it undefined
      status: 'New',
      tripAllowance: 0,
      invoiceNumber: '',
      supervisorName: '',
    };

    loadAllWaybills() {
      this.handshakeService.getAllWaybills().subscribe(
        (waybills: Waybill[]) => {
         console.log("Received waybills:", waybills); // Check the logged array
          this.mockWaybills = waybills;
        },
        (error: any) => {
          console.error('Error fetching waybills:', error);
        }
      );
    }
  // Method to perform the search
  performSearch() {
    console.log('Searching with criteria:', this.searchCriteria);
    this.handshakeService.searchWayBills(this.searchCriteria).subscribe(
      (results: Waybill[]) => { // Providing a type for 'results'
        this.mockWaybills = results; // Assuming the results are in the same format as mockWaybills
      },
      (error: any) => { // Providing a type for 'error'
        console.error('Search failed:', error);
      }
    );
  }

    commissionJob(waybill: Waybill) {
      this.handshakeService.commissionNewJob(waybill).subscribe(
        (savedWaybill: Waybill) => {
          console.log('Saved Waybill', savedWaybill);
          this.closeNewJobModal(); // Close the modal after saving
          // Optionally refresh the list or display a success message
          this.loadAllWaybills();
        },
        (error) => {
          console.error('Error commissioning new job', error);
          // Handle errors here, like showing an error message
        }
      );
    }

      onSubmit(formValues: any) {
        const newWaybill: Waybill = {
          // Map the form values to your Waybill model
          number: formValues.number,
          clientName: formValues.client,
          truckNumber: formValues.truckNumber,
          dateIssued: new Date(formValues.dateIssued), // Adjust date handling as needed
          status: 'New', // Set initial status, this could be dynamic as well
          tripAllowance: formValues.tripAllowance, // Make sure to parse or convert to the correct type
          invoiceNumber: '', // Initial value, update as necessary
          supervisorName: formValues.drivername // Adjust according to your form field
        };

        this.commissionJob(newWaybill);
      }

    }

