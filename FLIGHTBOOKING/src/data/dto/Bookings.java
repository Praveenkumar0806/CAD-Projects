package data.dto;

public class Bookings {
   private int bookingId;
   private String bookingDate;
   private User user;
   private Flights flights;

   public Bookings(int bookingId,String bookingDate,User user,Flights flights)
   {
       this.bookingId=bookingId;
       this.bookingDate=bookingDate;
       this.user=user;
       this.flights=flights;
   }

   public int getBookingId() {
       return bookingId;
   }
   public String getBookingDate(){
       return bookingDate;
   }
   public User getUser() {
       return user;
   }
   public Flights getFlights(){
       return flights;
   }

   public void setBookingId(int bookingId){
       this.bookingId=bookingId;
   }
   public void setBookingDate(String bookingDate){
       this.bookingDate=bookingDate;
   }
   public void setUser(User user){
       this.user=user;
   }
   public void setFlights(Flights flights){
       this.flights=flights;
   }
}
