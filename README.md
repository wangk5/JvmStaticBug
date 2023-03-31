# JvmStatic Bug
JvmStatic bug in Kotlin 1.8

After upgrading to Kotlin 1.8.0, I'm getting an error that looks like
```
terminating due to uncaught exception of type java.lang.IncompatibleClassChangeError: The method 'SingletonClassExample.getCount()' was expected to be of type virtual but instead was found to be of type static
```

My rough understanding of the error is that SingletonClassExample was compiled thinking that getCount() is virtual and is surprised at runtime to see that it is static.

Looking at the ABI info for SingletonExampleClass.class in 1.8 (decompiled_1.8) vs in 1.8 (decompiled_1.8), I see that `getCount$annotations()` which has the RuntimeVisibleAnnotation for JvmStatic gets removed between Kotlin 1.7 and Kotlin 1.8. `getCount$annotations()` is also marked as deprecated in Kotlin 1.7.

Is this a @JvmStatic + get() bug in kotlin 1.8 or is there something that I'm missing after upgrading to 1.8?

