package hr.ferit.josip.rmalv4_2.data.repository

import hr.ferit.josip.rmalv4_2.data.api.ApiHelper
import hr.ferit.josip.rmalv4_2.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}