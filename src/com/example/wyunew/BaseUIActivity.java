package com.example.wyunew;

import java.io.Serializable;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;



/**
 * Activity的基类 <br>
 * 封装了常用的方法
 * 
 * @author Jayin Ton
 * @version 1.0
 * @since version 1.0
 */
public abstract class BaseUIActivity extends SwipeBackActivity   {

	/**
	 * 初始化Layout UI 等等
	 */
	protected abstract void initLayout();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();
	
	

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	/**
	 * 以一个Class<?> cls启动一个Activity
	 * 
	 * @param cls
	 */
	public void openActivity(Class<?> cls) {
		this.startActivity(new Intent(this, cls));
	}

	/**
	 * 以一个intent来启动一个Activity
	 * 
	 * @param intent
	 */
	public void openActivity(Intent intent) {
		this.startActivity(intent);
	}

	/**
	 * 封装了Toast，直接toast（String content）
	 * 
	 * @param content
	 *            content of your want to Toast
	 */
	public void toast(String content) {
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 轻量封装findViewById(int id)
	 * 
	 * @param id
	 * @return
	 */
	public View _getView(int id) {
		return this.findViewById(id);
	}

	/**
	 * 用class 包装一个Intent;
	 * 
	 * @param cls
	 * @return
	 */
	public Intent wrapIntent(Class<?> cls) {
		return new Intent(this, cls);
	}

	/**
	 * 关闭Activity
	 */
	public void closeActivity() {
		this.finish();
	}

	/**
	 * 获得这个Activity的Context
	 * 
	 * @return
	 */
	public Context getContext() {
		return this;
	}

	/**
	 * 调试
	 * 
	 * @param content
	 */
	public void debug(String content) {
		Log.i("debug", this.getClass().getName() + ":" + content);
	}

	/**
	 * Get intent extra
	 * 
	 * @param name
	 * @return serializable
	 */
	@SuppressWarnings("unchecked")
	protected <V extends Serializable> V getSerializableExtra(final String name) {
		return (V) getIntent().getSerializableExtra(name);
	}

	/**
	 * Get intent extra
	 * 
	 * @param name
	 * @return int -1 if not exist!
	 */
	protected int getIntExtra(final String name) {
		return getIntent().getIntExtra(name, -1);
	}

	/**
	 * Get intent extra
	 * 
	 * @param name
	 * @return string
	 */
	protected String getStringExtra(final String name) {
		return getIntent().getStringExtra(name);
	}
	
	private SwipeBackLayout mSwipeBackLayout;
	private boolean enableSwipeBack = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		if(enableSwipeBack){
			mSwipeBackLayout  = getSwipeBackLayout();
			mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
		}
		
		setEnabledisplayHomeAsUp(true);
	}
	
	public void setActionBarTitle(CharSequence title){
		if(getActionBar()!=null){
			getActionBar().setTitle(title);
		}
	}
	
	public void setEnableSwipBack(boolean enable){
		this.enableSwipeBack = enable;
	}
	
	public void setEnabledisplayHomeAsUp(boolean enable){
		if(getActionBar()!=null){
			getActionBar().setDisplayHomeAsUpEnabled(enable);
		}
		
	}
	
	@Override public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			closeActivity();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
