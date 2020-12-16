package com.studenthealth.android.ui.schedule

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.studenthealth.android.R
import com.studenthealth.android.util.pickerscrollview.CommonPopWindow
import com.studenthealth.android.util.pickerscrollview.GetConfigReq
import com.studenthealth.android.util.pickerscrollview.GetConfigReq.DatasBean
import com.studenthealth.android.util.pickerscrollview.PickerScrollView
import kotlinx.android.synthetic.main.fragment_schedule.*


class ScheduleFragment : Fragment(), CommonPopWindow.ViewClickListener {

    lateinit var datasBeanList: List<DatasBean>
    lateinit var categoryName: String
    lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        stepNumberScheduleConstrainLayout.setOnClickListener {
            initStepNumberScheduleData()
            text = it.findViewById(R.id.stepNumberSchedule)
            setAddressSelectorPopup(it)
        }
        exerciseDurationScheduleConstrainLayout.setOnClickListener {
            initExerciseDurationScheduleData()
            text = it.findViewById(R.id.exerciseDurationSchedule)
            setAddressSelectorPopup(it)
        }
        energyCostScheduleConstrainLayout.setOnClickListener {
            initEnergyCostScheduleData()
            text = it.findViewById(R.id.energyCostSchedule)
            setAddressSelectorPopup(it)
        }
        sportTimeScheduleConstrainLayout.setOnClickListener {
            initSportTimeScheduleData()
            text = it.findViewById(R.id.sportTimeSchedule)
            setAddressSelectorPopup(it)
        }
    }

    private fun setAddressSelectorPopup(v: View) {
        val screenHeigh = resources.displayMetrics.heightPixels
        CommonPopWindow.newBuilder()
            .setView(R.layout.pop_picker_selector_bottom)
            .setAnimationStyle(R.style.AnimUp)
            .setBackgroundDrawable(BitmapDrawable())
            .setSize(ViewGroup.LayoutParams.MATCH_PARENT, Math.round(screenHeigh * 0.3f))
            .setViewOnClickListener(this)
            .setBackgroundDarkEnable(true)
            .setBackgroundAlpha(0.7f)
            .setBackgroundDrawable(ColorDrawable(999999))
            .build(activity)
            .showAsBottom(v)
    }


    override fun getChildView(mPopupWindow: PopupWindow, view: View, mLayoutResId: Int) {
        when (mLayoutResId) {
            R.layout.pop_picker_selector_bottom -> {
                val imageBtn = view.findViewById<TextView>(R.id.img_guanbi)
                val addressSelector: PickerScrollView = view.findViewById(R.id.address)

                // 设置数据，默认选择第一条
                addressSelector.setData(datasBeanList)
                addressSelector.setSelected(0)

                //滚动监听
                addressSelector.setOnSelectListener { pickers ->
                    categoryName = pickers.categoryName
                }

                //完成按钮
                imageBtn.setOnClickListener {
                    mPopupWindow.dismiss()
                    text.setText(categoryName)
                }
            }
        }
    }


    private fun initStepNumberScheduleData() {
        //模拟请求后台返回数据
        val response = "{\"ret\":0,\"msg\":\"succes,\",\"datas\":[{\"ID\":\"  0\",\"categoryName\":\"\\u0031\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"1\",\"categoryName\":\"\\u0032\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"2\",\"categoryName\":\"\\u0033\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"3\",\"categoryName\":\"\\u0034\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"4\",\"categoryName\":\"\\u0035\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"5\",\"categoryName\":\"\\u0036\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"6\",\"categoryName\":\"\\u0037\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"7\",\"categoryName\":\"\\u0038\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"8\",\"categoryName\":\"\\u0039\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"9\",\"categoryName\":\"\\u0031\\u0030\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"10\",\"categoryName\":\"\\u0031\\u0031\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"11\",\"categoryName\":\"\\u0031\\u0032\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"12\",\"categoryName\":\"\\u0031\\u0033\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"13\",\"categoryName\":\"\\u0031\\u0034\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"14\",\"categoryName\":\"\\u0031\\u0035\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"15\",\"categoryName\":\"\\u0031\\u0036\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"16\",\"categoryName\":\"\\u0031\\u0037\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"17\",\"categoryName\":\"\\u0031\\u0038\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"18\",\"categoryName\":\"\\u0031\\u0039\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"},{\"ID\":\"19\",\"categoryName\":\"\\u0032\\u0030\\u0030\\u0030\\u0030\\u6b65\",\"state\":\"1\"}]}"
        val getConfigReq = Gson().fromJson(response, GetConfigReq::class.java)
        //0请求表示成功
        if (getConfigReq.ret == 0) {
            //滚动选择数据集合
            datasBeanList = getConfigReq.datas
        }
    }

    private fun initExerciseDurationScheduleData() {
        //模拟请求后台返回数据
        val response = "{\"ret\":0,\"msg\":\"succes,\",\"datas\":[{\"ID\":\"  0\",\"categoryName\":\"\\u0031\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"1\",\"categoryName\":\"\\u0032\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"2\",\"categoryName\":\"\\u0033\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"3\",\"categoryName\":\"\\u0034\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"4\",\"categoryName\":\"\\u0035\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"5\",\"categoryName\":\"\\u0036\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"6\",\"categoryName\":\"\\u0037\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"7\",\"categoryName\":\"\\u0038\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"8\",\"categoryName\":\"\\u0039\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"9\",\"categoryName\":\"\\u0031\\u0030\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"10\",\"categoryName\":\"\\u0031\\u0031\\u0030\\u5206\\u949f\",\"state\":\"1\"},{\"ID\":\"11\",\"categoryName\":\"\\u0031\\u0032\\u0030\\u5206\\u949f\",\"state\":\"1\"}]}"
        val getConfigReq = Gson().fromJson(response, GetConfigReq::class.java)
        //0请求表示成功
        if (getConfigReq.ret == 0) {
            //滚动选择数据集合
            datasBeanList = getConfigReq.datas
        }
    }

    private fun initEnergyCostScheduleData() {
        //模拟请求后台返回数据
        val response = "{\"ret\":0,\"msg\":\"succes,\",\"datas\":[{\"ID\":\"  0\",\"categoryName\":\"\\u0035\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"1\",\"categoryName\":\"\\u0031\\u0030\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"2\",\"categoryName\":\"\\u0031\\u0035\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"3\",\"categoryName\":\"\\u0032\\u0030\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"4\",\"categoryName\":\"\\u0032\\u0035\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"5\",\"categoryName\":\"\\u0033\\u0030\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"6\",\"categoryName\":\"\\u0033\\u0035\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"7\",\"categoryName\":\"\\u0034\\u0030\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"8\",\"categoryName\":\"\\u0034\\u0035\\u0030\\u5343\\u5361\",\"state\":\"1\"},{\"ID\":\"9\",\"categoryName\":\"\\u0035\\u0030\\u0030\\u5343\\u5361\",\"state\":\"1\"}]}"
        val getConfigReq = Gson().fromJson(response, GetConfigReq::class.java)
        //0请求表示成功
        if (getConfigReq.ret == 0) {
            //滚动选择数据集合
            datasBeanList = getConfigReq.datas
        }
    }

    private fun initSportTimeScheduleData() {
        //模拟请求后台返回数据
        val response = "{\"ret\":0,\"msg\":\"succes,\",\"datas\":[{\"ID\":\"  0\",\"categoryName\":\"\\u0032\\u6b21\",\"state\":\"1\"},{\"ID\":\"1\",\"categoryName\":\"\\u0034\\u6b21\",\"state\":\"1\"},{\"ID\":\"2\",\"categoryName\":\"\\u0036\\u6b21\",\"state\":\"1\"},{\"ID\":\"3\",\"categoryName\":\"\\u0038\\u6b21\",\"state\":\"1\"},{\"ID\":\"4\",\"categoryName\":\"\\u0031\\u0030\\u6b21\",\"state\":\"1\"},{\"ID\":\"5\",\"categoryName\":\"\\u0031\\u0032\\u6b21\",\"state\":\"1\"},{\"ID\":\"6\",\"categoryName\":\"\\u0031\\u0034\\u6b21\",\"state\":\"1\"},{\"ID\":\"7\",\"categoryName\":\"\\u0031\\u0036\\u6b21\",\"state\":\"1\"},{\"ID\":\"8\",\"categoryName\":\"\\u0031\\u0038\\u6b21\",\"state\":\"1\"},{\"ID\":\"9\",\"categoryName\":\"\\u0032\\u0030\\u6b21\",\"state\":\"1\"}]}"
        val getConfigReq = Gson().fromJson(response, GetConfigReq::class.java)
        //0请求表示成功
        if (getConfigReq.ret == 0) {
            //滚动选择数据集合
            datasBeanList = getConfigReq.datas
        }
    }
}