//package com.tsoiay.ui;
//
//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//import com.baidu.mapapi.map.MyLocationConfiguration;
//import com.baidu.mapapi.map.MyLocationData;
//
//public class MylocationListener implements BDLocationListener {
//    //定位请求回调接口
//    private boolean isFirstIn=true;
//    //定位请求回调函数,这里面会得到定位信息
//    @Override
//    public void onReceiveLocation(BDLocation bdLocation) {
//        //BDLocation 回调的百度坐标类，内部封装了如经纬度、半径等属性信息
//        //MyLocationData 定位数据,定位数据建造器
//        /*定位数据建造器
//         * 可以通过BDLocation配置如下参数
//         * 1.accuracy 定位精度
//         * 2.latitude 百度纬度坐标
//         * 3.longitude 百度经度坐标
//         * 4.satellitesNum GPS定位时卫星数目 getSatelliteNumber() gps定位结果时，获取gps锁定用的卫星数
//         * 5.speed GPS定位时速度 getSpeed()获取速度，仅gps定位结果时有速度信息，单位公里/小时，默认值0.0f
//         * 6.direction GPS定位时方向角度
//         * */
//        mLatitude= bdLocation.getLatitude();
//        mLongitude=bdLocation.getLongitude();
//        MyLocationData data= new MyLocationData.Builder()
//                .direction(mCurrentX)//设定图标方向
//                .accuracy(bdLocation.getRadius())//getRadius 获取定位精度,默认值0.0f
//                .latitude(mLatitude)//百度纬度坐标
//                .longitude(mLongitude)//百度经度坐标
//                .build();
//        //设置定位数据, 只有先允许定位图层后设置数据才会生效，参见 setMyLocationEnabled(boolean)
//        mBaiduMap.setMyLocationData(data);
//        //配置定位图层显示方式,三个参数的构造器
//        /*
//         * 1.定位图层显示模式
//         * 2.是否允许显示方向信息
//         * 3.用户自定义定位图标
//         *
//         * */
//        MyLocationConfiguration configuration
//                =new MyLocationConfiguration(locationMode,true,mIconLocation);
//        //设置定位图层配置信息，只有先允许定位图层后设置定位图层配置信息才会生效，参见 setMyLocationEnabled(boolean)
//        mBaiduMap.setMyLocationConfigeration(configuration);
//        //判断是否为第一次定位,是的话需要定位到用户当前位置
//        if(isFirstIn)
//        {
//            //地理坐标基本数据结构
//            LatLng latLng=new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
//            //描述地图状态将要发生的变化,通过当前经纬度来使地图显示到该位置
//            MapStatusUpdate msu= MapStatusUpdateFactory.newLatLng(latLng);
//            //改变地图状态
//            mBaiduMap.setMapStatus(msu);
//            isFirstIn=false;
//            Toast.makeText(context, bdLocation.getAddrStr(), Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
//}
