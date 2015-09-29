package tarsakh.assignment_2;

import android.graphics.drawable.Drawable;

/**
 * Created by Tommy on 2015-09-09.
 */
public class Movie {
    String titel;
    String year;
    String beskrivning;

    int fan_Art;
    int poster;

        public Movie(String titel, String year, String beskrivning, int fan_Art, int poster) {
            this.titel = titel;
            this.year = year;
            this.beskrivning = beskrivning;
            this.fan_Art = fan_Art;
            this.poster = poster;
        }


    }
