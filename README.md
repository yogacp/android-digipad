<p align="center">
<img alt="Android Digipad" src="https://raw.githubusercontent.com/yogacp/android-digipad/f81985354e931959da5d9b6747834d015af1726a/assets/digipad_sample.gif" width="35%" />
</p>

Android Digipad
========================================================
[![Version](https://img.shields.io/badge/version-0.1.0-green)](#) 
----------------------------------------------------------

Digipad is a simple library for Android that only show a numeric keyboard onscreen

### Adding dependencies
Add this to your build.gradle:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependencies in your app/build.gradle:
```groovy
dependencies {
    ....
    implementation 'com.github.yogacp:android-digipad:x.x.x'
}
```

### How to use the library
In your XML layout. Add the Digipad Layout **activity_sample.xml**:
```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
        ....
        
    <com.yogacp.digipad.view.Digipad
        android:id="@+id/digipad"
        android:layout_width="match_parent"
        android:layout_height="@dimen/no_space"
        android:layout_margin="@dimen/space_32"
        app:layout_constraintTop_toBottomOf="@+id/viewNumber"
        app:layout_constraintBottom_toBottomOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

In your **Activity**, add the default setup below:
```kotlin
class SampleActivity : AppCompatActivity() {

    //by viewBinding() is a binding delegation library
    private val binding: ActivitySampleBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set input max length
        binding.digipad.setMaxLength(inputMaxLength)

        //Set the theme color
        binding.digipad.setThemeColor(this, android.R.color.holo_blue_dark)

        //Set the listener
        binding.digipad.setOnDigipadClicked(object : OnDigipadClicked {
            override fun onClicked(numbers: String) {
                inputNumbers = numbers
                binding.etNumbers.setText(inputNumbers)

                if (inputNumbers.length == inputMaxLength) {
                    showMessage("Numbers: $inputNumbers")
                }
            }
        })
        ....
    }
}
```

PS: `by viewBinding()` is a binding delegation library from this github: <a href="https://github.com/yogacp/android-viewbinding" target="_blank">Android Viewbinding Delegation Library</a>


##### Happy coding :)
