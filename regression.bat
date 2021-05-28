javac -encoding UTF-8 -d out2 -cp ".\lib\*;." ./src/core/*.java ./src/logic/*.java ./src/logic/ai/evaluation/*.java ./src/logic/ai/searchers/*.java ./src/othello/*.java ./src/ui/*.java ./src/utils/*.java ./test/core/*.java ./test/logic/*.java ./test/logic/ai/evaluation/*.java ./test/logic/ai/searchers/*.java ./test/othello/*.java ./test/ui/*.java ./test/utils/*.java
IF not exist "./out2/ui/images" ( xcopy /S /I /Q /Y /F "./src/ui/images" "./out2/ui/images" )
java -jar .\lib\junit-platform-console-standalone-1.8.0-M1.jar --class-path out2 --scan-class-path >.\result.txt

set summary=0
set test=Test run finished
@echo off
for /f "tokens=*" %%s in (result.txt) do (
    echo %%s
)