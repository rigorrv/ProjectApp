package net.android.projectapp.utility

object Connection {

    fun isConnected():Boolean{
        val command = "ping -c 1 google.com"
        return Runtime.getRuntime().exec(command).waitFor()==0
    }
}