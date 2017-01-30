package test.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("toto1", "toto1")

        edit_city.requestFocus()
        edit_city.setIconifiedByDefault(false)
        edit_city.setSubmitButtonEnabled(true)

        edit_city.

        }
    }
}