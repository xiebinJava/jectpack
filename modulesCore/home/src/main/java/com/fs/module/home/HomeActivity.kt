package com.fs.module.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fs.libbase.mvcbase.BaseComposeActivity
import com.fs.libnet.net.HttpCallBack
import com.fs.libnet.net.ICallBack
import com.fs.libnet.net.IHttpProcessor
import com.fs.libutils.constants.RoutConstant
import com.fs.module.home.country.data.CountryModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@Route(path = RoutConstant.Activity.HOME_ACTIVITY)
@AndroidEntryPoint
class HomeActivity : BaseComposeActivity() {

    @Inject
    lateinit var iHttpProcessor: IHttpProcessor

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val findViewById = findViewById<Button>(R.id.tv_home)
        val btViewMVI = findViewById<Button>(R.id.bt_view_mvi)
        val btPermission = findViewById<Button>(R.id.bt_permission)
        val btCompose = findViewById<Button>(R.id.bt_compose)
        val btCountry = findViewById<Button>(R.id.bt_country)
        val btMvp = findViewById<Button>(R.id.bt_mvp)
        findViewById.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.PRODUCT_DETAIL_ACTIVITY).navigation()
        }
        btViewMVI.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.PRODUCT_LOGIN).navigation()
        }
        btPermission.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.REQUEST_PERMISSION).navigation()
        }

        btCompose.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.COMPOSE_ACTIVITY).navigation()
        }

        btCountry.setOnClickListener {
            ARouter.getInstance().build(RoutConstant.Activity.HOME_COUNTRY_SELECT).navigation()
        }


        btMvp.setOnClickListener {

            ARouter.getInstance().build(RoutConstant.Activity.HOME_Sign_Up).navigation()

        }

        iHttpProcessor.post("", emptyMap(), object : HttpCallBack<CountryModel> {
            override fun onSuccess(result: CountryModel?) {

            }

            override fun onFailure(e: String) {
                super.onFailure(e)
            }


        })

    }
}