package com.example.a13_hashpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plaintext: ByteArray = "password".toByteArray()

        val keygen = KeyGenerator.getInstance("HmacSHA256")
        keygen.init(256)
        val key: SecretKey = keygen.generateKey()

        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val ciphertext: ByteArray = cipher.doFinal(plaintext)

        // THe final hash message
        Log.d("PASSWORD1: ", ciphertext.toString())

    }
}