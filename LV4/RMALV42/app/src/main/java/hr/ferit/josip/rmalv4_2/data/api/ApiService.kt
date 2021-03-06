package hr.ferit.josip.rmalv4_2.data.api

import hr.ferit.josip.rmalv4_2.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}