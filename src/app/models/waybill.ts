export interface Waybill {
  number: string;
  clientName: string;
  truckNumber: string;
  dateIssued: Date;
  status: string;
  tripAllowance: number;
  invoiceNumber: string;
  supervisorName: string;
}
