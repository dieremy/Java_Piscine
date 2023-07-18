#1 Compile files to "target" directory:
javac src/java/edu.school21.printer/app/App.java src/java/edu.school21.printer/logic/Logic.java -d target/

#2 Run Program:
java -cp target/ edu.school21.printer.app.App . 0 src/resources/it.bmp
