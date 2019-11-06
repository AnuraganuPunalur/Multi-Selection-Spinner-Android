# Multi-Selection-Spinner-Android

This is a simple library created for the purpose of integrating Multi-Selection Spinner in Android which supports image along with spinner text.
You can set the spinner with and without image.

### *Demo*

![](https://raw.githubusercontent.com/AnuraganuPunalur/Multi-Selection-Spinner-Android/master/Mult-Selection%20Spinner%20Android.gif)

### Implementing this library is pretty easy, just follow the simple steps below.

### 1) Via Gradle

Step 1. In the project level gradle,

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. In the app level gradle,
```java
dependencies {
	            implementation 'com.github.AnuraganuPunalur:Multi-Selection-Spinner-Android:1.0'
	}
```  
### 2) Via Maven

Step 1. Add the JitPack repository to your build file 

```java
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```  
Step 2. Add the dependency

```java
<dependency>
	    <groupId>com.github.AnuraganuPunalur</groupId>
	    <artifactId>Multi-Selection-Spinner-Android</artifactId>
	    <version>1.0</version>
	</dependency>
```  
### You can simply add the MultiSpinner within the layout as shown below,

```java
    <com.anurag.multiselectionspinner.MultiSpinner
        android:id="@+id/spinnerMultiSpinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
 ```       
 ### And our code goes like this..
 
*Implement MultiSelectionSpinnerDialog.OnMultiSpinnerSelectionListener in your Activity/Fragment*
 
 1) Initialize the view like this,
 ```kotlin
 val multiSpinner : MultiSpinner = findViewById(R.id.spinnerMultiSpinner)
 ```
 2) Creating the list which contains the texts to display within the spinner,
 ```kotlin
    //List for storing text content for displaying it in the Spinner.
        val contentList : MutableList<String> = ArrayList()
        contentList.add("One")
        contentList.add("Two")
        contentList.add("Three")
        contentList.add("Four")
        contentList.add("Five")
```        
3) Creating the list which contains the URL's to display images within the spinner,
```kotlin
 //List for storing image URL's for displaying it in the Spinner.
        val urlList : MutableList<String> = ArrayList()
        urlList.add("https://cdn.pixabay.com/photo/2015/06/24/01/15/morning-819362_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2017/05/12/08/29/coffee-2306471_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/26/13/09/cup-of-coffee-1280537_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2013/08/11/19/46/coffee-171653_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2015/10/12/14/54/coffee-983955_960_720.jpg")
``` 
4) Setting adapter with image,
```kotlin
//Setting Multi Selection Spinner with image.
        multiSpinner.setAdapterWithImage(this,urlList,contentList,this)
```
5) Setting adapter without image,
```kotlin
//Setting Multi Selection Spinner without image.
      multiSpinner.setAdapterWithOutImage(this,contentList,this)
        
``` 
6) Initialize the MultiSpinner with features like this,
```kotlin
multiSpinner.initMultiSpinner(this,multiSpinner)
```
### You'll get all the selected items within the following overriden method after implementing the above mentioned interface like this,
```kotlin
override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {

        //This is where you get all your items selected from the Multi Selection Spinner :)
        for (i in chosenItems!!.indices){

            Log.e("chosenItems",chosenItems[i])
        }
    }
```    
*That's all, please don't hesitate to give a star if this library helped you*
