# CircleProgressView
圆形进度View

# Gredle
[![](https://jitpack.io/v/luod852456/CircleProgressView.svg)](https://jitpack.io/#luod852456/CircleProgressView)

# 例子
![](https://github.com/luod852456/CircleProgressView/blob/master/circleprogressview_01.png)

# XML
```xml
    <com.luodong.circleprogressview.CircleProgressView
        android:id="@+id/v_cpv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:progressColor="@android:color/holo_red_light"
        app:progressCur="78"
        app:progressMax="100"
        app:progressWeight="15dp"
        app:textColor="@android:color/holo_red_light"
        app:textSize="78sp"
        app:hasText="true"/>
```

|属性|效果|
|----|-----|
|textSize|字体大小|
|textColor|字体颜色|
|hasText|是否有百分比文字|
|progressColor|进度条颜色|
|progressWeight|进度条宽度|
|progressMax|最大进度|
|progressCur|当前进度|
