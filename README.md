[![Build Status](https://travis-ci.org/dwyl/esta.svg?branch=master)](https://travis-ci.org/dwyl/esta)
![License](https://img.shields.io/badge/License-GPL%202.0-blue.svg)
# AR Example By Pure Android Application   
<br>
 <strong> pacakage name: [com.shimhg02.hyogeunexample.artodo] <br>
  SensorManager <br>
  AzimuthListener <br>
  LocationChange<br>
  Camera Permission<br>
  <strong>Google+ Core<br> <https://developers.google.com/android/guides/overview>
  
  
  
## Binaries - Binaries Docx is Copyed By ReactiveXGit- 


```xml
<dependency>
    <groupId>io.reactivex.rxjava2</groupId>
    <artifactId>rxkotlin</artifactId>
    <version>2.x.y</version>
</dependency>
```

and for Gradle:

```groovy
implementation 'io.reactivex.rxjava2:rxkotlin:x.y.z'
```

### RxKotlin 1.x 

Example for Maven:

```xmls
<dependency>
    <groupId>io.reactivex</groupId>
    <artifactId>rxkotlin</artifactId>
    <version>1.x.y</version>
</dependency>
```

and for Gradle:

```groovy
implementation 'io.reactivex:rxkotlin:x.y.z'
```

### Building with JitPack

You can also use Gradle or Maven with [JitPack](https://jitpack.io/) to build directly off a snapshot, branch, or commit of this repository.

For example, to build off the 2.x branch, use this setup for Gradle:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ReactiveX:RxKotlin:2.x-SNAPSHOT'
}
```

Use this setup for Maven:

```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

        <dependency>
	    <groupId>com.github.ReactiveX</groupId>
	    <artifactId>RxKotlin</artifactId>
	    <version>2.x-SNAPSHOT</version>
	</dependency>
```

Learn more about building this project with JitPack [here](https://jitpack.io/#ReactiveX/RxKotlin).



## Extensions 

|Target Type|Method|Return Type|Description|
|---|---|---|---|
|BooleanArray|toObservable()|Observable<Boolean>|Turns a Boolean array into an Observable|
|ByteArray|toObservable()|Observable<Byte>|Turns a Byte array into an Observable|
|ShortArray|toObservable()|Observable<Short>|Turns a Short array into an Observable|
|IntArray|toObservable()|Observable<Int>|Turns an Int array into an Observable|
|LongArray|toObservable()|Observable<Long>|Turns a Long array into an Observable|
|FloatArray|toObservable()|Observable<Float>|Turns a Float array into an Observable|
|DoubleArray|toObservable()|Observable<Double>|Turns a Double array into an Observable|
|Array<T>|toObservable()|Observable<Double>|Turns a `T` array into an Observable|
|IntProgression|toObservable()|Observable<Int>|Turns an `IntProgression` into an Observable|
|Iterable<T>|toObservable()|Observable<T>|Turns an `Iterable<T>` into an Observable|
|Iterator<T>|toObservable()|Observable<T>|Turns an `Iterator<T>` into an Observable|
|Observable<T>|flatMapSequence()|Observable<R>|Flat maps each `T` emission to a `Sequence<R>`|
|Observable<Pair<A,B>>|toMap()|Single<Map<A,B>>|Collects `Pair<A,B>` emissions into a `Map<A,B>`|
|Observable<Pair<A,B>>|toMultimap()|`Single<Map<A, List<B>>`|Collects `Pair<A,B>` emissions into a `Map<A,List<B>>`|
|Observable<Observable<T>>|mergeAll()|Observable<T>|Merges all Observables emitted from an Observable|
|Observable<Observable<T>>|concatAll()|Observable<T>|Concatenates all Observables emitted from an Observable|
|Observable<Observable<T>>|switchLatest()|Observable<T>|Emits from the last emitted Observable|
|Observable<*>|cast()|Observable<R>|Casts all emissions to the reified type|
|Observable<*>|ofType()|Observable<R>|Filters all emissions to only the reified type|
|Iterable<Observable<out T>>|merge()|Observable<T>|Merges an Iterable of Observables into a single Observable|
|Iterable<Observable<out T>>|mergeDelayError()|Observable<T>|Merges an Iterable of Observables into a single Observable, but delays any error|
|BooleanArray|toFlowable()|Flowable<Boolean>|Turns a Boolean array into an Flowable|
|ByteArray|toFlowable()|Flowable<Byte>|Turns a Byte array into an Flowable|
|ShortArray|toFlowable()|Flowable<Short>|Turns a Short array into an Flowable|
|IntArray|toFlowable()|Flowable<Int>|Turns an Int array into an Flowable|
|LongArray|toFlowable()|Flowable<Long>|Turns a Long array into an Flowable|
|FloatArray|toFlowable()|Flowable<Float>|Turns a Float array into an Flowable|
|DoubleArray|toFlowable()|Flowable<Double>|Turns a Double array into an Flowable|
|Array<T>|toFlowable()|Flowable<Double>|Turns a `T` array into an Flowable|
|IntProgression|toFlowable()|Flowable<Int>|Turns an `IntProgression` into an Flowable|
|Iterable<T>|toFlowable()|Flowable<T>|Turns an `Iterable<T>` into an Flowable|
|Iterator<T>|toFlowable()|Flowable<T>|Turns an `Iterator<T>` into an Flowable|
|Flowable<T>|flatMapSequence()|Flowable<R>|Flat maps each `T` emission to a `Sequence<R>`|
|Flowable<Pair<A,B>>|toMap()|Single<Map<A,B>>|Collects `Pair<A,B>` emissions into a `Map<A,B>`|
|Flowable<Pair<A,B>>|toMultimap()|`Single<Map<A, List<B>>>`|Collects `Pair<A,B>` emissions into a `Map<A,List<B>>`|
|Flowable<Flowable<T>>|mergeAll()|Flowable<T>|Merges all Flowables emitted from an Flowable|
|Flowable<Flowable<T>>|concatAll()|Flowable<T>|Concatenates all Flowables emitted from an Flowable|
|Flowable<Flowable<T>>|switchLatest()|Flowable<T>|Emits from the last emitted Flowable|
|Flowable<Any>|cast()|Flowable<R>|Casts all emissions to the reified type|
|Flowable<Any>|ofType()|Flowable<R>|Filters all emissions to only the reified type|
|Iterable<Flowable<out T>>|merge()|Flowable<T>|Merges an Iterable of Flowables into a single Flowable|
|Iterable<Flowable<out T>>|mergeDelayError()|Flowable<T>|Merges an Iterable of Flowables into a single Flowable, but delays any error|
|Single<Any>|cast()|Single<R>|Casts all emissions to the reified type|
|Observable<Single<T>>|mergeAllSingles()|Observable<R>|Merges all Singles emitted from an Observable|
|Flowable<Single<T>>|mergeAllSingles()|Flowable<R>|Merges all Singles emitted from a Flowable|
|Maybe<Any>|cast()|Maybe<R>|Casts any emissions to the reified type|
|Maybe<Any>|ofType()|Maybe<R>|Filters any emission that is the reified type|
|Observable<Maybe<T>>|mergeAllMaybes()|Observable<T>|Merges all emitted Maybes|
|Flowable<Maybe<T>>|mergeAllMaybes()|Flowable<T>|Merges all emitted Maybes|
|Action|toCompletable()|Completable|Turns an `Action` into a `Completable`|
|Callable<out Any>|toCompletable()|Completable|Turns a `Callable` into a `Completable`|
|Future<out Any>|toCompletable()|Completable|Turns a `Future` into a `Completable`|
|(() -> Any)|toCompletable()|Completable|Turns a `(() -> Any)` into a `Completable`|
|Observable<Completable>|mergeAllCompletables()|Completable>|Merges all emitted Completables|
|Flowable<Completable>|mergeAllCompletables()|Completable|Merges all emitted Completables|
|Observable<T>|subscribeBy()|Disposable|Allows named arguments to construct an Observer|
|Flowable<T>|subscribeBy()|Disposable|Allows named arguments to construct a Subscriber|
|Single<T>|subscribeBy()|Disposable|Allows named arguments to construct a SingleObserver|
|Maybe<T>|subscribeBy()|Disposable|Allows named arguments to construct a MaybeObserver|
|Completable|subscribeBy()|Disposable|Allows named arguments to construct a CompletableObserver|
|Observable<T>|blockingSubscribeBy()|Unit|Allows named arguments to construct a blocking Observer|
|Flowable<T>|blockingSubscribeBy()|Unit|Allows named arguments to construct a blocking Subscriber|
|Disposable|addTo()|Disposable|Adds a `Disposable` to the specified `CompositeDisposable`|
|CompositeDisposable|plusAssign()|Disposable|Operator function to add a `Disposable` to this`CompositeDisposable`|



