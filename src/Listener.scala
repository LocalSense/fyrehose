package com.paulasmuth.fyrehose

import java.util.concurrent._
import java.io._
import java.net._
 
class Listener(port: Int){

   val sock = new ServerSocket(port)
   val clients = Executors.newCachedThreadPool() // FIXPAUL: evil!!!

   Fyrehose.log("listening on port " + port.toString())

   def listen = {
     while(true){
       val conn = new Endpoint(sock.accept())
       clients.execute(conn)
     }
   }

}