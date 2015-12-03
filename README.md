Loading Balls
-----------------
[![Download](https://api.bintray.com/packages/glomadrian/maven/MaterialCodeInput/images/download.svg) ](https://bintray.com/glomadrian/maven/loading-balls/_latestVersion)


A highly configurable library to do loading progress with animated balls for
Android



![Demo Screenshot][1]


How to use
----------

### Custom attributes


``` xml
lib:path="triangle"
```
The shape of the movement, available: 

	*  infinite
	*  square
	*  triangle
	*  circle
	*  diamond
	*  star


``` xml
lib:balls="3"
```
Number of balls used in the animation

``` xml
lib:movement_cycle_time="1500"
```
The time which the ball takes to do a complete cicle

``` xml
lib:enable_size_animation="true"
```
Enables the size animation in the balls (by default is false)

``` xml
lib:size_cycle_time="500"
```
The time it takes to the ball to grow up and decrease the size one time


``` xml
lib:ball_size="6dp"
```
Set the balls size

``` xml
lib:min_ball_size="5dp"
lib:max_ball_size="12dp"
```
To use with enable_size_animation="true", set the min and the max ball size

``` xml
lib:ball_colors="@array/colors"
```
Array of colors for the balls, if there are more balls than colors then repeat
color balls

``` xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <color name="ball1">#FFD91C</color>
  <color name="ball2">#FF4B4A</color>
  <color name="ball3">#3D8EFF</color>

  <integer-array name="colors">
    <item>@color/ball1</item>
    <item>@color/ball2</item>
    <item>@color/ball3</item>
  </integer-array>
</resources>
```
Sample colors array

For Gradle
---------------------

Add repository

```java
repositories {
  maven {
    url "http://dl.bintray.com/glomadrian/maven"
  }
}
```
Add dependency
```java
  compile 'com.github.glomadrian:loadingballs:1.1@aar'
```


### Some Samples

#### Default Infinite shape

![Sample][1]


``` xml
<com.github.glomadrian.loadingballs.BallView
     android:layout_margin="30dp"
     android:layout_width="100dp"
     android:layout_height="100dp"
     lib:balls="3"
     lib:movement_cycle_time="1500"
     lib:enable_size_animation="true"
     lib:size_cycle_time="500"
     lib:min_ball_size="5dp"
     lib:max_ball_size="12dp"
     lib:ball_colors="@array/colors"
     android:layout_gravity="center"
     />
```

#### Infinite shape without size animation

![Sample][2]

``` xml
<com.github.glomadrian.loadingballs.BallView
      android:layout_margin="30dp"
      android:layout_width="100dp"
      android:layout_height="100dp"
      lib:balls="3"
      lib:movement_cycle_time="1000"
      lib:enable_size_animation="false"
      lib:ball_colors="@array/colors"
      android:layout_gravity="center"
      />
```
#### Infinite shape with 5 balls

![Sample][3]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="5"
    lib:movement_cycle_time="1500"
    lib:enable_size_animation="true"
    lib:size_cycle_time="500"
    lib:min_ball_size="5dp"
    lib:max_ball_size="12dp"
    lib:ball_colors="@array/colors"
    android:layout_gravity="center"
    />
```

#### Triangle shape with 3 balls and size animation

![Sample][4]

``` xml
<com.github.glomadrian.loadingballs.BallView
       android:layout_margin="30dp"
       android:layout_width="100dp"
       android:layout_height="100dp"
       lib:balls="3"
       lib:movement_cycle_time="1500"
       lib:enable_size_animation="true"
       lib:size_cycle_time="500"
       lib:min_ball_size="5dp"
       lib:max_ball_size="12dp"
       lib:ball_colors="@array/colors"
       lib:path="triangle"
       android:layout_gravity="center"
       />
```

#### Triangle shape with 2 balls

![Sample][5]

``` xml
<com.github.glomadrian.loadingballs.BallView
        android:layout_margin="30dp"
        android:layout_width="100dp"
        android:layout_height="100dp"
        lib:balls="2"
        lib:movement_cycle_time="800"
        lib:enable_size_animation="false"
        lib:ball_colors="@array/colors"
        lib:path="triangle"
        android:layout_gravity="center"
        />
```

#### Square shape with 3 balls

![Sample][6]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="3"
    lib:movement_cycle_time="800"
    lib:enable_size_animation="false"
    lib:ball_colors="@array/colors"
    lib:path="square"
    android:layout_gravity="center"
    />
```

#### Square shape with 5 balls and size animation

![Sample][7]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="5"
    lib:movement_cycle_time="1200"
    lib:enable_size_animation="true"
    lib:size_cycle_time="500"
    lib:min_ball_size="5dp"
    lib:max_ball_size="12dp"
    lib:ball_colors="@array/colors"
    lib:path="square"
    android:layout_gravity="center"
    />
```

#### Circle shape with 3 balls and size animation

![Sample][8]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="3"
    lib:movement_cycle_time="1200"
    lib:enable_size_animation="true"
    lib:size_cycle_time="1500"
    lib:min_ball_size="5dp"
    lib:max_ball_size="12dp"
    lib:ball_colors="@array/colors"
    lib:path="circle"
    android:layout_gravity="center"
    />
```
#### Circle shape with 2 balls without size animation

![Sample][9]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="2"
    lib:movement_cycle_time="700"
    lib:enable_size_animation="false"
    lib:ball_colors="@array/colors"
    lib:path="circle"
    android:layout_gravity="center"
    />
```
#### Star shape with 10 balls without size animation

![Sample][10]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="10"
    lib:movement_cycle_time="2500"
    lib:enable_size_animation="false"
    lib:ball_colors="@array/colors"
    lib:path="star"
    lib:ball_size="5dp"
    android:layout_gravity="center"
    />
```
#### Star shape with 5 balls and size animation

![Sample][11]
``` xml
<com.github.glomadrian.loadingballs.BallView
         android:layout_margin="30dp"
         android:layout_width="100dp"
         android:layout_height="100dp"
         lib:balls="5"
         lib:movement_cycle_time="2500"
         lib:ball_colors="@array/colors"
         lib:path="star"
         lib:ball_size="5dp"
         lib:enable_size_animation="true"
         lib:size_cycle_time="800"
         lib:min_ball_size="5dp"
         lib:max_ball_size="8dp"
         android:layout_gravity="center"
         />
```
#### Star shape with 3 balls and size animation

![Sample][12]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="3"
    lib:movement_cycle_time="2500"
    lib:ball_colors="@array/colors"
    lib:path="star"
    lib:ball_size="5dp"
    lib:enable_size_animation="true"
    lib:size_cycle_time="800"
    lib:min_ball_size="5dp"
    lib:max_ball_size="8dp"
    android:layout_gravity="center"
    />
```
#### Diamond shape with 5 balls without size animation

![Sample][14]

``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="5"
    lib:movement_cycle_time="2500"
    lib:ball_colors="@array/colors"
    lib:path="diamond"
    lib:ball_size="6dp"
    android:layout_gravity="center"
    />
```
#### Diamond shape with 4 balls and size animation

![Sample][13]

``` xml
<com.github.glomadrian.loadingballs.BallView
         android:layout_margin="30dp"
         android:layout_width="100dp"
         android:layout_height="100dp"
         lib:balls="4"
         lib:movement_cycle_time="2500"
         lib:ball_colors="@array/colors"
         lib:path="diamond"
         lib:ball_size="5dp"
         lib:enable_size_animation="true"
         lib:size_cycle_time="800"
         lib:min_ball_size="5dp"
         lib:max_ball_size="8dp"
         android:layout_gravity="center"
         />
```
#### Diamond shape with 10 balls without size animation

![Sample][15]


``` xml
<com.github.glomadrian.loadingballs.BallView
    android:layout_margin="30dp"
    android:layout_width="100dp"
    android:layout_height="100dp"
    lib:balls="10"
    lib:movement_cycle_time="2500"
    lib:ball_colors="@array/colors"
    lib:path="diamond"
    lib:ball_size="4dp"
    android:layout_gravity="center"
    />
```

Developed By
------------
Adrián García Lomas - <glomadrian@gmail.com>
* [Twitter](https://twitter.com/glomadrian)
* [LinkedIn](https://es.linkedin.com/in/glomadrian )

License
-------

    Copyright 2015 Adrián García Lomas

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: ./art/1.gif
[2]: ./art/2.gif
[3]: ./art/3.gif
[4]: ./art/4.gif
[5]: ./art/5.gif
[6]: ./art/6.gif
[7]: ./art/7.gif
[8]: ./art/8.gif
[9]: ./art/9.gif
[10]: ./art/10.gif
[11]: ./art/11.gif
[12]: ./art/12.gif
[13]: ./art/13.gif
[14]: ./art/14.gif
[15]: ./art/15.gif
