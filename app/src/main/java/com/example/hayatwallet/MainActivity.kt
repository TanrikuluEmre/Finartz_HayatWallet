package com.example.hayatwallet

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Cüzdan kısmını yap, ücret, para gönder vb butonları olacak aşağısında kartlar ve bilgileri yer alıcak
        // cüzdan kısmının aşağısında nav bar olacak en solda home butonu, ortada kampanyalar sayfası, sağda ise kullanıcı bilgileri yer alıcak
        // kampanyalar kısmı ve home recyclerview ile yapılacak


    }
}