:: Compile all the files
javac -encoding UTF-8 -d out2 -cp ".\lib\*;." ./src/core/*.java ./src/logic/*.java ./src/logic/ai/evaluation/*.java ./src/logic/ai/searchers/*.java ./src/othello/*.java ./src/ui/*.java ./src/utils/*.java ./test/core/*.java ./test/logic/*.java ./test/logic/ai/evaluation/*.java ./test/logic/ai/searchers/*.java ./test/othello/*.java ./test/ui/*.java ./test/utils/*.java

:: images are not imported, copy the image folder
IF not exist "./out2/ui/images" ( xcopy /S /I /Q /Y /F "./src/ui/images" "./out2/ui/images" )

:: Run the unit tests with console launcher and generate result.txt
java -jar .\lib\junit-platform-console-standalone-1.8.0-M1.jar --class-path out2 --scan-class-path >.\result.txt

:: Remove existing txt files
break>resultSummary.txt
break>failureSummary.txt

@echo off
setlocal enabledelayedexpansion

set check=Start
set found=NotStart
set failure=NotStart

:: Iterate through the result.txt
@echo off
for /f "tokens=*" %%s in (result.txt) do (
    :: Check if there is a test summary
    echo %%s | find "Test run finished" >nul
    if not errorlevel 1 (
        set found=Start
    )

    :: Check if there are any failures
    echo %%s | find "Failures" >nul
    if not errorlevel 1 (
        set failure=Start
    )

    :: Copy the test summary to the resultSummary.txt
    if "%check%"=="!found!" (
        echo %%s >> resultSummary.txt
    )

    :: Copy the failure to the failureSummary.txt
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

:: Merge resultSummary.txt and failureSummary.txt
echo. >>.\resultSummary.txt
copy .\resultSummary.txt + .\failureSummary.txt .\resultSummary.txt

::Run sendEmail.ps1
Powershell.exe -executionpolicy remotesigned -File  .\sendEmail.ps1