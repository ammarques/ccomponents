## Introduction
A collection of Custom Views, that aim to reduce boilerplate code by create components that reuse good ui patherns.

## Installation
Donwload components *folder* on project root, and on Android Studio do as follow:
```bash
File -> Import Module -> components location.
File -> Project Structure -> Select the main project -> Dependencies -> add the components module.
(This can also be done directly on gradle files)
```
This is the first base commit, as I'll add more components this module will also be available on Maven Central, in order to simplify it's integration with gradle.

# Image Component
Just a image representation that uses a container RelativeLayout, ImageView, ProgressBar and Picasso in order to load imagens (local or remote), control its progress(show / hidde) and setup or not a fallback drawable.

## Adding programatically:
```
	String url = "URL_TO_YOUR_IMAGE";
	Image image = new Image(this,new ImageObject(false, url, R.drawable.no_image));
	image.setBackgroundColor(Color.BLACK); // no required, just easier to see the components dimention.
	image.setLayoutParams(params); // layoutparams lines intentionally ommited
	container.addView(image);
```

## Adding on XML:

```
    <lineto.org.components.Image
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"
        android:background="@android:color/black"
        android:layout_width="91dp"
        android:layout_height="91dp"
        app:img_url="URL_TO_YOUR_IMAGE"
        app:img_placeholder="@drawable/no_image"
        app:img_local="false"
        />
```

## Retriving it from XML and set or change it's image:
```
    String url = "URL_TO_YOUR_IMAGE";
    custom_image = (Image) findViewById(R.id.custom_image);
    custom_image.update(new ImageObject(false, url, R.drawable.no_image));
```

More details about its use, can be found at the Demo section.

## External documentation
*   Picasso repository if you desire consult it's documentation or change the component properties.
    [https://github.com/square/picasso](https://github.com/square/picasso)

*   This module uses Square's Picasso lib, you can and you probably should! check more about their incredible work here
    [https://github.com/square](https://github.com/square) 


## Roadmap
*   Add more components.

*   Add this module to Maven Central.

## License
Licensed under the Apache License, Version 2.0

You may obtain a copy of the License at:
[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0) 

   