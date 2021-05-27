# marvel

## Description
This app uses [Marvel API](https://developer.marvel.com) with MVVM

* `MVVM` “Model-View-ViewModel” architecture
* `Build types` Two build types supported:
	* Develop
	* Release
*`Libraries`
    * Dagger with hilt component: simplify dagger di
    * Retrofit: make http calls
    * Http loggin interceptor: log calls & responses
    * Moshi: json converter
    * Glide: image loader

## Run Requirements
* Android 8+

## Compiling config
* look for .gradle folder (on Mac is hidden by default in user folder)
* create a file name gradle.properties if doesn't exist an paste your keys as shown:
PUBLIC_KEY = "yourPublicApiKey"
PRIVATE_KEY = "yourPrivateApiKey"

Sync project with gradle files, cross your fingers and start enjoying marvel world!
