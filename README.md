# Android Architecture Components Compose

Compose project based on Android recommended architecture

### Preview
| Light Mode                      | Dark Mode                      |
|---------------------------------|--------------------------------|
| ![Alt Text](/preview/light.gif) | ![Alt Text](/preview/dark.gif) |

[![PokemonCard](https://img.shields.io/badge/Download-APK-0F9D58)](https://github.com/chohohee/android-architecture-components-compose/raw/main/preview/app-release.apk)

### Features
- List of all Pokemon
- View Pokemon attribute details
- All Pokemon Attributes and Related Pokemon
- Theme setting mode

### Architecture
- [Recommended App Architecture](https://developer.android.com/topic/architecture#recommended-app-arch)
- Layered Architecture
- Repository Pattern
- Multi-Module:
```
root
--- app
--- core
------ data
------ designsystem
------ domain
------ network
...
--- feature
------ main
------ pokemon
------ type
...
```

### Libraries 
- [Compose](https://developer.android.com/jetpack/compose) for building user interface and app components
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for aynsc
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) for rest api
- [Serialization](https://kotlinlang.org/docs/serialization.html) for parse response
- [JetPack](https://developer.android.com/jetpack)
  - lifecycle, navigation-compose, paging-compose, datastore, view model
- [Landscapist](https://github.com/skydoves/landscapist) for image loading
  - coil, plcaeholder, palette

### API
The API used in this project is [PokéAPI](https://pokeapi.co/) and the base url is as follows:
```
https://pokeapi.co/api/v2
```

#### Endoint Used
| Method | Endpoint                         | Usage                              |
| ------ | -------------------------------- | ---------------------------------- |
|GET     | `/pokemon?offset={0}&limit={20}` | Get All Pokemon Information Paging |
|GET     | `/pokemon/{bulbasaur}`           | Get Pokemon attribute information  | 
|GET     | `/type`                          | Get All Pokemon attributes         | 
|GET     | `/type/{1}`                      | Get All Pokemon of that attribute  | 
