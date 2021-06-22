package pt.pedronnr.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import pt.pedronnr.teste.Fragments.FirstFragment
import pt.pedronnr.teste.Fragments.SecondFragment

class FragmentActivity : AppCompatActivity() {
    lateinit var flMain: FrameLayout
    lateinit var btnChange: Button
    lateinit var firstFrag: FirstFragment
    lateinit var secondFrag: SecondFragment
    var showFirst: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        flMain = findViewById(R.id.flMain)
        btnChange = findViewById(R.id.btnFragChange)

        if (savedInstanceState == null) {
            firstFrag = FirstFragment()
            secondFrag = SecondFragment()
        }

        changeFragment()
    }

    fun changeFragment() {
        val ft = supportFragmentManager.beginTransaction()
        val frag = if (showFirst) {
            firstFrag
        } else {
            secondFrag
        }
        showFirst = !showFirst

        ft.replace(R.id.flMain, frag)
        ft.commit()
    }

    fun btnFragChangeOnClick(view: View) {
        changeFragment()
    }
}