package pt.pedronnr.teste

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class AccelerometerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)
    }

    private val mSensorManager: SensorManager =
        getSystemService(Context.SENSOR_SERVICE) as SensorManager

    private val mSensorListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(se: SensorEvent) {
            val x: Float = se.values.get(0)
            val y: Float = se.values.get(1)
            val z: Float = se.values.get(2)
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(
            mSensorListener,
            mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        mSensorManager.unregisterListener(mSensorListener)
        super.onPause()
    }
}