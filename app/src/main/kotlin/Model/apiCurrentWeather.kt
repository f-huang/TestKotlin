package Model

import java.text.SimpleDateFormat
import java.util.*

class apiCurrentWeather {

    private var main = Main()
    private var wind = Wind()
    private var clouds = Clouds()
    private var sys = Sys()

    private var weather = emptyList<Weather>()

    private var name = ""

    fun getMain() = main
    fun getWind() = wind
    fun getClouds() = clouds
    fun getSys() = sys
    fun getWeather() = weather
    fun getName() = name

    class Clouds {
        private var all = 0

        fun getAll() = all.toString() + "%"
    }

    class Main {
        private var temp = 0.0
        private var humidity = 0

        fun getTemp(): Double = temp
        fun getHumidity() = humidity.toString() + "%"
    }

    class Sys {
        private var sunrise: Long = 0
        private var sunset: Long = 0
        private var country = ""

        private fun timestampToHour(timestamp: Long, format: String): String {
            val dateFormat = SimpleDateFormat(format, Locale.FRANCE)
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")

            return dateFormat.format(timestamp * 1000)
        }

        fun getSunrise() = timestampToHour(sunrise, "h:mm a")
        fun getSunset() = timestampToHour(sunset, "h:mm a")
        fun getCountry() = country

    }

    class Weather {
        private var main = ""

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