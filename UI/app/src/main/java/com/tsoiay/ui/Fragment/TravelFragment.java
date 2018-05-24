package com.tsoiay.ui.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapView;
import com.tsoiay.ui.R;

public class TravelFragment extends Fragment {
    MapView mMapView = null;
    BaiduMap mBaiduMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.travel_fragment, container, false);
        mMapView = (MapView)view.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        setmMapView(mMapView);
        setmBaiduMap(mBaiduMap);

        return view;
    }

    private void setmMapView(MapView mMapView){
        mMapView.setLogoPosition(LogoPosition.logoPostionRightTop);
        mMapView.showZoomControls(false);
        mMapView.removeViewAt(2);
    }

    private void setmBaiduMap(BaiduMap mBaiduMap){
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setTrafficEnabled(true);
        mBaiduMap.setCompassEnable(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        mBaiduMap.setMyLocationEnabled(false);
        mlocationClient.stop();
        myOrientationListener.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在Fragment执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在Fragment执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在Fragment执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}
