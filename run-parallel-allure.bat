@echo off
setlocal enabledelayedexpansion

:: Get Maven-generated timestamp
for /f "delims=" %%i in ('mvn help:evaluate "-Dexpression=allure.timestamp" -q -DforceStdout') do (
    set "timestamp=%%i"
)

:: Optional: Set tag filter (e.g., @Smoke)
set "tagFilter=@Smoke"

:: Define browsers
set browsers=chrome firefox edge

:: Launch Maven tests in parallel
for %%B in (%browsers%) do (
    start "%%B" cmd /c ^
        mvn test ^
        "-Dcucumber.filter.tags=!tagFilter!" ^
        "-Dbrowser=%%B" ^
        "-Dallure.results.directory=target/allure-results_!timestamp!_%%B" ^
        "-Dallure.report.directory=target/allure-report_!timestamp!_%%B"
)

:: Wait for all Maven processes to finish
:waitloop
timeout /t 5 >nul
tasklist | findstr /i "java.exe" >nul
if %errorlevel%==0 goto waitloop

:: Generate Allure reports
for %%B in (%browsers%) do (
    echo Generating Allure report for %%B...
    allure generate "target/allure-results_!timestamp!_%%B" -o "target/allure-report_!timestamp!_%%B" --clean
)

echo All tests completed and reports generated.
