一个Android开发的公约插件，定义了工程约束插件，用于保持配置统一

主要代码来自于[nowinandroid](https://github.com/android/nowinandroid/blob/main/build-logic)，修改了部分局限的约束

# agp-convention-plugin

The [`build-logic`](https://github.com/android/nowinandroid/tree/main/build-logic) folder defines project-specific convention plugins, used to keep a single
source of truth for common module configurations.

This approach is heavily based on
[https://developer.squareup.com/blog/herding-elephants/](https://developer.squareup.com/blog/herding-elephants/)
and
[https://github.com/jjohannes/idiomatic-gradle](https://github.com/jjohannes/idiomatic-gradle).

By setting up convention plugins in `build-logic`, we can avoid duplicated build script setup,
messy `subproject` configurations, without the pitfalls of the `buildSrc` directory.

`build-logic` is an included build, as configured in the root
[`settings.gradle.kts`](https://github.com/android/nowinandroid/tree/main/build-logic).

Inside `build-logic` is a `convention` module, which defines a set of plugins that all normal
modules can use to configure themselves.

`build-logic` also includes a set of `Kotlin` files used to share logic between plugins themselves,
which is most useful for configuring Android components (libraries vs applications) with shared
code.

These plugins are *additive* and *composable*, and try to only accomplish a single responsibility.
Modules can then pick and choose the configurations they need.
If there is one-off logic for a module without shared code, it's preferable to define that directly
in the module's `build.gradle`, as opposed to creating a convention plugin with module-specific
setup.

Current list of convention plugins:

- [`nowinandroid.android.application`](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidApplicationConventionPlugin.kt),
  [`nowinandroid.android.library`](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidLibraryConventionPlugin.kt),
  [`nowinandroid.android.test`](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidTestConventionPlugin.kt):
  Configures common Android and Kotlin options.
- [`nowinandroid.android.application.compose`](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidApplicationComposeConventionPlugin.kt),
  [`nowinandroid.android.library.compose`](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidLibraryComposeConventionPlugin.kt):
  Configures Jetpack Compose options
