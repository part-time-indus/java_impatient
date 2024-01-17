package ch02.sec02;

import java.time.DayOfWeek;
import java.time.LocalDate;



public class Calendar {

    public int year;
    public int month;
    Calendar(int year, int month){
        this.year = year;
        this.month = month;

    }

    public static void main(String[] args){

        Calendar cal  = new Calendar(2024, 9);
        cal.displayCalendar();

    }
        private void displayCalendar() {
            // Display the month and year
            System.out.println("     " + getMonthName(month) + " " + this.year);
            System.out.println("SUN MON TUE WED THU FRI SAT");

            // Set the calendar to the first day of the specified month and year
            LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
            DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();

            // Print leading spaces for the first week
            if(dayOfWeek != DayOfWeek.SUNDAY) {
                for (int i = 0; i < dayOfWeek.getValue(); i++) {
                    System.out.print("   ");
                }
            }

            // Print the days of the month
            LocalDate currentDate = firstDayOfMonth;
            while (currentDate.getMonthValue() == month) {
                int day = currentDate.getDayOfMonth();
                if(currentDate.getDayOfWeek() == DayOfWeek.SUNDAY){
                    //RESEARCH: Why %2d && %1d print at the same spot?
                    System.out.printf("%2d ", day);

                }else {
                    System.out.printf("%3d ", day);
                }

                // Move to the next day
                currentDate = currentDate.plusDays(1);

                // Start a new line for the next week
                if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    System.out.println();
                }
            }

            System.out.println();  // Ensure a newline at the end
        }

        private String getMonthName(int month) {
            String[] monthNames = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };
            return monthNames[month - 1];
        }



//   private void print_days_of_week(){
//        StringBuilder days_of_week = new StringBuilder(DayOfWeek.of(7).name() + "  ");
//
//
//        for(int i = 1; i < DayOfWeek.values().length; i++){
//            days_of_week.append(DayOfWeek.of(i).name());
//            days_of_week.append("  ");
//        }
//        System.out.print(days_of_week);
//        System.out.println();
//   }
//
//   private int count_spaces(DayOfWeek day_of_week, boolean first_day_of_month){
//        int spaces = 0;
//        int curr_day_len = day_of_week.name().length();
//        if(day_of_week == DayOfWeek.SUNDAY){
//            return curr_day_len/2 - 1;
//        }
//        if(!first_day_of_month ){
//            DayOfWeek prevDay = day_of_week.minus(1);
//            int prev_day_len = prevDay.name().length();
//            spaces = (prev_day_len/2 + 2) + (((int) Math.ceil(curr_day_len/2.0)) - 1);
//        }else{
//            for(int i = 1; i < day_of_week.getValue(); i++){
//                spaces += DayOfWeek.of(i).name().length() + 2;
//            }
//            spaces += DayOfWeek.SUNDAY.name().length() + 2;
//            spaces += day_of_week.name().length()/2 - 1;
//        }
//
//        return spaces;
//   }
//   private void print_days_of_month(){
//
//        LocalDate date = LocalDate.of(year, month, 1);
//        do{
//            DayOfWeek day_of_week = date.getDayOfWeek();
//            int spaces = 0;
//            if(date.getDayOfMonth() == 1){
//                spaces = count_spaces(day_of_week, true);
//
//            }else {
//                spaces = count_spaces(day_of_week, false);
//            }
//            if(date.getDayOfMonth() > 9){
//                spaces--;
//            }
//            for(int i = 0; i <spaces; i++){
//                System.out.print(" ");
//            }
//            System.out.print(date.getDayOfMonth());
//            if(day_of_week == DayOfWeek.SATURDAY){
//                System.out.println();
//            }
//
//            date = date.plusDays(1);
//
//        }while(date.getMonth() == Month.of(month));
//        System.out.println();
//
//   }

}
