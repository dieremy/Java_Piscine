mkdir target

javac src/java/edu.school21.printer/app/App.java src/java/edu.school21.printer/logic/Logic.java -d target/

java -cp target/ edu.school21.printer.app.App . 0 src/resources/it.bmp
