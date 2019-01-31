package com.demo.mg.mykotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

abstract class RecycleViewAdapter<T>(private var dataList: MutableList<T>?) : RecyclerView.Adapter<ViewHolder>() {
    private val TAG = "RecycleViewAdapter"
    //存储监听回调
    private var onClickListeners: SparseArray<ItemClickListener>? = null

    interface ItemClickListener {
        fun onItemClicked(view: View, position: Int)
    }

    init {
        onClickListeners = SparseArray()
    }

    /**
     * 存储viewId对应的回调监听实例listener
     * @param viewId
     * @param listener
     */
    fun setOnItemClickListener(viewId: Int, listener: ItemClickListener) {
        val listener_ = onClickListeners!!.get(viewId)
        if (listener_ == null) {
            onClickListeners!!.put(viewId, listener)
        }
    }

    /**
     * 获取列表控件的视图id(由子类负责完成)
     * @param viewType
     * @return
     */
    abstract fun getLayoutId(viewType: Int): Int

    //更新itemView视图(由子类负责完成)
    abstract fun convert(holder: ViewHolder, t: T, position: Int)

    fun getItem(position: Int): T? {
        return if (dataList == null) null else dataList!![position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutId = getLayoutId(viewType)
        return ViewHolder.getViewHolder(parent, layoutId)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = dataList!![position]
        convert(holder, itemModel, position)//更新itemView视图
        //设置点击监听
        for (i in 0 until onClickListeners!!.size()) {
            val id = onClickListeners!!.keyAt(i)
            val view = holder.getView(id) ?: continue
            val listener = onClickListeners!!.get(id)
            view.setOnClickListener { v ->
                listener?.onItemClicked(v, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (dataList == null) 0 else dataList!!.size
    }

    fun destroyAdapter() {
        if (onClickListeners != null)
            onClickListeners!!.clear()
        onClickListeners = null

        if (dataList != null)
            dataList!!.clear()
        dataList = null
    }
}