package Model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List;

class apiCurrentWeather {

    private var main: Main = Main()
    private var wind: Wind = Wind()
    private var clouds: Clouds = Clouds()
    private var sys: Sys = Sys()

    private var weather = emptyList<Weather>()

    private var name: String = ""

    fun getMain(): Main = main
    fun getWind(): Wind = wind
    fun getClouds(): Clouds = clouds
    fun getSys(): Sys = sys
    fun getWeather(): List<Weather> = weather
    fun getName(): String = name

    class Clouds {
        private var all : Int = 0

        fun getStrAll(): String = all.toString() + "%"
    }

    class Main {
       private var temp: Double = 0.0
       private var humidity: Int = 0

       fun getTemp(): Double = temp
        fun getStrHumidity(): String = humidity.toString() + "%"
    }

    class Sys {
        private var sunrise: Long = 0
        private var sunset: Long = 0
        private var country: String = ""

        fun getCountry() = country

        private fun timestampToHour(timestamp: Long, format: String): String {
            val dateFormat = SimpleDateFormat(format, Locale.FRANCE)
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")

            return dateFormat.format(timestamp * 1000)
        }

        fun getSunrise(): String = timestampToHour(sunrise, "h:mm a")
        fun getSunset(): String = timestampToHour(sunset, "h:mm a")

    }

    class Weather {
        private var main: String = ""

        fun getMain() = main
    }


    class Wind {
        private var speed = 0.0

        fun convertSpeed(unit: String = "m/s") : String {
            val newSpeed: Double = when (unit) {
                "km/h" -> speed / 3.6
                else -> speed
            }
            return String.format("%.2f%s", newSpeed, " " + unit)
        }
    }
}