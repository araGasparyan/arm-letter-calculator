# Armenian letter calculator
Armenian letter calculator is a java based desktop application for converting an Armenian medieval numbering system to a decimal system and the opposite. The functionality of a simple calculator is included in the application as well. Check the Wiki article for more information about [Armenian numerals](https://en.wikipedia.org/wiki/Armenian_numerals).
<p align="center">
<img src="./capture.png" Alt="Armenian letter calculator by Ara Gasparyan" />
</p>

## Setup
(1) Change directory into the root of the project:
```sh
cd arm-letter-calculator
```

(2) Compile the source code and keep the bytecode in the **target** folder:
```sh
javac -d target src/calculator/*.java
```

(3) Create jar artifact (this step may depend on OS):
```sh
cp -r src/META-INF target/
cd target
mkdir artifact
jar cfvm artifact/calculator.jar META-INF/MANIFEST.MF calculator/*.class
```

(4) Run the calculator:
```sh
cd artifact
java -jar calculator.jar
```

## Usage
- Press **CN** button to convert a combination of Armenian letters to the corresponding decimal number
- Press **CL** button to convert a decimal number to the corresponding combination of Armenian letters

## License
Copyright © 2016, [Ara Gasparyan](https://aragasparyan.com).
Released under the [MIT License](https://opensource.org/licenses/MIT).