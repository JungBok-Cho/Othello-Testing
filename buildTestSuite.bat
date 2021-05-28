javac -encoding UTF-8 -d out2 -cp ".\lib\*;." ./src/core/*.java ./src/logic/*.java ./src/logic/ai/evaluation/*.java ./src/logic/ai/searchers/*.java ./src/othello/*.java ./src/ui/*.java ./src/utils/*.java ./test/core/*.java ./test/logic/*.java ./test/logic/ai/evaluation/*.java ./test/logic/ai/searchers/*.java ./test/othello/*.java ./test/ui/*.java ./test/utils/*.java
IF not exist "./out2/ui/images" ( xcopy /S /I /Q /Y /F "./src/ui/images" "./out2/ui/images" )
java -jar .\lib\junit-platform-console-standalone-1.8.0-M1.jar --class-path out2 --scan-class-path >.\result.txt

break>resultSummary.txt
break>failureSummary.txt

@echo off
setlocal enabledelayedexpansion

set check=Start
set found=NotStart
set failure=NotStart
@echo off
for /f "tokens=*" %%s in (result.txt) do (
    echo %%s | find "Test run finished" >nul
    if not errorlevel 1 (
        set found=Start
    )

    echo %%s | find "Failures" >nul
    if not errorlevel 1 (
        set failure=Start
    )
    if "%check%"=="!found!" (
        echo %%s >> resultSummary.txt
    )

    if "%check%"=="!failure!" (
        echo %%s | find "Failures" >nul
        if not errorlevel 1 (
            echo %%s >> failureSummary.txt
        )

        echo %%s | find "MethodSource" >nul
        if not errorlevel 1 (
            echo %%s >> failureSummary.txt
        )
    )
)

echo. >>.\resultSummary.txt
copy .\resultSummary.txt + .\failureSummary.txt .\resultSummary.txt

Powershell.exe -executionpolicy remotesigned -File  .\sendEmail.ps1