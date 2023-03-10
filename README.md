##目录结构
```
.
├── README.md
├── app
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src
│       └── main
│           ├── AndroidManifest.xml
│           └── java
│               └── com
│                   └── fs
│                       └── jectpack
│                           ├── APP.kt
│                           └── MainActivity.kt
├── build.gradle
├── modulesBase
│   ├── libBase
│   │   └── src
│   │       └── main
│   │           ├── AndroidManifest.xml
│   │           └── java
│   │               └── com
│   │                   └── fs
│   │                       └── libbase
│   │                           ├── BaseApplication.kt
│   │                           ├── mvcbase
│   │                           │   └── BaseComposeActivity.kt
│   │                           ├── mvibase
│   │                           │   ├── Action.kt
│   │                           │   ├── State.kt
│   │                           │   └── Store.kt
│   │                           ├── mvpbase
│   │                           │   ├── BaseMVPActivity.kt
│   │                           │   ├── BasePresenter.kt
│   │                           │   └── BaseView.kt
│   │                           ├── mvvmbase
│   │                           │   ├── BaseActivity.kt
│   │                           │   └── BaseViewModel.kt
│   │                           └── netbase
│   │                               ├── BaseRepository.kt
│   │                               ├── BaseUseCase.kt
│   │                               ├── CommonResponse.kt
│   │                               ├── DataResult.kt
│   │                               └── ErrorBean.kt
│   ├── libNet
│   │   └── src
│   │       └── main
│   │           ├── AndroidManifest.xml
│   │           └── java
│   │               └── com
│   │                   └── fs
│   │                       └── libnet
│   │                           ├── BaseHttpClient.kt
│   │                           ├── FsCookie.kt
│   │                           ├── HttpClient.kt
│   │                           ├── IApiEnvironment.kt
│   │                           ├── ResponseCodeHandler.kt
│   │                           └── net
│   │                               ├── HttpCallBack.kt
│   │                               ├── HttpModule.kt
│   │                               ├── ICallBack.kt
│   │                               ├── IHttpProcessor.kt
│   │                               └── OtherProcessor.kt
│   └── libUtils
│       └── src
│           └── main
│               ├── AndroidManifest.xml
│               └── java
│                   └── com
│                       └── fs
│                           └── libutils
│                               ├── cache
│                               │   ├── BaseCache.kt
│                               │   ├── FsCache.kt
│                               │   ├── ICacheFunction.kt
│                               │   └── MMKVCache.kt
│                               ├── constants
│                               │   ├── Constant.kt
│                               │   └── RoutConstant.kt
│                               └── utils
│                                   └── CommonUtils.kt
├── modulesCore
│   ├── category
│   │   └── src
│   │       └── main
│   │           ├── AndroidManifest.xml
│   │           ├── debug
│   │           │   └── AndroidManifest.xml
│   │           └── java
│   │               └── com
│   │                   └── fs
│   │                       └── module
│   │                           └── category
│   │                               ├── CategoryApiService.kt
│   │                               ├── compose
│   │                               ├── login
│   │                               ├── permission
│   │                               ├── product
│   │                               └── ui
│   └── home
│       ├── build.gradle
│       └── src
│           └── main
│               ├── AndroidManifest.xml
│               ├── assets
│               │   └── country.json
│               ├── debug
│               │   └── AndroidManifest.xml
│               └── java
│                   └── com
│                       └── fs
│                           └── module
│                               └── home
│                                   ├── HomeActivity.kt
│                                   ├── HomeApiService.kt
│                                   ├── country
│                                   ├── module
│                                   └── mvpdemo
├── modulesPublic
│   └── modulePay
│       └── src
│           └── main
│               ├── AndroidManifest.xml
│               └── java
│                   └── com
│                       └── fs
│                           └── modulepay
├── settings.gradle
└── tree.txt
```