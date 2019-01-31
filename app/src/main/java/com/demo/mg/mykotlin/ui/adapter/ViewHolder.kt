package com.demo.mg.mykotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewHolder(
    private val mConvertView: View//缓存itemView内部的子View
) : RecyclerView.ViewHolder(mConvertView) {
    private val mViews: SparseArray<View>

    init {
        mViews = SparseArray()
    }

    /**
     * 根据ItemView的id获取子视图View
     * @param viewId
     * @return
     */
    fun getView(viewId: Int): View? {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = mConvertView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view
    }

    companion object {

        /**
         * 加载layoutId视图并用LGViewHolder保存
         * @param parent
         * @param layoutId
         * @return
         */
        fun getViewHolder(parent: ViewGroup, layoutId: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
            return ViewHolder(itemView)
        }
    }
}
