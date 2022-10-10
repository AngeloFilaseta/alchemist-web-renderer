# alchemist-web-renderer
[![Codiga Score Badge](https://api.codiga.io/project/34693/score/svg)](https://app.codiga.io/project/34693/dashboard)
[![Codiga Status Badge](https://api.codiga.io/project/34693/status/svg)](https://app.codiga.io/project/34693/dashboard)

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

A module to render an [Alchemist](https://alchemistsimulator.github.io/) Environment on a browser.

## Run the application
To deploy the application in a local environment, run the following command:

```shell
$ ./gradlew run
```

Then connect at the address `127.0.0.1:9090`.

## Test the application

To test the application run the following command:

```shell
$ ./gradlew check
```

A local installation on the Chrome Browser is required to run the tests.
The `CHROME_BIN` environment variable must be set to the path of the Chrome executable.
