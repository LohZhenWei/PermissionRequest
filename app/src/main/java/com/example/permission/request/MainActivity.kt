package com.example.permission.request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.simple.permission.checker.Permission
import com.simple.permission.checker.PermissionChecker

class MainActivity : AppCompatActivity() {

    private val permissionChecker = PermissionChecker()

    private var onPermissionGranted: (Boolean) -> Unit = {
        Log.d("test123333 ", "Permission Granted")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionChecker.register(this, true, onPermissionGranted)

    }

    override fun onResume() {
        super.onResume()
        permissionChecker.checkSpecificPermission(Permission.All)
    }
}