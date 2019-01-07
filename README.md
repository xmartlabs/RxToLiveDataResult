# RxToLiveDataResult

RxToLiveDataResult is a simple library conceived to transform a [RxJava](https://github.com/ReactiveX/RxJava) stream into a [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) stream of the [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/).
It's designed to work in a MVVM architecture using tree layers:

- Data/Model layer: data mapping layer and data source.
- Domain layer: business logic and interact between Data and Presentation layer.
- Presentation: UI layer.

The main idea of the library is to use **RxJava to the Domain and Model Layer** and **LiveData to the Presentation Layer**.

In other words, `RxJava` is used to work with the business logic and the data source layer whereas `LiveData` is using to work with the ui layer.

`RxToLiveDataResult` define one extension for each `RxJava` reactive class (`Flowable`, `Observable`, `Single`, `Completable`, `Maybe`) which transforms a `RxReactiveClass<T>` in a `LiveData<Result<T>>`.
For instance, you can convert an `Observable<String>` to a `LiveData<Result<String>>` calling the `.toResult()` extension method.

[Result<T>](library/src/main/java/com/xmartlabs/rxtolivedataresult/Result.kt) is the class that the library will use to notify the different states of the Rx stream.

It has 3 different values:
- `Result.Loading<Nothing>`: Notify that the Rx stream is loading.
- `Result.Success<T>`: Notify that the Rx stream emitted a correct value of the type `T`.
- `Result.Error<Nothing>`: Notify that the Rx stream emitted an error.


## Download

Add library to project dependencies with JitPack.
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.xmartlabs.RxToLiveDataResult:0.0.1'
}
```

## Getting involved

* If you **want to contribute** please feel free to **submit pull requests**.
* If you **have a feature request** please **open an issue**.
* If you **found a bug** check older issues before submitting a new one.

**Before contributing, please check the [CONTRIBUTING](CONTRIBUTING.md) file.**

## Changelog

The changelog for this project can be found in the [CHANGELOG](CHANGELOG.md) file.

## About
Made with ❤️ by [XMARTLABS](http://xmartlabs.com)
