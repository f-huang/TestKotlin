package Model
import java.util.HashMap
import kotlin.collections.Map
import kotlin.collections.List;

class gitmodel {

    private var main: Main = Main()
    private var wind: Wind = Wind()
    private var clouds: Clouds = Clouds()
    private var sys: Sys = Sys()

    private var weather = emptyList<Weather>()

    private var base: String = ""
    private var name: String = ""

    private var visibility: Int = 0
    private var dt: Int = 0
    private var id: Int = 0
    private var cod: Int = 0
    private var additionalProperties: MutableMap<String, Object> = HashMap<String, Object>()

    fun getMain(): Main = main
    fun getWind(): Wind = wind
    fun getClouds(): Clouds = clouds
    fun getSys(): Sys = sys
    fun getWeather(): List<Weather> = weather
    fun getBase(): String = base
    fun getName(): String = name
    fun getVisibility(): Int = visibility
    fun getDt(): Int = dt
    fun getId(): Int = id
    fun getCod(): Int = cod
    fun getAdditionalProperties() = additionalProperties

    fun setMain(main: Main) {
        this.main = main
    }

    fun setWind(wind: Wind) {
        this.wind = wind
    }

    fun setClouds(clouds: Clouds) {
        this.clouds = clouds
    }

    fun setSys(sys: Sys) {
        this.sys = sys
    }

    fun setWeather(weather: List<Weather>) {
        this.weather = weather
    }

    fun setBase(base: String) {
        this.base = base
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setVisibility(visibility: Int) {
        this.visibility = visibility
    }

    fun setDt(dt: Int) {
        this.dt = dt
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun setCod(cod: Int) {
        this.cod = cod
    }
    fun setAdditionalProperty(name: String, value: Object) =
            this.additionalProperties.put(name, value)

    class Clouds {

        private var all : Int = 0
        private var additionalProperties = HashMap<String, Object>()

        fun getAll(): Int = all

        fun setAll(all: Int) {
            this.all = all
        }

        fun getAdditionalProperties() = this.additionalProperties

        fun setAdditionalProperty(name: String, value: Object) =
            this.additionalProperties.put(name, value)

    }

   class Main {
       private var temp: Double = 0.0
       private var tempMin: Double = 0.0
       private var tempMax: Double = 0.0
       private var pressure: Int = 0
       private var humidity: Int = 0
       private var additionalProperties = HashMap<String, Object>()

       fun getTemp(): Double = temp
       fun getTempMin(): Double = tempMin
       fun getTempMax(): Double = tempMax
       fun getPressure(): Int = pressure
       fun getHumidity(): Int = humidity
       fun getAdditionalProperties() = this.additionalProperties

       fun setTemp(temp: Double) {
           this.temp = temp
       }

       fun setTempMin(temp: Double) {
           this.tempMin = temp
       }

       fun setTempMax(temp: Double) {
           this.tempMax = temp
       }

       fun setPressure(pressure: Int) {
           this.pressure = pressure
       }

       fun setHumidity(humidity: Int) {
           this.humidity = humidity
       }

       fun setAdditionalProperty(name: String, value: Object) =
               this.additionalProperties.put(name, value)
   }

    class Sys {

        private var type: Int = 0
        private var id: Int = 0
        private var sunrise: Long = 0
        private var sunset: Long = 0
        private var message: Double = 0.0
        private var country: String = ""
        private var additionalProperties = HashMap<String, Object>()

        fun getType() = type
        fun getId() = id
        fun getSunrise() = sunrise
        fun getSunset() = sunset
        fun getMessage() = message
        fun getCountry() = country
        fun getAdditionalProperties() = additionalProperties

        fun setType(value: Int) {
            this.type = value
        }
        fun setId(value: Int) {
            this.id = value
        }

        fun setSunrise(value: Long) {
            this.sunrise = value
        }
        fun setSunset(value: Long) {
            this.sunset = value
        }
        fun setMessage(value: Double) {
            this.message = value
        }
        fun setCountry(value: String) {
            this.country = value
        }
        fun setAdditionalProperty(name: String, value: Object) =
                this.additionalProperties.put(name, value)
    }

    class Weather {

        private var id: Int = 0
        private var main: String = ""
        private var description: String = ""
        private var icon: String = ""
        private var additionalProperties = HashMap<String, Object>()

        fun getId() = id
        fun getMain() = main
        fun getDescription() = description
        fun getIcon() = icon
        fun getAdditionalProperties() = additionalProperties

        fun setId(value: Int) {
            this.id = value
        }
        fun setMain(value: String) {
            this.main = value
        }
        fun setDescription(value: String) {
            this.description = value
        }
        fun setIcon(value: String) {
            this.icon = value
        }
        fun setAdditionalProperty(name: String, value: Object) =
                this.additionalProperties.put(name, value)
    }


    class Wind {

        private var deg = 0
        private var speed = 0.0
        private var additionalProperties = HashMap<String, Object>()

        fun getDeg() = deg
        fun getSpeed() = speed
        fun getAdditionalProperties() = additionalProperties

        fun setDeg(value: Int) {
            this.deg = deg
        }

        fun setSpeed(value: Double) {
            this.speed = speed
        }

        fun setAdditionalProperty(name: String, value: Object) =
                this.additionalProperties.put(name, value)
    }
}