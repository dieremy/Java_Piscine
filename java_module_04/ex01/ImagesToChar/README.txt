#1 Compile files to "target" directory:
javac src/java/edu.school21.printer/app/App.java src/java/edu.school21.printer/logic/Logic.java -d target

#2 Copy resources:
cp -r src/resources/ target/.

#3 Create jar:
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#4 Run program:
java -jar target/images-to-chars-printer.jar . 0
