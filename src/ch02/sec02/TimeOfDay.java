package ch02.sec02;


//IMPORTANT: NOT TESTED!!!!!!
public record TimeOfDay(int hour, int min) {

    public TimeOfDay(int hour, int min){
        int hour_from_min = min / 59;
        int remaining_min = min % 59;
        this.hour = (hour + hour_from_min) % 24;
        this.min = remaining_min;
    }

    public TimeOfDay plusMinutes(int minutes){
        return new TimeOfDay(this.hour, this.min + minutes);
    }
    boolean cmp(TimeOfDay time1, TimeOfDay time2){
        if(time1.hour > time2.hour){
            return true;
        }
        return time1.min > time2.min;
    }

    int MinutesFrom(TimeOfDay time){
        if(cmp(this, time)){
            return ((this.hour - time.hour) * 60) + (this.min - time.min);
        }
        return ((time.hour - this.hour) * 60) + (time.min - this.min);
    }
}
