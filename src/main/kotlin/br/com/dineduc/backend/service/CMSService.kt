package br.com.dineduc.backend.service

interface CMSService {
    fun getTrails(): String
    fun getCourse(id: Long) : String
    fun getActivity(id:Long) : String
}