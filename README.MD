This is a command line application that will receive as input a csv file, it will parse it and then will print out the results.

As an example, the expected outcome will look like this:

`cmd> quote.exe market.csv 1000`

`Requested amount: £1000`

`Rate: 7.0% `

`Monthly repayment: £30.78 `

`Total repayment: £1108.10`


`-------------------------------------------------------`

Application build
````

./gradlew clean build

````


*Jacoco Report* (if required to run separately)
````

./gradlew jacocoTestReport

````




*Run Application*
````

java -jar build/libs/test-int-smos-1.0-SNAPSHOT.jar
````