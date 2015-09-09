package tarsakh.assignment_2;

import android.graphics.drawable.Drawable;

/**
 * Created by Tommy on 2015-09-09.
 */
public class Movie {
    String titel;
    String year;
    String beskrivning;

    Drawable fan_Art;
    Drawable poster;


    public Movie(String titel, String year, String beskrivning, Drawable fan_Art, Drawable poster) {
        this.titel = titel;
        this.year = year;
        this.beskrivning = beskrivning;
        this.fan_Art = fan_Art;
        this.poster = poster;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public Drawable getFan_Art() {
        return fan_Art;
    }

    public void setFan_Art(Drawable fan_Art) {
        this.fan_Art = fan_Art;
    }

    public Drawable getPoster() {
        return poster;
    }

    public void setPoster(Drawable poster) {
        this.poster = poster;
    }
}
